package com.example.erp01.action;

import com.example.erp01.model.EmbStorage;
import com.example.erp01.service.EmbStorageService;
import com.example.erp01.service.StorageService;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


//衣胚出入库相关操作，出库，入库等
@Controller(value = "/emb")
public class EmbStorageController {

    @Autowired
    private EmbStorageService embStorageService;
    @Autowired
    private StorageService storageService;

    @RequestMapping(value = "/embinstore", method = RequestMethod.POST)
    @ResponseBody
    public Boolean embInStore(String embInStoreJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        Boolean result = false;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embInStoreJson);
            String embStoreLocation = json.get("embStoreLocation").getAsString();
            JsonArray jsonTailorQcode = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonTailorQcode.iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                JsonPrimitive tailorQcode = (JsonPrimitive) iterator.next();
                tailorQcodeList.add(tailorQcode.toString().replace("\"",""));
            }
            int res1 = storageService.outStore(tailorQcodeList);
            List<EmbStorage> embStorageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                EmbStorage embStorage = new EmbStorage(embStoreLocation,tailorQcodeList.get(i));
                embStorageList.add(embStorage);
            }
            int res2 = embStorageService.embInStore(embStorageList);
            if (0 == res1 && 0 == res2){
//                map.addAttribute("msg","入库成功！");
                result = true;
            }else{
//                map.addAttribute("msg","入库失败！");
                result = false;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;

    }

    @RequestMapping(value = "/embOutstore", method = RequestMethod.POST)
    @ResponseBody
    public boolean embOutStore(@RequestParam("embOutStoreJson")String embOutStoreJson,
                              ModelMap map){

        JsonParser jsonParser = new JsonParser();
        boolean result =false;
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embOutStoreJson);
            String embStoreLocation = json.get("embStoreLocation").getAsString();
            JsonArray jsonArray = json.get("tailorQcode").getAsJsonArray();
            Iterator iterator = jsonArray.iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                JsonPrimitive next = (JsonPrimitive) iterator.next();
                tailorQcodeList.add(next.toString().replace("\"",""));
            }
            int res = embStorageService.embOutStore(tailorQcodeList);
            if (0 == res){
                result = true;
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return result;

    }

    @RequestMapping(value = "/embchangestore",method = RequestMethod.POST)
    public String changeStore(@RequestParam("embChangeStoreJson")String embChangeStoreJson,
                              ModelMap map){
        JsonParser jsonParser = new JsonParser();
        try{
            JsonObject json = (JsonObject) jsonParser.parse(embChangeStoreJson);
            String embStoreLocation = json.get("embStoreLocation").getAsString();
            JsonObject jsonTailorQcode = json.get("tailorQcode").getAsJsonObject();
            Iterator iterator = jsonTailorQcode.entrySet().iterator();
            List<String> tailorQcodeList = new ArrayList<>();
            while(iterator.hasNext()){
                Map.Entry entry = (Map.Entry) iterator.next();
                tailorQcodeList.add(entry.getValue().toString().replace("\"","").replace("\"",""));
            }
            int res1 = embStorageService.embOutStore(tailorQcodeList);
            List<EmbStorage> embStorageList = new ArrayList<>();
            for (int i=0; i<tailorQcodeList.size(); i++){
                EmbStorage embStorage = new EmbStorage(embStoreLocation,tailorQcodeList.get(i));
                embStorageList.add(embStorage);
            }
            int res2 = embStorageService.embInStore(embStorageList);
            if (0 == res1 && 0 == res2){
                map.addAttribute("msg","调库成功！");
            }else{
                map.addAttribute("msg","调库失败！");
            }
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }
        return "index";
    }


    /**
     * 进入衣胚库存页面
     * @param model
     * @return
     */
    @RequestMapping("/embStorageStateStart")
    public String embStorageStateStart(Model model){
        model.addAttribute("bigMenuTag",3);
        model.addAttribute("menuTag",34);
        return "embMarket/embStorageState";
    }

//    获取裁片仓库信息
    @RequestMapping(value = "/getembstoragestate",method = RequestMethod.GET)
    @ResponseBody
    public String getEmbStorageState(){
        List<EmbStorage> embStorageList = new ArrayList<>();
        embStorageList = embStorageService.getEmbStorageState();
        Gson gson=new Gson();
        String storageStateJson=gson.toJson(embStorageList);
        return storageStateJson;
    }

    /**
     * 进入衣胚查询页面
     * @param model
     * @return
     */
    @RequestMapping("/embStorageQueryStart")
    public String embStorageQueryStart(Model model){
        model.addAttribute("bigMenuTag",3);
        model.addAttribute("menuTag",33);
        return "embMarket/embStorageQuery";
    }


    /**
     * 前端限定orderName不能为空
     * @param orderName
     * @param colorName
     * @param bedNumber
     * @param sizeName
     * @return
     */
    @RequestMapping(value = "/embstoragequery", method = RequestMethod.GET)
    @ResponseBody
    public String embStorageQuery(@RequestParam("orderName")String orderName,
                                  @RequestParam("colorName")String colorName,
                                  @RequestParam("bedNumber")Integer bedNumber,
                                  @RequestParam("sizeName")String sizeName){
        if("".equals(colorName)) {
            colorName = null;
        }
        if("".equals(sizeName)) {
            sizeName = null;
        }
        List<Object> queryResult = embStorageService.embStorageQuery(orderName, colorName, bedNumber, sizeName);
        Gson gson = new Gson();
        String res = gson.toJson(queryResult);
        return res;
    }


}
