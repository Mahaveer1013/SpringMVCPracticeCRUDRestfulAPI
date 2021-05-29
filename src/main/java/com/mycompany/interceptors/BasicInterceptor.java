/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.interceptors;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author Thammana Srinivas
 */
public class BasicInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = Logger.getLogger(BasicInterceptor.class.getName());
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        LOGGER.log(Level.INFO, "Inside preHandle, request: {0}", request);
        request.setAttribute("time1", System.currentTimeMillis());
        return true;
    }
    
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mv) {
        LOGGER.log(Level.INFO, "Inside postHandle, request: {0}", request);
        long processingTime;
        processingTime = System.currentTimeMillis() - (long) request.getAttribute("time1");
        LOGGER.log(Level.INFO, "Handler Method Processing Time : {0} milli seconds", processingTime);
    }
    
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object Handler, Exception ex) {
        System.out.println("-------------------------------------------------");
        if(ex!=null) LOGGER.log(Level.INFO, "Exception: {0}", ex);
    }
}
