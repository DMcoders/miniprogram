package com.example.erp01;

import com.example.erp01.action.DispatchController;
import com.example.erp01.service.DispatchService;
import com.example.erp01.service.OrderProcedureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DevApplicationTests {

    @Autowired
    OrderProcedureService orderProcedureService;

    @Autowired
    DispatchController dispatchController;

    @Test
    public void contextLoads() {

        Map<String,Object> map = dispatchController.getAllDispatch();
        System.out.println(map.get("dispatchList"));
    }

}
