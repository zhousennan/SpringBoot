package com.zsn.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Component
@Slf4j
public class RequestViewInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (modelAndView==null || modelAndView.getViewName().startsWith("redirect")){
            return;
        }
        String path = request.getServletPath();
        log.info("****  "+path+"   **********");
        String template= (String) modelAndView.getModelMap().get("template");
        if (StringUtils.isBlank(template)){
            if (path.startsWith("/")){
                path=path.substring(1);
            }
            modelAndView.getModelMap().addAttribute("template",path.toLowerCase());
        }


        // TODo
        HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
