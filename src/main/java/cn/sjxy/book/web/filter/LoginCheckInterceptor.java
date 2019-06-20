package cn.sjxy.book.web.filter;


import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class LoginCheckInterceptor extends HandlerInterceptorAdapter{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1、如果用户已经登录 放行
        if(request.getSession().getAttribute("admin") != null){
            return true;
        }else {
            //2、非法请求 即这些请求需要登录后才能访问,重定向到登录页面
            response.sendRedirect(request.getContextPath()+"/login");
            return false;
        }
    }
}
