package com.example.erp01.action;

import com.example.erp01.model.Wrong;
import com.example.erp01.service.WrongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller(value = "/wrong")
public class WrongController {

    @Autowired
    private WrongService wrongService;

    @RequestMapping(value = "/wrongStart")
    public String wrongStart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",55);
        return "miniProgram/wrong";
    }

    @RequestMapping(value = "/addwrong",method = RequestMethod.POST)
    @ResponseBody
    public int addWrong(Wrong wrong){
        int res = wrongService.addWrong(wrong);
        return res;
    }

    @RequestMapping(value = "/deletewrong",method = RequestMethod.POST)
    @ResponseBody
    public int deleteWrong(Integer wrongCodeID){
        int res = wrongService.deleteWrong(wrongCodeID);
        return res;
    }

    @RequestMapping(value = "/getallwrong",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllWrong(){
        Map<String,Object> map = new HashMap<>();
        List<Wrong> wrongList = wrongService.getAllWrong();
        map.put("data",wrongList);
        return map;
    }

}
