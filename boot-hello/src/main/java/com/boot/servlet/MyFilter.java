package com.boot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = {"/css/*","/images/*"})//*单星servlet写法 **双星spring写法 未拦截/my
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("MyFilter初始化");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("MyFilter工作");
    }

    @Override
    public void destroy() {
        log.info("MyFilter销毁");
    }
}
