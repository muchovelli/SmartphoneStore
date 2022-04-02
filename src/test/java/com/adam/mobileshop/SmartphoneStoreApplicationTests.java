package com.adam.mobileshop;

import com.adam.mobileshop.smartphone.Smartphone;
import com.adam.mobileshop.smartphone.SmartphoneRepo;
import com.adam.mobileshop.smartphone.SmartphoneServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SmartphoneStoreApplicationTests {
    @Autowired
    private SmartphoneServiceImpl smartphoneServiceImpl = new SmartphoneServiceImpl();;

    @BeforeEach
    public void setUp(){
        List<String> otherNames = new ArrayList<>();
        otherNames.add("a");
        smartphoneServiceImpl.saveSmartphone(Smartphone.builder().id(1L).modelName("Samsung").otherNames(otherNames).standards(otherNames).weight(500.00f).display("LCD").internalMemory(otherNames).operatingSystem("Windows").dualSim(false).bluetooth(false).quantity(2).build());
    }

    @Test
    void findAll(){
        Set<Smartphone> smartphoneSet = smartphoneServiceImpl.getSmartphones();
        System.out.println(smartphoneSet);
        assertEquals(1,smartphoneSet.size());
    }

    @Test
    void contextLoads() {
    }

}
