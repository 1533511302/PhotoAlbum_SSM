package top.maniy.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.maniy.entity.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuzonghua
 * @Package top.maniy.interceptor
 * @Description:
 * @date 2018/10/2 13:04
 */
public class Interceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //判断用户是否登陆，如果没有登录 重定向到登录页面 不放行 如果登录了就 放行
        //URL  http://localhost:8080/springmvc-mybatis/login.action
        //URI  /login.action
        String requestURI =request.getRequestURI();
        if(!requestURI.contains("/toLogin")) {
            User user = (User) request.getSession().getAttribute("user");

            if(null == user) {
                response.sendRedirect(request.getContextPath()+"/toLogin");
                return false;
            }
        }
        return true;

    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

