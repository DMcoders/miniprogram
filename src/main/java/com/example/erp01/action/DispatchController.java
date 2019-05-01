package com.example.erp01.action;


import com.example.erp01.model.Dispatch;
import com.example.erp01.service.DispatchService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller(value = "/dispatch")
public class DispatchController {

    @Autowired
    private DispatchService dispatchService;

    @RequestMapping(value = "/dispatchStart")
    public String dispatchSart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",52);
        return "miniProgram/dispatch";
    }


    @RequestMapping(value = "/adddispatch",method = RequestMethod.POST)
    @ResponseBody
    public int addDispatch(Dispatch dispatch){
        int res = dispatchService.addDispatch(dispatch);
        return res;
    }

    @RequestMapping(value = "/adddispatchbatch",method = RequestMethod.POST)
    @ResponseBody
    public int addDispatchBatch(@RequestParam("dispatchJson")String dispatchJson){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(dispatchJson);
            String orderName = json.get("orderName").getAsString();
            String procedureName = json.get("procedureName").getAsString();
            String groupName = json.get("groupName").getAsString();
            JsonArray array = json.get("emp").getAsJsonArray();
            List<Dispatch> dispatchList = new ArrayList<>();
            for (int i = 0; i < array.size(); i++) {
                JsonObject subObject = array.get(i).getAsJsonObject();
                String tmpEmpNum = subObject.get("employeeNumber").getAsString();
                String tmpEmpName = subObject.get("employeeName").getAsString();
                Dispatch dispatch = new Dispatch(tmpEmpNum,tmpEmpName,groupName,orderName,procedureName);
                dispatchList.add(dispatch);
            }
            int res = dispatchService.addDispatchBatch(dispatchList);
            return res;
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return 1;
    }

    @RequestMapping(value = "/deletedispatch",method = RequestMethod.POST)
    @ResponseBody
    public int deleteDispatch(@RequestParam("dispatchID")int dispatchID){
        int res = dispatchService.deleteDispatch(dispatchID);
        return res;
    }

    @RequestMapping(value = "/getalldispatch",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllDispatch(){
        Map<String,Object> map = new HashMap<>();
        List<Dispatch> dispatchList = new ArrayList<>();
        dispatchList = dispatchService.getAllDispatch();
        Collections.sort(dispatchList);
        map.put("data",dispatchList);
        return map;
    }

    @RequestMapping(value = "/getdispatchbyorder",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDispatchByOrder(@RequestParam("orderName")String orderName){
        Map<String,Object> map = new HashMap<>();
        List<Dispatch> dispatchList = new ArrayList<>();
        dispatchList = dispatchService.getDispatchByOrder(orderName);
        map.put("dispatchListOrderName",dispatchList);
        return map;
    }

    @RequestMapping(value = "/getdispatchbygroup",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDispatchByGroup(@RequestParam("groupName")String groupName){
        Map<String,Object> map = new HashMap<>();
        List<Dispatch> dispatchList = new ArrayList<>();
        dispatchList = dispatchService.getDispatchByGroup(groupName);
        map.put("dispatchListGroupName",dispatchList);
        return map;
    }

    @RequestMapping(value = "/getdispatchbyemp",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDispatchByEmp(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<Dispatch> dispatchList = new ArrayList<>();
        dispatchList = dispatchService.getDispatchByEmp(employeeNumber);
        map.put("dispatchListEmp",dispatchList);
        return map;
    }

}
