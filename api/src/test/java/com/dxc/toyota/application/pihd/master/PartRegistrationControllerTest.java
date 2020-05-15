package com.dxc.toyota.application.pihd.master;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PartRegistrationControllerTest {
    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    private ShopRepository shopRepository;

    @Test
    void getShopByAAAA() {
        ShopListResponse resultBase = new ShopListResponse();
        List<Shop> shopList= new ArrayList<Shop>();
        shopList.add(new Shop("A","A"));
        shopList.add(new Shop("Q","Q"));
        resultBase.setShop(shopList);
        given(shopRepository.getShopByUserName("aaaa")).willReturn(shopList);

        ShopListResponse result = restTemplate.getForObject("/api/v1/shop/aaaa", ShopListResponse.class);
        assertNotNull(result,"ShopListResponse is not null");
        assertEquals(2,result.getShop().size(),"shop size is 2 ");
        assertEquals(result.getShop(),resultBase.getShop(),"Shop List must contain A and Q");
    }
    @Test
    void getShopByQQQQ() {
        ShopListResponse resultBase = new ShopListResponse();
        List<Shop> shopListQ= new ArrayList<Shop>();
        shopListQ.add(new Shop("Q","Q"));
        resultBase.setShop(shopListQ);



        List<Shop> shopList= new ArrayList<Shop>();
//        shopList.add(new Shop("A","A"));
        shopList.add(new Shop("Q","Q"));

        given(shopRepository.getShopByUserName("qqqq")).willReturn(shopList);

        ShopListResponse result = restTemplate.getForObject("/api/v1/shop/qqqq", ShopListResponse.class);
        assertNotNull(result,"ShopListResponse is not null");
        assertEquals(1,result.getShop().size(),"shop size is 1 ");
        assertEquals(resultBase.getShop(),result.getShop(),"Shop List must Q");
    }
}