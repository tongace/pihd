package com.dxc.toyota.application.pihd.master;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PartRegistrationController {
    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/api/v1/shop/{userName}")
    public ShopListResponse getShopByUserName(@PathVariable String userName){
        ShopListResponse result = new ShopListResponse();
        List<Shop> shopList = shopRepository.getShopByUserName(userName);
        result.setShop(shopList);
        return result;
    }
}

