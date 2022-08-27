package org.cetacean;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieDemo {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Cookie cookie = new Cookie("mcrwayfun",System.currentTimeMillis()+"");
        // 设置生命周期为MAX_VALUE
        cookie.setMaxAge(Integer.MAX_VALUE);
        resp.addCookie(cookie);
    }

}
