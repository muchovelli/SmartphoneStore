package com.adam.mobileshop;

import com.adam.mobileshop.brand.Brand;
import com.adam.mobileshop.brand.BrandService;
import com.adam.mobileshop.camera.Camera;
import com.adam.mobileshop.camera.CameraService;
import com.adam.mobileshop.smartphone.Smartphone;
import com.adam.mobileshop.smartphone.SmartphoneRepo;
import com.adam.mobileshop.smartphone.SmartphoneService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class SmartphoneStoreApplicationTests {
    @Autowired
    private SmartphoneService smartphoneService;

    @Mock
    SmartphoneRepo smartphoneRepo;


    @Test
    void contextLoads() {
    }



    @Test
    public void saveSmartphoneDetailsTest(){
        //Brand samsung = new Brand();
        //Camera camera = new Camera();

        //samsung.setName("Y");
        //samsung.setId(1);
        //brandService.saveNewBrand(samsung);
        //camera.setId(1);
       // cameraService.saveCamera(camera);
        //List<Smartphone> smarphonelist = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        stringList.add("dupa");
        Smartphone smartphone = new Smartphone();
        smartphone.setModelName("Samsung s20");
        smartphone.setOtherNames(stringList);
        smartphone.setStandards(stringList);
        smartphone.setWeight(100);
        smartphone.setDisplay("100");
        smartphone.setInternalMemory(stringList);
        smartphone.setOperatingSystem("AAAA");
        smartphone.setBluetooth(true);
        smartphone.setQuantity(1);

        //samsung.setSmartphoneList(smarphonelist);


        //given

        //when
        smartphoneService.saveSmartphone(smartphone);
        //then
        verify(smartphoneRepo, times(1)).save(any());
    }


   /* @Test
    void demoTest(){
        Smartphone smartphone = new Smartphone();
        smartphone = smartphoneService.scrapeSmartphone("https://www.mgsm.pl/pl/katalog/samsung/galaxya73dualsim/");
        smartphoneService.saveSmartphone(smartphone);
        System.out.println(smartphoneService.getSmartphones());
    }*/
}
