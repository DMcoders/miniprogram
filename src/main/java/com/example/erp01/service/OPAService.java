package com.example.erp01.service;

import com.example.erp01.model.OPA;

import java.util.List;

public interface OPAService {

    int addOPA(OPA opa);

    int deleteOPA(Integer opaID);

    List<OPA> getAllOPA();

}
