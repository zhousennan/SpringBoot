package com.zsn.config;

import com.zsn.filter.RequestParamaFilter;
import com.zsn.interceptor.RequestViewInterceptor;
import org.apache.catalina.connector.Connector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Connection;

@Configuration
@AutoConfigureAfter({WebMvcAutoConfiguration.class})
public class WebMvcConfig implements WebMvcConfigurer {
    @Value("${server.http.port}")
    private int port;
    @Autowired
    private RequestViewInterceptor requestViewInterceptor;
    @Bean
    public Connector connector() {
        Connector connector = new Connector();
        connector.setPort(port);
        connector.setScheme("http");
        return connector;
    }

    @Bean
    public ServletWebServerFactory serverFactory() {
        TomcatServletWebServerFactory tomact = new TomcatServletWebServerFactory();
        tomact.addAdditionalTomcatConnectors(connector());
        return tomact;
    }
    @Bean
    public FilterRegistrationBean<RequestParamaFilter> register(){
        FilterRegistrationBean<RequestParamaFilter> register=new FilterRegistrationBean<>();
        register.setFilter(new RequestParamaFilter());
        return register;
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestViewInterceptor).addPathPatterns("/**");
    }

}
