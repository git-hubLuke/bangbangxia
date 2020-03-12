package com.example.bangbangxia.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 创建两个注解，拦截器通过注释区分是否进行权限拦截
 */
public @interface Token {

    @Target({ElementType.METHOD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PassToken{
        boolean required() default true;
    }

    @Target({ElementType.METHOD,ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface LoginToken{
        boolean required() default true;
    }
}
