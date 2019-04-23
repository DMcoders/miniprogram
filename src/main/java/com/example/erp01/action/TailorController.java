package com.example.erp01.action;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.TailorService;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

//裁片基本操作，包括生成裁片信息，保存裁片信息，查询裁片数据等
@Controller(value = "/tailor")
public class TailorController {
    @Autowired
    private TailorService tailorService;

    /**
     * 进入扎号信息页面
     * @param model
     * @return
     */
    @RequestMapping("/tailorStart")
    public String tailorStart(Model model){
        model.addAttribute("bigMenuTag",2);
        model.addAttribute("menuTag",21);
        return "opaMsg/tailor";
    }

    /**
     * 进入录入裁片信息页面
     * @param model
     * @return
     */
    @RequestMapping("/addTailorStart")
    public String addTailorStart(Model model,String orderName){
        if(orderName == null) {
            model.addAttribute("type", "add");
        }else {
            model.addAttribute("orderName", orderName);
            model.addAttribute("type", "detail");
        }
        return "opaMsg/fb_addTailor";
    }

    /**
     * 生成裁床数据
     * @param tailorDataJson
     * @return
     */

    @RequestMapping(value = "/generatetailordata", method = RequestMethod.POST)
    @ResponseBody
    public String generateTailorData(@RequestParam("tailorDataJson")String tailorDataJson){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(tailorDataJson);
            String orderName = json.get("orderName").getAsString();
            String customerName = json.get("customerName").getAsString();
            int bedNumber = Integer.parseInt(json.get("bedNumber").getAsString());
            String jarName = json.get("jarName").getAsString();
            String colorName = json.get("colorName").getAsString();
            JsonObject jsonLayerCount = json.get("layerCount").getAsJsonObject();
            JsonObject jsonPartName = json.get("partName").getAsJsonObject();
            JsonObject jsonSizeRatio = json.get("sizeRatio").getAsJsonObject();
            Iterator iterator1 = jsonSizeRatio.entrySet().iterator();
            List<String> sizeList = new ArrayList<>();
            List<Integer> sizeCountList = new ArrayList<>();
            while (iterator1.hasNext()){
                Map.Entry entry = (Map.Entry) iterator1.next();
                String tmpkey =  entry.getKey().toString();
                int tmpvalue = Integer.parseInt(entry.getValue().toString().replace("\"",""));
                sizeList.add(tmpkey);
                sizeCountList.add(tmpvalue);
            }
            List<Integer> layerCountList = new ArrayList<>();
            List<String> partNameList = new ArrayList<>();
            Iterator iterator3 = jsonLayerCount.entrySet().iterator();
            while(iterator3.hasNext()){
                Map.Entry entry = (Map.Entry) iterator3.next();
                layerCountList.add(Integer.parseInt(entry.getValue().toString().replace("\"","")));
            }
            Iterator iterator4 = jsonPartName.entrySet().iterator();
            while(iterator4.hasNext()){
                Map.Entry entry = (Map.Entry) iterator4.next();
                partNameList.add(entry.getValue().toString().replace("\"",""));
            }
            List<String> totalSizeList = new ArrayList<>();
            for (int i=0; i<sizeList.size(); i++){
                for (int j=0; j<sizeCountList.get(i); j++){
                    totalSizeList.add(sizeList.get(i));
                }
            }
            List<Tailor> tailorList = new ArrayList<>();
            int tmpPackageNmber = 0;
            for (int i=0; i<layerCountList.size(); i++){
                for (int j=0; j<totalSizeList.size(); j++){
                    tmpPackageNmber += 1;
                    for (int k=0; k<partNameList.size(); k++){
                        String tmpTailorQcode = orderName+"-"+customerName+"-"+bedNumber+"-"+jarName+"-"+colorName+"-"+totalSizeList.get(j)+"-"+layerCountList.get(i)+"-"+tmpPackageNmber+"-"+partNameList.get(k);
                        Tailor tailor = new Tailor(orderName,customerName,bedNumber,jarName,colorName,totalSizeList.get(j),partNameList.get(k).replace("\"","").replace("\"",""),layerCountList.get(i),tmpPackageNmber,tmpTailorQcode);
                        tailorList.add(tailor);
                    }
                }
            }
            Gson gson = new Gson();
            String tailorJson = gson.toJson(tailorList);
            return tailorJson;
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return null;

    }


    /**
     * 保存裁床数据
     * @param tailorList
     * @return
     */

    @RequestMapping(value = "/savetailordata")
    @ResponseBody
    public int saveTailorData(@RequestParam("tailorList")String tailorList){
        Gson gson = new Gson();
        List<Tailor> tailorList1 = gson.fromJson(tailorList,new TypeToken<List<Tailor>>(){}.getType());
        int res = tailorService.saveTailorData(tailorList1);
        return res;
    }

