package com.example.erp01.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by hujian on 2019/3/23
 */
@Controller
public class StartController {

    private static final Logger logger = LoggerFactory.getLogger(StartController.class);

    @RequestMapping("/")
    public String start(HttpServletRequest request, Model model){
        model.addAttribute("bigMenuTag",0);
        model.addAttribute("menuTag",0);
        return "/index";
    }

}
