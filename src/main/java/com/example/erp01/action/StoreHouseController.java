package com.example.erp01.action;

import com.example.erp01.model.StoreHouse;
import com.example.erp01.service.StoreHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller(value = "/storehouse")
public class StoreHouseController {

    @Autowired
    private StoreHouseService storeHouseService;

    /**
     * 进入仓库信息页面
     * @param model
     * @return
     */
    @RequestMapping("/storeHouseStart")
    public String addStoreHouse(Model model){
        model.addAttribute("bigMenuTag",4);
        model.addAttribute("menuTag",41);
        List<StoreHouse>  storeHouses = getAllStoreHouse();
        model.addAttribute("storeHouses",storeHouses);
        return "factoryMsg/storeHouse";
    }

    @RequestMapping(value = "/addstorehouse")
    @ResponseBody
    public int addStoreHouse(StoreHouse storeHouse){
        storeHouse.setStorehouseID(null);
        StoreHouse house = getStoreHouseByQcode(storeHouse.getStorehouseLocation());
        if(house!=null) {
            return 3;
        }
        int res = storeHouseService.addStoreHouse(storeHouse);
        return res;
    }
    @RequestMapping(value = "/deletestorehouse")
    @ResponseBody
    public int deleteStoreHouse(@RequestParam("storehouseID")Integer storehouseID){
        int res = storeHouseService.deleteStoreHouse(storehouseID);
        return res;
    }

    @RequestMapping(value = "/updatestorehouse")
    @ResponseBody
    public int updateStoreHouse(StoreHouse storeHouse){
        StoreHouse house = getStoreHouseByQcode(storeHouse.getStorehouseLocation());
        if(house!=null && house.getStorehouseID().intValue()!=storeHouse.getStorehouseID().intValue()) {
            return 3;
        }
        int res = storeHouseService.updateStoreHouse(storeHouse);
        return res;

    }

    @RequestMapping(value = "/getallstorehouse", method = RequestMethod.GET)
    @ResponseBody
    public List<StoreHouse> getAllStoreHouse(){
        List<StoreHouse> storeHouseList = storeHouseService.getAllStoreHouse();
        return storeHouseList;
    }



    @RequestMapping(value = "/getstorehousebylocation", method = RequestMethod.GET)
    @ResponseBody
    public StoreHouse getStoreHouseByQcode(@RequestParam("storehouseLocation")String storehouseLocation){
        StoreHouse storeHouse = storeHouseService.getStoreHouseByLocation(storehouseLocation);
        return storeHouse;
    }

}
