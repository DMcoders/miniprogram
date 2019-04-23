package com.example.erp01.action;

import com.example.erp01.model.User;
import com.example.erp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//用户基本操作，新增，删除，登录等操作

@Controller(value = "/user")
public class UserController {


    @Autowired
    private UserService userService;

    @RequestMapping(value ="/userlogin", method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> userLogin(@RequestParam("userName")String userName,
                                        @RequestParam("passWord")String passWord,
                                        HttpServletRequest request){
        System.out.println("用户名："+userName+"密码："+passWord);
        Map<String,Object> result = new HashMap<String,Object>();
        if(StringUtils.isEmpty(userName) || StringUtils.isEmpty(passWord)){
            result.put("flag",false);
            result.put("msg","用户名或密码不能为空！");
        }
        User user = userService.userLogin(userName,passWord);
        if (user != null){
            result.put("flag","true");
            result.put("msg","登录成功！");
            request.getSession().setAttribute("userName", user.getUserName());
            request.getSession().setAttribute("role", user.getRole());
            request.getSession().setMaxInactiveInterval(1800);
        }else{
            result.put("msg","登录失败，用户名或密码错误！");
            result.put("flag",false);
        }
        return result;
    }

    @RequestMapping(value ="/homepage")
    public String getHomePageStart(Model model,HttpServletRequest request) {
        model.addAttribute("bigMenuTag",0);
        model.addAttribute("menuTag",0);
        return "homepage/homepage";
    }

    /**
     * 进入用户信息页面
     * @param model
     * @return
     */
    @RequestMapping("/userStart")
    public String userStart(Model model){
        model.addAttribute("bigMenuTag",4);
        model.addAttribute("menuTag",44);
        List<User>  users = getAllUser();
        model.addAttribute("users",users);
        return "factoryMsg/user";
    }


    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
    @ResponseBody
    public int addUser(User user){
        User user1 = getUserByName(user.getUserName());
        if(user1!=null && user1.getUserID()!=null) {
            return 3;
        }
        int res = userService.addUser(user);
        return res;
    }



    @RequestMapping(value = "/getuserbyname", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByName(@RequestParam("userName")String userName){
        User user = userService.getUserByName(userName);
        return user;
    }

    @RequestMapping(value = "/deleteuser", method = RequestMethod.POST)
    @ResponseBody
    public int deleteUser(@RequestParam("userID")Integer userID){
        int res = userService.deleteUser(userID);
        return res;
    }

    @RequestMapping(value = "/getuserbyid", method = RequestMethod.GET)
    @ResponseBody
    public User getUserByID(@RequestParam("userID")Integer userID){
        User user = userService.getUserByID(userID);
        return user;
    }

    @RequestMapping(value = "/getalluser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser(){
        List<User> userList = null;
        userList = userService.getAllUser();
        return userList;
    }


}
