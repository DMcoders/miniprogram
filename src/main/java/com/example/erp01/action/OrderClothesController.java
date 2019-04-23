package com.example.erp01.action;

import com.example.erp01.model.CutQueryLeak;
import com.example.erp01.model.OrderClothes;
import com.example.erp01.service.OrderClothesService;
import com.example.erp01.service.TailorService;
import com.google.gson.*;
import org.omg.CORBA.PUBLIC_MEMBER;
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

@Controller(value = "/order")
public class OrderClothesController {

    @Autowired
    private OrderClothesService orderClothesService;

    @Autowired
    private TailorService tailorService;

    /**
     * 进入订单信息页面
     * @param model
     * @return
     */
    @RequestMapping("/orderStart")
    public String orderStart(Model model){
        model.addAttribute("bigMenuTag",1);
        model.addAttribute("menuTag",11);
        return "orderMsg/order";
    }

    /**
     * 进入订单录入页面
     * @param model
     * @return
     */
    @RequestMapping("/addOrderStart")
    public String addOrderStart(Model model,String orderName){
        if(orderName == null) {
            model.addAttribute("type", "add");
        }else {
            model.addAttribute("orderName", orderName);
            model.addAttribute("type", "detail");
        }
        return "orderMsg/fb_addOrder";
    }

    /**
     * 进入报表查询
     * @param model
     * @return
     */
    @RequestMapping("/cutReportStart")
    public String cutReportStart(Model model){
        model.addAttribute("bigMenuTag",1);
        model.addAttribute("menuTag",12);
        return "orderMsg/cutReport";
    }

    @RequestMapping("/storageReportStart")
    public String storageReportStart(Model model){
        model.addAttribute("bigMenuTag",1);
        model.addAttribute("menuTag",13);
        return "orderMsg/storageReport";
    }

    /**
     * 进入裁床查漏页面
     * @param model
     * @return
     */
    @RequestMapping("/cutQueryLeakStart")
    public String cutQueryLeakStart(Model model){
        model.addAttribute("bigMenuTag",1);
        model.addAttribute("menuTag",15);
        return "orderMsg/cutQueryLeak";
    }

    /**
     * 进入花片查漏页面
     * @param model
     * @return
     */
    @RequestMapping("/opaQueryLeakStart")
    public String opaQueryLeakStart(Model model){
        model.addAttribute("bigMenuTag",1);
        model.addAttribute("menuTag",16);
        return "orderMsg/opaQueryLeak";
    }

