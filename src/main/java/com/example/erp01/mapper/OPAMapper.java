package com.example.erp01.mapper;

import com.example.erp01.model.OPA;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OPAMapper {

    int addOPA(OPA opa);

    int deleteOPA(Integer opaID);

    List<OPA> getAllOPA();

}
