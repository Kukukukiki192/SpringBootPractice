//package com.example.admin.interceptor;//package com.boot.interceptor;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.*;
//
///**
// * 拦截器应用
// *  处理流程
// *
// * 有一个登录页面，需要写一个Controller访问登录页面
// * 登录页面有一提交表单的动作。需要在Controller中处理。
// * a) 判断用户名密码是否正确（在控制台打印）
// *
// * b) 如果正确,向session中写入用户信息（写入用户名username）
// *
// * c) 跳转到商品列表
// *
// * 拦截器
// * a) 拦截用户请求，判断用户是否登录（登录请求不能拦截）
// *
// * b) 如果用户已经登录。放行
// *
// * c) 如果用户未登录，跳转到登录页面
// */
//
///**
// * 登录验证拦截器
// * 1、配置好拦截器要拦截哪些请求
// * 2、把这些配置放在容器中
// */
//@Slf4j
//public class LoginInterceptor implements HandlerInterceptor {
//
//    /**
//     * 目标方法执行之前
//     * @param request
//     * @param response
//     * @param handler
//     * @return
//     * @throws Exception
//     */
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String requestURI = request.getRequestURI();
//        log.info("preHandle拦截的请求路径是{}",requestURI);
//
//        //设置编码格式
//        response.setContentType("text/html;charset=utf-8");
//        response.setCharacterEncoding("utf-8");
//
//        //登录检查逻辑 若session为空，则未登录
//        HttpSession session = request.getSession();
//        Object account = session.getAttribute("account");
//        if(account == null){  //未登录,回到登录页面
////            //拦截住。未登录。跳转到登录页
////            request.setAttribute("msg","请先登录");
//////        re.sendRedirect("/");
////            request.getRequestDispatcher("/").forward(request,response);
//
//            //重定向到登录页面request.getContextPath():全局路径 可以是controller方法
//            response.sendRedirect(request.getContextPath()+"/login");
//            //未通过请求,此请求被拦截
//            return false;
//        }
//        //通过请求
//        return true;
//    }
//
//    /**
//     * 目标方法执行完成以后
//     * @param request
//     * @param response
//     * @param handler
//     * @param modelAndView
//     * @throws Exception
//     */
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        log.info("postHandle执行{}",modelAndView);
//    }
//
//    /**
//     * 页面渲染以后
//     * @param request
//     * @param response
//     * @param handler
//     * @param ex
//     * @throws Exception
//     */
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        log.info("afterCompletion执行异常{}",ex);
//    }
//}