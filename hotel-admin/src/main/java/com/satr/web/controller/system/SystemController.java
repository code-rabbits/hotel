package com.satr.web.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于页面跳转
 */
@Controller
@RequestMapping("/login")
public class SystemController {

    @RequestMapping
    public String login(){
        return "login";
    }

}
