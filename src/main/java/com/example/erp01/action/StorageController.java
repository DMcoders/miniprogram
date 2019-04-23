package com.example.erp01.action;

import com.example.erp01.model.Storage;
import com.example.erp01.model.Tailor;
import com.example.erp01.service.StorageService;
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

import java.util.*;

//裁片出入库基本操作，包括裁片入库，裁片调库，裁片出库等
@Controller(value = "/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private TailorService tailorService;

    @RequestMapping(value = "/inStore", method = RequestMethod.POST)
    @ResponseBody
    public int inStore(@RequestParam("inStoreJson")String instoreJson,
                          ModelMap map){
        JsonParser jsonParser = new JsonParser();
        int result = 0;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(instoreJson);
            String storehouseLocation = json.get("cutStoreLocation").getAsString();
            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonTailorQcode.iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator.next();
                tailorQcodeList.add(next.toString());
            }
            List<Storage> storageList = new ArrayList<>();
            String firstTailorQcode = tailorQcodeList.get(0).replace("\"","");
            String[] subQcode = firstTailorQcode.split("-");
            String orderName = subQcode[0];
            String bedNumber = subQcode[2];
            String colorName = subQcode[4];
            String sizeName = subQcode[5];
            String partName = subQcode[8];
            List<Tailor> tailorList = tailorService.getTailorByOrderNameBedNumSizeColorPart(orderName,Integer.parseInt(bedNumber),sizeName,colorName,partName);
            for (int i = 0; i < tailorList.size(); i++) {
                Tailor t = tailorList.get(i);
                Storage storage = new Storage(storehouseLocation,t.getTailorQcode());
                storageList.add(storage);
            }
            int instoreCount = storageList.size();
            //Storage storage = new Storage(storehouseLocation,tailorQcodeList.get(i).replace("\"",""));
            //storageList.add(storage);
            //Gson gson = new Gson();
            //String storageJson = gson.toJson(storageList);
            //int res = storageService.inStore(storageJson);
            int res = storageService.inStore(storageList);
            if (0 == res){
                //map.addAttribute("msg","入库成功！");
                result = instoreCount;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/outstore", method = RequestMethod.POST)
    public String outStore(@RequestParam("outstoreJson")String outstoreJson,
                           ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(outstoreJson);
            Iterator iterator = json.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res = storageService.outStore(tailorQcodeList);
            if (0 == res){
                map.addAttribute("msg","出库成功！");
            }else{
                map.addAttribute("msg","出库失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }

    @RequestMapping(value = "/changeStore",method = RequestMethod.POST)
    @ResponseBody
    public boolean changeStore(@RequestParam("changestoreJson")String changestoreJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        boolean result = false;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(changestoreJson);
            String storehouseLocation = json.get("storehouseLocation").getAsString();
            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator2 = jsonTailorQcode.iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator2.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator2.next();
                tailorQcodeList.add(next.toString().replace("\"",""));
            }
            int res1 = storageService.outStore(tailorQcodeList);
            List<Storage> storageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                Storage storage = new Storage(storehouseLocation,tailorQcodeList.get(i));
                storageList.add(storage);
            }
            //Gson gson = new Gson();
            //String storageJson = gson.toJson(storageList);
            int res2 = storageService.inStore(storageList);
            if (0 == res1 && 0 == res2){
                //map.addAttribute("msg","调库成功！");
                result = true;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;
    }


    /**
     * 进入库存信息页面
     * @param model
     * @return
     */
    @RequestMapping("/storageStateStart")
    public String storageStateStart(Model model){
        model.addAttribute("bigMenuTag",2);
        model.addAttribute("menuTag",24);
        return "opaMsg/storageState";
    }

//    获取仓库存储状态信息
    @RequestMapping(value = "/getstoragestate", method = RequestMethod.GET)
    @ResponseBody
    public String getStorageState(){
        List<Storage> storageStateList = new ArrayList<>();
        storageStateList = storageService.getStorageState();
        Gson gson=new Gson();
        String storageStateJson=gson.toJson(storageStateList);
        return storageStateJson;
    }

    @RequestMapping(value = "/instoreStart")
    public String intoreStart(Model model){
        model.addAttribute("bigMenuTag", 2);
        model.addAttribute("menuTag", 22);
        return "cutMarket/cutInStore";
    }


//    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
//    @ResponseBody
//    public List<String> getMatch(@RequestParam("matchJson")String matchJson,
//                           ModelMap map){
//        JsonParser jsonParser = new JsonParser();
//        try{
//            JsonObject json = (JsonObject) jsonParser.parse(matchJson);
//            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
//            Iterator iterator = jsonTailorQcode.iterator();
//            List<String> tailorQcodeList = new ArrayList<>();
//            while(iterator.hasNext()){
//                JsonPrimitive next = (JsonPrimitive) iterator.next();
//                String tailorQcode = next.toString().replace("\"", "");
//                tailorQcodeList.add(tailorQcode);
//            }
//            String firstTailorQcode = tailorQcodeList.get(0).replace("\"","");
//            String[] subQcode = firstTailorQcode.split("-");
//            String orderName = subQcode[0];
//            String customerName = subQcode[1];
//            String bedNumber = subQcode[2];
//            String jarName = subQcode[3];
//            String colorName = subQcode[4];
//            String sizeName = subQcode[5];
//            String layerCount = subQcode[6];
//            String packageNumber = subQcode[7];
//            List<String> locationList = storageService.getMatch(orderName, customerName, Integer.parseInt(bedNumber), jarName, colorName, sizeName, Integer.parseInt(layerCount), Integer.parseInt(packageNumber));
//            return locationList;
//        }catch (JsonIOException e){
//            e.printStackTrace();
//        }catch (JsonSyntaxException e){
//            e.printStackTrace();
//        }
//        return null;
//
//    }


    @RequestMapping(value = "/storagereport",method = RequestMethod.GET)
    @ResponseBody
    public List<String> storageReport(@RequestParam("storehouseLocation")String storehouseLocation){
        List<String> storageList = storageService.storageReport(storehouseLocation);
        return storageList;
    }



    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getMatch(@RequestParam("matchJson")String matchJson,
                                 ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(matchJson);
            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonTailorQcode.iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator.next();
                String tailorQcode = next.toString().replace("\"", "");
                tailorQcodeList.add(tailorQcode);
            }
            String firstTailorQcode = tailorQcodeList.get(0).replace("\"","");
            String[] subQcode = firstTailorQcode.split("-");
            String orderName = subQcode[0];
            String customerName = subQcode[1];
            String bedNumber = subQcode[2];
            String jarName = subQcode[3];
            String colorName = subQcode[4];
            String sizeName = subQcode[5];
            String layerCount = subQcode[6];
            String packageNumber = subQcode[7];
            String subTailorQcode = orderName+"-"+customerName+"-"+bedNumber+"-"+jarName+"-"+colorName+"-"+sizeName+"-"+layerCount+"-"+packageNumber;
            List<String> locationList = storageService.getMatch(subTailorQcode);
            return locationList;
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


//    @RequestMapping(value = "/getMatch", method = RequestMethod.GET)
//    @ResponseBody
//    public List<String> getMatch(@RequestParam("matchJson")String matchJson,
//                                 ModelMap map){
//        JsonParser jsonParser = new JsonParser();
//        try{
//            JsonObject json = (JsonObject) jsonParser.parse(matchJson);
//            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
//            Iterator iterator = jsonTailorQcode.iterator();
//            List<String> tailorQcodeList = new ArrayList<>();
//            while(iterator.hasNext()){
//                JsonPrimitive next = (JsonPrimitive) iterator.next();
//                String tailorQcode = next.toString().replace("\"", "");
//                tailorQcodeList.add(tailorQcode);
//            }
//            List<String> locationList = storageService.getMatch(tailorQcodeList);
//
//            return locationList;
//        }catch (JsonIOException e){
//            e.printStackTrace();
//        }catch (JsonSyntaxException e){
//            e.printStackTrace();
//        }
//        return null;
//
//    }

}
