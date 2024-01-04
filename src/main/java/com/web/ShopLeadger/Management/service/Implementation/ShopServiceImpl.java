package com.web.ShopLeadger.Management.service.Implementation;

import com.web.ShopLeadger.Management.model.Shop;
import com.web.ShopLeadger.Management.repo.ShopRepo;
import com.web.ShopLeadger.Management.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    private ShopRepo shopRepo;
    @Override
    public List<Shop> getAllShops() {
        return shopRepo.findAll();
    }

    @Override
    public Shop addShop(Shop shop) {
        return shopRepo.save(shop);
    }
}
