package com.zsn.modules.test.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/test")
public class TestController {

    /**
     * 127.0.0.1/test/testDesc?paramKey=fuck ---- get
     */
    @GetMapping("/testDesc")
    @ResponseBody
    public String testDesc(HttpServletRequest request,
                           @RequestParam(value = "paramKey") String paramValue) {
        String paramValue2 = request.getParameter("paramKey");
        return "This is test module desc." + paramValue + "==" + paramValue2;
    }

    @GetMapping("/index")
    public String toindex(){
        return "index2";
    }

}
