package com.example.bangbangxia.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.bangbangxia.annotation.Token;
import com.example.bangbangxia.common.AbstractCommon;
import com.example.bangbangxia.domain.User;
import com.example.bangbangxia.utils.DateUtils;
import com.example.bangbangxia.utils.RespBean;
import com.example.bangbangxia.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Value("${token.timeout}")
    private long timeout;

    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        String token = request.getHeader("loginToken");//从http请求头中取出token
        if (!(object instanceof HandlerMethod)){
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();

        //检查是否有passtoken认证，有则跳过认证
        if (method.isAnnotationPresent(Token.PassToken.class)){
            Token.PassToken passToken = method.getAnnotation(Token.PassToken.class);
            if (passToken.required()){
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(Token.LoginToken.class)){
            Token.LoginToken loginToken = method.getAnnotation(Token.LoginToken.class);
            if (loginToken.required()){
                //执行认证
                if (token == null){
                    returnJsonResult(response,"用户未登录",403);//服务器拒绝访问
                    logger.debug("用户未登录");
                    return false;
                }
                //解析token
                String[] parseToken;
                try {
                    parseToken = (JWT.decode(token).getAudience().get(0).split("_"));//解析token并按_分割获取时间和user_id
                    if (parseToken.length > 0){
                        if (timeout > 0){ //timeout小于0或者负数代表永不过期
                            Date tokenDate = DateUtils.strToDate(parseToken[0],"yyyy-mm-dd hh:mm:ss");
                            long time = DateUtils.getTime(new Date()) - DateUtils.getTime(tokenDate);
                            if (time > timeout){
                                returnJsonResult(response,"您的token已过期，请重新登录",403);
                                return false;
                            }
                        }
                    }
                } catch (JWTDecodeException j) {
                   returnJsonResult(response,"用户未登录",403);
                   logger.debug("token解析失败");
                   return false;
                }
                User user = userService.findUserById(Integer.parseInt(parseToken[1]));//根据id查询用户
                if (user == null){
                    returnJsonResult(response,"用户不存在，请重新登录",500);//服务器错误
                    logger.debug("用户不存在，请重新登录");
                    return false;
                }
                //验证token
                JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getUser_password())).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    returnJsonResult(response,"用户不存在，请重新登录",500);
                    logger.debug("验证token失败");
                    return false;
                }
                AbstractCommon.setSession(request);
                AbstractCommon.getSession().setAttribute("user",user);
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) throws Exception {

    }

    /**
     * 返回错误信息：json格式
     * @param response
     * @param msg
     * @param status
     * @throws IOException
     */
    public void returnJsonResult(HttpServletResponse response, String msg, int status) throws IOException{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        writer = response.getWriter();
        writer.print(RespBean.toJson(status,msg,null));
    }
}
