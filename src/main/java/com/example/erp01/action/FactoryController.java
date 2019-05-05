package com.example.erp01.action;

import com.example.erp01.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller(value = "/factory")
public class FactoryController {

    @Autowired
    private FactoryService factoryService;

    @RequestMapping(value = "/getaddressbyfactorycode", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,String> getAddressByFactoryCode(@RequestParam("factoryCode")String factoryCode){
        Map<String,String> map = new HashMap<>();
        String address = factoryService.getAddressByFactoryCode(factoryCode);
        map.put("data",address);
        return map;
    }

}
