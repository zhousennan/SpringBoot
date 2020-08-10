package com.zsn.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TestController {
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.sex}")
    private String sex;

    @RequestMapping("test")
    @ResponseBody
    public String testConfig() {
        System.out.println("=============="+name);
        StringBuffer stringBuffer=new StringBuffer();
        String s=stringBuffer.append(name).append(age).append(sex).toString();
        return s;
    }
}
