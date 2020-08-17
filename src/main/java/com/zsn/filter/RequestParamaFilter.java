package com.zsn.filter;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

/**
 * @Description RequestParamaFilter
 * @Author HymanHu
 * @Date 2020/8/17 9:22
 */
@WebFilter(filterName = "requestParamaFilter", urlPatterns = "/**")
public class RequestParamaFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletRequestWrapper servletRequestWrapper = new HttpServletRequestWrapper(httpRequest) {
            @Override
            public String getParameter(String name) {
                String value = httpRequest.getParameter(name);
                if (StringUtils.isNotBlank(value)) {
                    return value.replaceAll("fuck", "***");
                }
                return super.getParameter(name);
            }

            @Override
            public String[] getParameterValues(String name) {
                String[] value = httpRequest.getParameterValues(name);
                if (value != null && value.length > 0) {
                    for (int i = 0; i < value.length; i++) {
                        value[i] = value[i].replaceAll("fuck", "***");
                    }
                    return value;
                }

                return super.getParameterValues(name);
            }
        };

        chain.doFilter(servletRequestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
