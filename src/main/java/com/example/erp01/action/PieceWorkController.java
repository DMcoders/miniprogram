package com.example.erp01.action;

import com.example.erp01.model.PieceWork;
import com.example.erp01.service.DispatchService;
import com.example.erp01.service.EmployeeService;
import com.example.erp01.service.OrderProcedureService;
import com.example.erp01.service.PieceWorkService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller(value = "/piecework")
public class PieceWorkController {

    @Autowired
    private PieceWorkService pieceWorkService;
    @Autowired
    private DispatchService dispatchService;


    @RequestMapping(value = "/pieceWorkStatisticStart")
    public String pieceWorkStatisticStart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",53);
        return "miniProgram/pieceWorkStatistic";
    }

    @RequestMapping(value = "/pieceWorkDetailStart")
    public String pieceWorkDetailStart(Model model){
        model.addAttribute("bigMenuTag",5);
        model.addAttribute("menuTag",54);
        return "miniProgram/pieceWorkDetail";
    }


    @RequestMapping(value = "/addpieceworkbatch",method = RequestMethod.POST)
    public int addPieceWorkBatch(@RequestParam("pieceWorkJson") String pieceWorkJson){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(pieceWorkJson);
            String employeeNumber = json.get("employeeNumber").getAsString();
            String orderName = json.get("orderName").getAsString();
            int bedNumber = Integer.parseInt(json.get("bedNumber").getAsString());
            String colorName = json.get("colorName").getAsString();
            int packageNumber = Integer.parseInt(json.get("packageNumber").getAsString());
            int layerCount = Integer.parseInt(json.get("layerCount").getAsString());
            List<String> procedureList = dispatchService.getProcedureNamesByOrderEmp(orderName,employeeNumber);
            List<PieceWork> pieceWorkList = new ArrayList<>();
            for (int i = 0; i < procedureList.size(); i++) {
                PieceWork pieceWork = null;
                pieceWork = new PieceWork(employeeNumber,orderName,bedNumber,colorName,packageNumber,layerCount,procedureList.get(i));
                pieceWorkList.add(pieceWork);
            }
            int res = pieceWorkService.addPieceWorkBatch(pieceWorkList);
            return res;
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return 1;

    }

    @RequestMapping(value = "/addpiecework",method = RequestMethod.POST)
    @ResponseBody
    public int addPieceWork(PieceWork pieceWork){
        int res = pieceWorkService.addPieceWork(pieceWork);
        return res;
    }

    @RequestMapping(value = "/deletepiecework",method = RequestMethod.POST)
    @ResponseBody
    public int deletePieceWork(Integer pieceWorkID){
        int res = pieceWorkService.deletePieceWork(pieceWorkID);
        return res;
    }

    @RequestMapping(value = "/getallpiecework",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllPieceWork(){
        Map<String,Object> map = new HashMap<>();
        List<PieceWork> pieceWorkList = new ArrayList<>();
        pieceWorkList = pieceWorkService.getAllPieceWork();
        map.put("data",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/getdetailpiecework",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getDetailPieceWork(@RequestParam("from") Date from,
                                                 @RequestParam("to")Date to,
                                                 @RequestParam("groupName")String groupName,
                                                 @RequestParam("employeeNumber")String employeeNumber){
        if("".equals(groupName)){
            groupName = null;
        }
        if("".equals(employeeNumber)){
            employeeNumber = null;
        }
        Map<String,Object> map = new HashMap<>();
        List<PieceWork> pieceWorkList = pieceWorkService.getDetailPieceWork(from, to, groupName, employeeNumber);
        map.put("detailPieceWork",pieceWorkList);
        return map;

    }

    @RequestMapping(value = "/getpieceworktoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getPieceWorkToday(){
        Map<String,Object> map = new HashMap<>();
        List<Object> pieceWorkList = pieceWorkService.getPieceWorkToday();
        map.put("pieceWorkToday",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/getpieceworkthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getPieceWorkThisMonth(){
        Map<String,Object> map = new HashMap<>();
        List<Object> pieceWorkList = pieceWorkService.getPieceWorkThisMonth();
        map.put("pieceWorkThisMonth",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/getpieceworkemptoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getPieceWorkEmpToday(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<PieceWork> pieceWorkList = pieceWorkService.getPieceWorkEmpToday(employeeNumber);
        map.put("pieceWorkEmpToday",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/getpieceworkempthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getPieceWorkEmpThisMonth(@RequestParam("employeeNumber")String employeeNumber){
        Map<String,Object> map = new HashMap<>();
        List<PieceWork> pieceWorkList = pieceWorkService.getPieceWorkEmpThisMonth(employeeNumber);
        map.put("pieceWorkEmpThisMonth",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/querypieceworktoday",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryPieceWorkToday(@RequestParam("groupName")String groupName,
                                                  @RequestParam("employeeNumber")String employeeNumber){
        if("".equals(groupName)){
            groupName = null;
        }
        if("".equals(employeeNumber)){
            employeeNumber = null;
        }
        Map<String,Object> map = new HashMap<>();
        List<Object> pieceWorkList = pieceWorkService.queryPieceWorkToday(groupName, employeeNumber);
        map.put("queryPieceWorkToday",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/querypieceworkthismonth",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryPieceWorkThisMonth(@RequestParam("groupName")String groupName,
                                                  @RequestParam("employeeNumber")String employeeNumber){
        if("".equals(groupName)){
            groupName = null;
        }
        if("".equals(employeeNumber)){
            employeeNumber = null;
        }
        Map<String,Object> map = new HashMap<>();
        List<Object> pieceWorkList = pieceWorkService.queryPieceWorkThisMonth(groupName, employeeNumber);
        map.put("queryPieceWorkThisMonth",pieceWorkList);
        return map;
    }

    @RequestMapping(value = "/querypiecework",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> queryPieceWork(@RequestParam("from") String from,
                                             @RequestParam("to")String to,
                                             @RequestParam("groupName")String groupName,
                                             @RequestParam("employeeNumber")String employeeNumber){
        if("".equals(groupName)){
            groupName = null;
        }
        if("".equals(employeeNumber)){
            employeeNumber = null;
        }
        Map<String,Object> map = new HashMap<>();
        try{
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Date fromDate = sdf.parse(from);
            Date toDate = sdf.parse(to);
            List<Object> pieceWorkList = pieceWorkService.queryPieceWork(fromDate, toDate, groupName, employeeNumber);
            map.put("queryPieceWork",pieceWorkList);
            return map;
        }catch (ParseException e){
            e.printStackTrace();
        }
        return map;

    }

}
