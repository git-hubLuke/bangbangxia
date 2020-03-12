package com.example.bangbangxia.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.bangbangxia.domain.User;

/**
 * JWT工具类
 */
public class JwtUtils {
    //生成token
    public String getToken(User user){
        String token = "";
        token = JWT.create().withAudience(DateUtils.getDateTimStr(true)+"_"+ new Integer(user.getUser_id()).toString())
                .sign(Algorithm.HMAC256(user.getUser_password()));
        return token;
    }
}
