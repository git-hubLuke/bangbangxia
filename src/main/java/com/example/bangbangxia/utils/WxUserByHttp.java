package com.example.bangbangxia.utils;

import com.alibaba.fastjson.JSON;
import com.example.bangbangxia.domain.Token;
import com.example.bangbangxia.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WxUserByHttp {
    @Value("${appid}")
    private String appid;
    @Value("${secret}")
    private String secret;
    @Value("${grant_type}")
    private String grant_type;
    @Value("${token_urlImpl}")
    private String token_urlImpl;
    @Value("${user_urlImpl}")
    private String user_urlImpl;



    public User getUser(String code){
        System.out.println("来自微信服务器回调");
        System.out.println("code:"+code);
        //判断
        if (code==null){
            throw new RuntimeException("用户禁止授权");
        }
        try {
            String token_url=token_urlImpl+"?appid="+appid+"&secret="+secret+"&code="+code+"&grant_type="+grant_type;
            // 发送请求
            HttpClient httpClient=new HttpClient(token_url);
            httpClient.get();
            String token_content=httpClient.getContent();
            Token token = JSON.parseObject(token_content, Token.class);
            // 获取到接口调用凭证
            // 获取个人的信息
            String user_url = user_urlImpl+"?access_token="+token.getAccess_token()+"&openid="+token.getOpenid();
            httpClient.setUrl(user_url);
            httpClient.get();
            String user_content = httpClient.getContent();
            // 解析json字符串
            System.out.println(user_content);
            User user = JSON.parseObject(user_content, User.class);

            System.out.println("微信用户信息："+user.toString());
            return user;
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("微信扫描登录异常...");
        }

    }
}
