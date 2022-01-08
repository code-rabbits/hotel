package com.satr.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转
 */
@Controller
@RequestMapping("/sys")
public class SystemController {

    @RequestMapping("/login")
    public String Login(){
        return "login";
    }

    @RequestMapping("/index")
    public String Index(){
        return "index";
    }

    @RequestMapping("/main")
    public String Main(){
        return "main";
    }

}
