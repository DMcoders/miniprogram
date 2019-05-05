package com.example.erp01.service;

import com.example.erp01.model.Wrong;

import java.util.List;

public interface WrongService {

    int addWrong(Wrong wrong);

    int deleteWrong(Integer wrongCodeID);

    List<Wrong> getAllWrong();
}
