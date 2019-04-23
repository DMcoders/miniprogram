package com.example.erp01.action;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.OPABack;
import com.example.erp01.model.OpaQueryLeak;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.OPABackService;
import com.example.erp01.service.TailorService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@Controller(value = "/opaback")
public class OPABackController {

    @Autowired
    private OPABackService opaBackService;

    @Autowired
    private TailorService tailorService;


    /**
     * 进入花片回场页面
     * @param model
     * @return
     */
    @RequestMapping("/opaBackStart")
    public String opaBackStart(Model model) {
        model.addAttribute ("bigMenuTag", 2);
        model.addAttribute ("menuTag", 26);
        return "cutMarket/opaBack";
    }

    @RequestMapping("/opaBackQueryStart")
    public String opaBackQueryStart(Model model) {
        model.addAttribute ("bigMenuTag", 1);
        model.addAttribute ("menuTag", 14);
        return "orderMsg/opaBackReport";
    }


    @RequestMapping(value = "/addopaback", method = RequestMethod.POST)
    @ResponseBody
    public boolean addOPABack(@RequestParam("opaBackJson")String opaBackJson,
                             ModelMap map){
        JsonParser jsonParser = new JsonParser();
        boolean result = false;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(opaBackJson);
            JsonArray jsonArray = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonArray.iterator();
            List<OPABack> opaBackList = new ArrayList<>();
            while (iterator.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator.next();
                String tmp = next.toString().replace("\"","");
                String[] subQcode = tmp.split("-");
                String orderName = subQcode[0];
                String customerName = subQcode[1];
                String bedNumber = subQcode[2];
                String jarName = subQcode[3];
                String colorName = subQcode[4];
                String sizeName = subQcode[5];
                String layerCount = subQcode[6];
                String packageNumber = subQcode[7];
                String partName = subQcode[8];
                OPABack opaBack = new OPABack(orderName,customerName,Integer.parseInt(bedNumber),jarName,colorName,sizeName,partName,Integer.parseInt(layerCount),Integer.parseInt(packageNumber),tmp);
                opaBackList.add(opaBack);
            }
            int res = opaBackService.addOPABack(opaBackList);
            if (0 == res){
               // map.addAttribute("msg","添加成功！");
                result = true;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/getallopaback",method = RequestMethod.GET)
    public List<OPABack> getAllOPABack(){
        List<OPABack> opaBackList = new ArrayList<>();
        opaBackList = opaBackService.getAllOPABack();
        return opaBackList;
    }

    @RequestMapping(value = "/opabackquery",method = RequestMethod.GET)
    @ResponseBody
    public List<String> opaBackQuery(@RequestParam("orderName")String orderName,
                                     @RequestParam("bedNumber")int bedNumber){
        List<String> tailorQcodeList = opaBackService.opaBackQuery(orderName,bedNumber);
        return tailorQcodeList;
    }

    @RequestMapping(value = "/getopabackinfobyorderbedpart",method = RequestMethod.GET)
    @ResponseBody
    public String getOPABackInfoByOrderBedPart(@RequestParam("orderName")String orderName,
                                               @RequestParam("bedNumber")int bedNumber,
                                               @RequestParam("partName")String partName){
        List<OpaQueryLeak> opaBackInfoList = opaBackService.getOPABackInfoByOrderBedPart(orderName,bedNumber,partName);
        Gson gson = new Gson();
        String res = gson.toJson(opaBackInfoList);
        return res;
    }

    @RequestMapping(value = "/searchOpaQueryLeak",method = RequestMethod.GET)
    @ResponseBody
    public String searchOpaQueryLeak(@RequestParam("orderName")String orderName,
                                               @RequestParam("bedNumber")int bedNumber,
                                               @RequestParam("partName")String partName){
        List<OpaQueryLeak> opaBackInfoList = opaBackService.getOPABackInfoByOrderBedPart(orderName,bedNumber,partName);
        List<Tailor> tailorList = tailorService.getTailorByOrderNameBedNumPart(orderName, bedNumber, partName);
        Gson gson = new Gson();
        if(opaBackInfoList!=null && opaBackInfoList.size()>0 && (tailorList==null || tailorList.size()==0)) {
            String res = gson.toJson(opaBackInfoList);
            return res;
        }else if ((opaBackInfoList==null || opaBackInfoList.size()==0) && tailorList!=null && tailorList.size()!=0) {
            List<OpaQueryLeak> list = new LinkedList<>();
            for(Tailor tailor : tailorList) {
                OpaQueryLeak opaQueryLeak = new OpaQueryLeak();
                opaQueryLeak.setColorName(tailor.getColorName());
                opaQueryLeak.setSizeName(tailor.getSizeName());
                opaQueryLeak.setOutCount(tailor.getLayerCount());
                list.add(opaQueryLeak);
            }
            String res = gson.toJson(list);
            return res;
        }else if (opaBackInfoList!=null && opaBackInfoList.size()!=0 && tailorList!=null && tailorList.size()!=0) {
            for (Tailor tailor : tailorList) {
                Boolean flag = true;
                for (OpaQueryLeak opaQueryLeak : opaBackInfoList) {
                    if(opaQueryLeak.getColorName().equals(tailor.getColorName()) &&
                            opaQueryLeak.getSizeName().equals(tailor.getSizeName())) {
                        opaQueryLeak.setOutCount(tailor.getLayerCount());
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    OpaQueryLeak opaQueryLeak = new OpaQueryLeak();
                    opaQueryLeak.setColorName(tailor.getColorName());
                    opaQueryLeak.setSizeName(tailor.getSizeName());
                    opaQueryLeak.setOutCount(tailor.getLayerCount());
                    opaBackInfoList.add(opaQueryLeak);
                }
            }
            String res = gson.toJson(opaBackInfoList);
            return res;
        }else {
            return null;
        }
    }

}
