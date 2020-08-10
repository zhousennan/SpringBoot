package com.zsn.controller;

import com.zsn.pojo.Class;
import com.zsn.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ClassController {
    @Autowired
    ClassService classService;
    @RequestMapping("login")

    public String  queryAllClass(Model model){
      List<Class> classList = classService.queryAllClass();
        model.addAttribute("classList",classList);
        return "index";
    }

}
