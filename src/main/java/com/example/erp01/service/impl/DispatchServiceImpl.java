package com.example.erp01.service.impl;

import com.example.erp01.mapper.DispatchMapper;
import com.example.erp01.model.Dispatch;
import com.example.erp01.service.DispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DispatchServiceImpl implements DispatchService {

    @Autowired
    private DispatchMapper dispatchMapper;

    @Override
    public int addDispatchBatch(List<Dispatch> dispatchList) {
        try{
            dispatchMapper.addDispatchBatch(dispatchList);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int addDispatch(Dispatch dispatch) {
        try{
            dispatchMapper.addDispatch(dispatch);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public int deleteDispatch(Integer dispatchID) {
        try{
            dispatchMapper.deleteDispatch(dispatchID);
            return 0;
        }catch (Exception e){
            e.printStackTrace();
        }
        return 1;
    }

    @Override
    public List<Dispatch> getAllDispatch() {
        List<Dispatch> dispatchList = new ArrayList<>();
        try{
            dispatchList = dispatchMapper.getAllDispatch();
            return dispatchList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dispatch> getDispatchByOrder(String orderName) {
        List<Dispatch> dispatchList = new ArrayList<>();
        try{
            dispatchList = dispatchMapper.getDispatchByOrder(orderName);
            return dispatchList;
        }catch (Exception E){
            E.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dispatch> getDispatchByGroup(String groupName) {
        List<Dispatch> dispatchList = new ArrayList<>();
        try{
            dispatchList = dispatchMapper.getDispatchByGroup(groupName);
            return dispatchList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Dispatch> getDispatchByEmp(String employeeNumber) {
        List<Dispatch> dispatchList = new ArrayList<>();
        try{
            dispatchList = dispatchMapper.getDispatchByEmp(employeeNumber);
            return dispatchList;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<String> getProcedureNamesByOrderEmp(String orderName, String employeeNumber) {
        List<String> dispatchNames = new ArrayList<>();
        try{
            dispatchNames = dispatchMapper.getProcedureNamesByOrderEmp(orderName, employeeNumber);
            return dispatchNames;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
