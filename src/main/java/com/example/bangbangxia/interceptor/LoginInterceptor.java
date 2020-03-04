package com.example.bangbangxia.interceptor;

import annotation.Token;
import com.example.bangbangxia.domain.RespBean;
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

/**
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

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
            }
        }
        return false;
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
