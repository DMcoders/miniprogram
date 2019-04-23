package com.example.erp01.service.impl;

import com.example.erp01.mapper.UserMapper;
import com.example.erp01.model.User;
import com.example.erp01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


     @Override
    public int addUser(User user){
        try{
            userMapper.addUser(user);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;

    }

    @Override
    public List<User> getAllUser() {
         List<User> userList = null;
         try{
             userList = userMapper.getAllUser();
             return userList;
         }catch (Exception e){
             e.printStackTrace();
         }
         return null;
    }

    @Override
    public User getUserByID(Integer id) {
        User user;
        try{
            user = userMapper.getUserByID(id);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User getUserByName(String userName) {
        User user;
        try{
            user = userMapper.getUserByName(userName);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteUser(Integer userID) {
         try{
             userMapper.deleteUser(userID);
             return 0;
         }catch (Exception e){
             e.printStackTrace();
         }
        return 1;
    }


    @Override
    public User userLogin(String userName, String passWord) {
        User user;
        try{
            user = userMapper.userLogin(userName,passWord);
            return user;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
