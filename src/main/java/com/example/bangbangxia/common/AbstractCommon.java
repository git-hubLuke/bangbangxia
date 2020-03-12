package com.example.bangbangxia.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public abstract class AbstractCommon {

    private static HttpSession session;

    public static HttpSession setSession(HttpServletRequest request) {
        session = request.getSession();
        return null;
    }

    public static HttpSession getSession() {
        return session;
    }



}