    /****
     * 测试未通过
     * @param orderclothesJson
     * @return
     */
    @RequestMapping("/commitorderclothes")
    @ResponseBody
    public int addOrderClothes(String orderclothesJson){
        JsonParser jsonParser = new JsonParser();
        int result = 1;
        try{
            JsonArray orderArray = (JsonArray) jsonParser.parse(orderclothesJson);
//            JsonArray orderArray = json.getAsJsonArray();
            List<JsonObject> objectList = new ArrayList<>();
            List<OrderClothes> orderClothesList = new ArrayList<>();
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (int i=0; i<orderArray.size();i++){
                JsonObject order = orderArray.get(i).getAsJsonObject();
//                String name = String.valueOf(i);
//                JsonObject order = tmporder.get(name).getAsJsonObject();
                String customerName = order.get("customerName").getAsString();
                String purchaseMethod = order.get("purchaseMethod").getAsString();
                String orderName = order.get("orderName").getAsString();
                String styleDescription = order.get("styleDescription").getAsString();
                String clothesVersionNumber = order.get("clothesVersionNumber").getAsString();
                String colorNumber = order.get("colorNumber").getAsString();
                String colorName = order.get("colorName").getAsString();
                JsonObject sizeObject = order.get("size").getAsJsonObject();
                String orderDate = order.get("orderDate").getAsString();
                String season = order.get("season").getAsString();
                String deadLine = order.get("deadLine").getAsString();
                List<String> sizeList = new ArrayList<>();
                List<Integer> sizeCountList = new ArrayList<>();
                Iterator iterator = sizeObject.entrySet().iterator();
                while(iterator.hasNext()){
                    Map.Entry entry = (Map.Entry) iterator.next();
                    if (!(entry.getValue() == "")){
                        String tmpkey =  entry.getKey().toString();
                        int tmpvalue = Integer.parseInt(entry.getValue().toString().replace("\"",""));
                        sizeList.add(tmpkey);
                        sizeCountList.add(tmpvalue);
                    }
                }
                for(int j=0;j<sizeList.size();j++){
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
                        OrderClothes orderClothes = new OrderClothes(customerName, purchaseMethod, orderName, styleDescription, clothesVersionNumber, colorNumber, colorName, sizeList.get(j), sizeCountList.get(j), sdf.parse(orderDate), season, sdf.parse(deadLine));
                        orderClothesList.add(orderClothes);
                    }catch (ParseException e) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        OrderClothes orderClothes = new OrderClothes(customerName, purchaseMethod, orderName, styleDescription, clothesVersionNumber, colorNumber, colorName, sizeList.get(j), sizeCountList.get(j), sdf.parse(orderDate), season, sdf.parse(deadLine));
                        orderClothesList.add(orderClothes);
                    }
                }
            }
            result = orderClothesService.addOrderClothes(orderClothesList);
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }


    @RequestMapping(value = "/getallorderclothes", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAllOrderClothes(){
        Map<String, Object> map = new HashMap();
        List<OrderClothes> orderClothesList = new ArrayList<>();
        orderClothesList = orderClothesService.getAllOrderClothes();
        map.put("data",orderClothesList);
        return map;
    }

    @RequestMapping(value = "/getordersummary", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getOrderSummary(){
        Map<String, Object> map = new HashMap();
        List<OrderClothes> orderClothesList = new ArrayList<>();
        orderClothesList = orderClothesService.getOrderSummary();
        map.put("data",orderClothesList);
        return map;
    }

    @RequestMapping(value = "/getorderbyname", method = RequestMethod.GET)
    @ResponseBody
    public List<OrderClothes> getByName(@RequestParam("orderName")String orderName){
        List<OrderClothes> orderClothesList = new ArrayList<>();
        orderClothesList = orderClothesService.getOrderByName(orderName);
        return orderClothesList;
    }

    @RequestMapping(value = "/deleteorderbyname")
    @ResponseBody
    public int deleteByName(@RequestParam("orderName")String orderName){
        return orderClothesService.deleteOrderByName(orderName);
    }

    @RequestMapping(value = "/getorderhint",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getOrderHint(@RequestParam("subOrderName")String subOrderName){
        Map<String,Object> result = new HashMap<>();
        List<String> orderNameList = orderClothesService.getOrderHint(subOrderName);
        result.put("orderNameList",orderNameList);
        return result;
    }

    @RequestMapping(value = "/getcolorhint",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getColorHint(@RequestParam("orderName")String orderName){
        Map<String,Object> result = new HashMap<>();
        List<String> colorList = orderClothesService.getColorHint(orderName);
        result.put("colorList",colorList);
        return result;
    }

    @RequestMapping(value = "/getcustomernamebyordername",method = RequestMethod.GET)
    @ResponseBody
    public String getCustomerNameByOrderName(@RequestParam("orderName")String orderName){
        String customerName = orderClothesService.getCustomerNameByOrderName(orderName);
        return customerName;
    }

    /**
     * 查询订单信息以用作裁床查漏
     * @param orderName
     * @return
     */
    @RequestMapping(value = "/getorderinfobyname",method = RequestMethod.GET)
    @ResponseBody
    public String getOrderInfoByName(@RequestParam("orderName")String orderName){
        List<CutQueryLeak> orderInfoList = orderClothesService.getOrderInfoByName(orderName);
        Gson gson = new Gson();
        String res = gson.toJson(orderInfoList);
        return res;
    }

    @RequestMapping(value = "/searchCutQueryLeak",method = RequestMethod.GET)
    @ResponseBody
    public String searchCutQueryLeak(@RequestParam("orderName")String orderName) {
        List<CutQueryLeak> orderInfoList = orderClothesService.getOrderInfoByName(orderName);
        List<CutQueryLeak> tailorInfoList = tailorService.getTailorInfoByName(orderName);
        Gson gson = new Gson();
        if(orderInfoList!=null && orderInfoList.size()>0 && (tailorInfoList==null || tailorInfoList.size()==0)) {
            String res = gson.toJson(orderInfoList);
            return res;
        }else if ((orderInfoList==null || orderInfoList.size()==0) && tailorInfoList!=null && tailorInfoList.size()!=0) {
            String res = gson.toJson(tailorInfoList);
            return res;
        }else if (orderInfoList!=null && orderInfoList.size()!=0 && tailorInfoList!=null && tailorInfoList.size()!=0) {
            for (CutQueryLeak tailorInfo : tailorInfoList) {
                Boolean flag = true;
                for (CutQueryLeak cutQueryLeak : orderInfoList) {
                    if(cutQueryLeak.getColorName().equals(tailorInfo.getColorName()) &&
                            cutQueryLeak.getSizeName().equals(tailorInfo.getSizeName())) {
                        cutQueryLeak.setLayerCount(tailorInfo.getLayerCount());
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    orderInfoList.add(tailorInfo);
                }
            }
            String res = gson.toJson(orderInfoList);
            return res;
        }else {
            return null;
        }
    }

}
