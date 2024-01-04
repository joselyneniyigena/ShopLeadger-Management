package com.web.ShopLeadger.Management.service;

import com.web.ShopLeadger.Management.model.Shop;

import java.util.List;

public interface ShopService {
    List<Shop> getAllShops();
    Shop addShop(Shop shop);
}
