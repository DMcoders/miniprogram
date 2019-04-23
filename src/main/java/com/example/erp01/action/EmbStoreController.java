package com.example.erp01.action;

import com.example.erp01.model.EmbStore;
import com.example.erp01.service.EmbStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

//衣胚仓库相关操作，仓库信息维护，增加衣胚仓库，删除衣胚仓库，衣胚仓库信息维护

@Controller(value = "/embstore")
public class EmbStoreController {

    @Autowired
    private EmbStoreService embStoreService;

    /**
     * 进入衣胚入库页面
     * @param model
     * @return
     */
    @RequestMapping("/embInStoreStart")
    public String embInStoreStart(Model model) {
        model.addAttribute("bigMenuTag",3);
        model.addAttribute("menuTag",31);
        return "embMarket/embInStore";
    }

    /**
     * 进入衣胚出库页面
     * @param model
     * @return
     */
    @RequestMapping("/embOutStoreStart")
    public String embOutStoreStart(Model model) {
        model.addAttribute("bigMenuTag", 3);
        model.addAttribute("menuTag", 32);
        return "embMarket/embOutStore";
    }

    /**
     * 进入衣胚仓库页面
     * @param model
     * @return
     */
    @RequestMapping("/embStoreStart")
    public String embStoreStart(Model model){
        model.addAttribute("bigMenuTag",4);
        model.addAttribute("menuTag",42);
        List<EmbStore>  embStores = getAllEmbStore();
        model.addAttribute("embStores",embStores);
        return "factoryMsg/embStore";
    }

    @RequestMapping("/embStoreStockStart")
    public String mebStoreStockStart(Model model) {
        model.addAttribute("bigMenuTag", 3);
        model.addAttribute("menuTag", 11);
        return "/embMarket/embStoreStock";
    }


    @RequestMapping(value = "/addembstore", method = RequestMethod.POST)
    @ResponseBody
    public int addEmbStore(EmbStore embStore){
        embStore.setEmbStoreID(null);
        EmbStore store = embStoreService.getEmbStoreByLocation(embStore.getEmbStoreLocation());
        if(store!=null) {
            return 3;
        }
        int res = embStoreService.addEmbStore(embStore);
        return res;
    }

    @RequestMapping(value = "deleteembstore", method = RequestMethod.POST)
    @ResponseBody
    public int deleteEmbStore(@RequestParam("embStoreID")Integer embStoreID,
                                 ModelMap map){
        int res = embStoreService.deleteEmbStore(embStoreID);
        return res;
    }

    @RequestMapping(value = "updateembstore", method = RequestMethod.POST)
    @ResponseBody
    public int updateEmbStore(EmbStore embStore){
        EmbStore store = embStoreService.getEmbStoreByLocation(embStore.getEmbStoreLocation());
        if(store!=null && store.getEmbStoreID().intValue()!=embStore.getEmbStoreID().intValue()) {
            return 3;
        }
        int res = embStoreService.updateEmbStore(embStore);
        return res;
    }

    @RequestMapping(value = "getallembstore", method = RequestMethod.GET)
    @ResponseBody
    public List<EmbStore> getAllEmbStore(){
        List<EmbStore> embStoreList = new ArrayList<>();
        embStoreList = embStoreService.getAllEmbStore();
        return embStoreList;
    }

}
