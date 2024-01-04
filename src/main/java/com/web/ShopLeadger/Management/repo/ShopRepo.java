package com.web.ShopLeadger.Management.repo;

import com.web.ShopLeadger.Management.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepo extends JpaRepository<Shop, Long> {
}
