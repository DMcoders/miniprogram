package com.example.erp01.service;

import com.example.erp01.model.Dispatch;

import java.util.List;

public interface DispatchService {

    int addDispatchBatch(List<Dispatch> dispatchList);

    int addDispatch(Dispatch dispatch);

    int deleteDispatch(Integer dispatchID);

    List<Dispatch> getAllDispatch();

    List<Dispatch> getDispatchByOrder(String orderName);

    List<Dispatch> getDispatchByGroup(String groupName);

    List<Dispatch> getDispatchByEmp(String employeeNumber);

    List<String> getProcedureNamesByOrderEmp(String orderName,String employeeNumber);

}
