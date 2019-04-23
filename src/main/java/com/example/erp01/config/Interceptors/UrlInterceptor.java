package com.example.erp01.config.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by hujian on 2019/3/23
 */

@Component
public class UrlInterceptor  implements HandlerInterceptor {

    public UrlInterceptor(){super();}

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o)  {
        String localIP = null;
        try {
            localIP = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
//        if(localIP==null || !"192.168.3.26".equals(localIP)) {
//            return false;
//        }
        String requestURI = request.getRequestURI();
        if(!"/".equals(requestURI) && (request.getSession().getAttribute("userName")==null || request.getSession().getAttribute("role")==null)) {
            String path=request.getContextPath();
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            request.getSession().setAttribute("basePath", basePath);
            try {
                request.getRequestDispatcher("/").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
        if(request.getSession().getAttribute("basePath")==null){
            String path=request.getContextPath();
            String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
            request.getSession().setAttribute("basePath", basePath);
        }
        return true;
    }
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

    }
}
