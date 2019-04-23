package com.example.erp01;

import com.example.erp01.mapper.OrderProcedureMapper;
import com.example.erp01.model.OrderProcedure;
import com.example.erp01.service.OrderProcedureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevApplicationTests {

    @Autowired
    OrderProcedureService orderProcedureService;

    @Test
    public void contextLoads() {


    }

}