    /**
     * 获取所有的裁床数据
     * @return
     */
    @RequestMapping(value = "/getalltailordata", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getAllTailorData(){
        List<Tailor> tailorList = tailorService.getAllTailorData();
        return tailorList;
    }


    @RequestMapping(value = "/gettailordatabyorder", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getAllTailorDataByOrder(@RequestParam("orderName")String orderName){
        List<Tailor> tailorList = tailorService.getAllTailorDataByOrder(orderName);
        return tailorList;
    }

    /**
     * 由订单号获取最大床号
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/getmaxbednumber", method = RequestMethod.GET)
    @ResponseBody
    public Integer getMaxBedNumber(@RequestParam("orderName")String orderName){
        Integer bedNumber = tailorService.getMaxBedNumber(orderName);
        return bedNumber;
    }


    @RequestMapping(value = "/getbednumberbyordername", method = RequestMethod.GET)
    @ResponseBody
    public Integer getBedNumberByOrderName(@RequestParam("orderName")String orderName){
        Integer bedNumber = tailorService.getMaxBedNumber(orderName);
        return bedNumber;
    }


    /**
     * 由订单号和床号获取裁床报表
     * @param orderName
     * @param bedNumber
     * @return
     */
    @RequestMapping(value = "/tailorreport", method = RequestMethod.GET)
    @ResponseBody
    public String getTailorReport(@RequestParam("orderName")String orderName,
                                  @RequestParam("bedNumber")int bedNumber){

        List<Object> reportList = tailorService.tailorReport(orderName, bedNumber);
        Gson gson = new Gson();
        String res = gson.toJson(reportList);
        return res;
    }



    /**
     * 花片出厂详情调用
     * @param orderName
     * @param bedNUmber
     * @return
     */
    @RequestMapping(value = "/getbyordernamebednum", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getTailorByOrderNameBedNum(@RequestParam("orderName")String orderName,
                                                   @RequestParam("bedNumber")int bedNUmber){
        List<Tailor> tailorList = tailorService.getTailorByOrderNameBedNum(orderName,bedNUmber);
        return tailorList;
    }


    /**
     * 花片出厂详情调用
     * @param orderName
     * @param bedNUmber
     * @param partName
     * @return
     */
    @RequestMapping(value = "/getbyordernamebednumpart", method = RequestMethod.GET)
    @ResponseBody
    public List<Tailor> getTailorByOrderNameBedNum(@RequestParam("orderName")String orderName,
                                                   @RequestParam("bedNumber")int bedNUmber,
                                                   @RequestParam("partName")String partName){
        List<Tailor> tailorList = tailorService.getTailorByOrderNameBedNumPart(orderName, bedNUmber, partName);
        return tailorList;
    }


    /**
     * 由订单号生成床号的提示
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/getbednumbersbyordername", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getBedNumbersByOrderName(@RequestParam("orderName")String orderName){
        Map<String,Object> result = new HashMap<>();
        List<Integer> bedNumList = tailorService.getBedNumbersByOrderName(orderName);
        result.put("bedNumList",bedNumList);
        return result;
    }

    /**
     * 由订单号生成尺码的提示
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/getsizenamesbyordername", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getSizeNamesByOrderName(@RequestParam("orderName")String orderName){
        Map<String,Object> result = new HashMap<>();
        List<String> sizeNameList = tailorService.getSizeNamesByOrderName(orderName);
        result.put("sizeNameList",sizeNameList);
        return result;
    }


    /**
     * 根据订单号和床号获取花片的数量
     * @param orderName
     * @param bedNUmber
     * @return
     */
    @RequestMapping(value = "/gettailorcountbyordernamebednum", method = RequestMethod.GET)
    @ResponseBody
    public int getTailorCountByOrderNameBedNum(@RequestParam("orderName")String orderName,
                                               @RequestParam("bedNumber")int bedNUmber){
        int tailorCount = tailorService.getTailorCountByOrderNameBedNum(orderName, bedNUmber);
        return tailorCount;
    }

    /**
     * 根据订单号生成部位的提示信息
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/getpartnamesbyordername",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object>  getPartNamesByOrderName(@RequestParam("orderName")String orderName){
        Map<String,Object> result = new HashMap<>();
        List<String> partNameList = tailorService.getPartNamesByOrderName(orderName);
        result.put("partNameList",partNameList);
        return result;
    }

    /**
     * 根据订单号、床号和部位获取数量
     */
    @RequestMapping(value = "/gettailorcountbyordernamebednumpart", method = RequestMethod.GET)
    @ResponseBody
    public Integer getTailorCountByOrderNameBedNumPart(@RequestParam("orderName")String orderName,
                                                       @RequestParam("bedNumber")int bedNumber,
                                                       @RequestParam("partName")String partName){
        int tmpCount = tailorService.getTailorCountByOrderNameBedNumPart(orderName, bedNumber, partName);
        return tmpCount;
    }

    /**
     * 月度裁床报表
     * @param year
     * @param month
     * @return
     */

    @RequestMapping(value = "/tailorMonthReport", method = RequestMethod.GET)
    @ResponseBody
    public String tailorMonthReport(@RequestParam("year")Integer year,
                                    @RequestParam("month")Integer month){
        String beginTimeStr = year.toString()+"-"+month.toString()+"-01";
        Integer tmpMonth = month + 1;
        String endTimeStr = year.toString()+"-"+tmpMonth.toString()+"-01";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            List<Object> monthReportList = tailorService.tailorMonthReport(sdf.parse(beginTimeStr),sdf.parse(endTimeStr));
            Gson gson = new Gson();
            String res = gson.toJson(monthReportList);
            return res;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 用作裁片查漏
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/gettailorinfobyname",method = RequestMethod.GET)
    @ResponseBody
    public String getTailorInfoByName(@RequestParam("orderName")String orderName){
        List<CutQueryLeak> tailorInfoList = tailorService.getTailorInfoByName(orderName);
        Gson gson = new Gson();
        String res = gson.toJson(tailorInfoList);
        return res;
    }

}
