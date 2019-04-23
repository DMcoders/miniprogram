package com.example.erp01.action;

import com.example.erp01.model.OPA;
import com.example.erp01.service.OPAService;
import com.example.erp01.service.TailorService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller(value = "/opa")
public class OPAController {

    @Autowired
    private OPAService opaService;

    @Autowired
    private TailorService tailorService;
    /**
     * 进入花片出厂页面
     * @param model
     * @return
     */
    @RequestMapping("/opaStart")
    public String opaStart(Model model){
        model.addAttribute("bigMenuTag",2);
        model.addAttribute("menuTag",25);
        List<OPA>  opaList = getAllOPA();
        model.addAttribute("opaList",opaList);
        return "opaMsg/opa";
    }

    /**
     * 进入详情页面
     * @param model
     * @return
     */
    @RequestMapping("/detailOpaStart")
    public String detailOpaStart(Model model,String orderName,String bedNumber,String partName){
        try {
            partName = java.net.URLDecoder.decode(partName,"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        model.addAttribute("orderName", orderName);
        model.addAttribute("bedNumber", bedNumber);
        model.addAttribute("partName", partName);
        return "opaMsg/fb_detailOpa";
    }




    /**
     * 进入裁片入库页面
     * @param model
     * @return
     */
    @RequestMapping("/opaMatchStart")
    public String opaMatchStart(Model model) {
        model.addAttribute ("bigMenuTag", 2);
        model.addAttribute ("menuTag", 27);
        return "cutMarket/opaMatch";
    }

    @RequestMapping("/changeStoreStart")
    public String changeStoreStart(Model model) {
        model.addAttribute ("bigMenuTag", 2);
        model.addAttribute ("menuTag",23);
        return "cutMarket/changeStore";
    }

    @RequestMapping(value = "/addopa")
    @ResponseBody
    public int addOPA(HttpServletRequest request){
        JsonParser jsonParser = new JsonParser();
        int result = 1;
        try{
            String orderName = request.getParameter("orderName");
            String customerName = request.getParameter("customerName");
            String destination = request.getParameter("destination");
            String bedNumber = request.getParameter("bedNumber");
            String partName = request.getParameter("partName");
            String opaDate = request.getParameter("opaDate");
            int opaCount = tailorService.getTailorCountByOrderNameBedNumPart(orderName,Integer.parseInt(bedNumber),partName);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            OPA opa = new OPA(orderName,customerName,destination,Integer.parseInt(bedNumber),partName,opaCount,sdf.parse(opaDate));
            result = opaService.addOPA(opa);
        }catch (JsonIOException e){
            e.printStackTrace();
        }catch (JsonSyntaxException e){
            e.printStackTrace();
        }catch (ParseException e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping(value = "/deleteopa",method = RequestMethod.POST)
    @ResponseBody
    public int deleteOPA(@RequestParam("opaID")Integer opaID,
                            ModelMap map){
        return opaService.deleteOPA(opaID);
    }

    @RequestMapping(value = "/getallopa",method = RequestMethod.GET)
    @ResponseBody
    public List<OPA> getAllOPA(){
        List<OPA> opaList = new ArrayList<>();
        opaList = opaService.getAllOPA();
        return opaList;
    }

}
