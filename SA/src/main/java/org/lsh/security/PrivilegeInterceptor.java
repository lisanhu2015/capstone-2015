package org.lsh.security;

import org.lsh.util.model.LoginUser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;

/**
 * Created by lsh on 15/3/4.
 */
public class PrivilegeInterceptor implements HandlerInterceptor{

    private static HashSet<String> acceptRoles;

    public PrivilegeInterceptor(HashSet<String> roles) {
        acceptRoles = roles;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        HttpSession session = request.getSession();
        LoginUser user = (LoginUser) session.getAttribute("login");
        if (user == null || !acceptRoles.contains(user.getRole())) {
            response.sendRedirect(request.getContextPath() + "/global/login");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
