package com.bit.cscms.controller;

import com.bit.cscms.dto.ProductInventoryDTO;
import com.bit.cscms.model.ProductInventory;
import com.bit.cscms.service.ProductInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/inventory")
public class ProductInventoryController {

    @Autowired
    private ProductInventoryService productInventoryService;

    @PostMapping("/addqty")
    public ProductInventory addQty(@RequestBody ProductInventoryDTO productInventoryDTO) {
        return productInventoryService.addQuantity(productInventoryDTO);
    }

    @PutMapping("/deductqty")
    public ProductInventory deductQty(@RequestBody ProductInventoryDTO productInventoryDTO) {
        return productInventoryService.deductQuantity(productInventoryDTO);
    }
}
