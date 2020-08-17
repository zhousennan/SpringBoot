package com.zsn.modules.test.controller;

import com.zsn.modules.test.pojo.Class;
import com.zsn.modules.test.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
