package com.bit.cscms.repo;

import com.bit.cscms.model.ProductInventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductInventoryRepo extends JpaRepository<ProductInventory, Integer> {

    @Query(value = "SELECT * FROM product_inventory WHERE product_id = ?1",nativeQuery = true)
    ProductInventory findByProductId(int productId);

}
