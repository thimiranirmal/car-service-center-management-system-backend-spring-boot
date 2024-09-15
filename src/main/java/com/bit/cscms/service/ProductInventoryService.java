package com.bit.cscms.service;

import com.bit.cscms.dto.ProductInventoryDTO;
import com.bit.cscms.model.Product;
import com.bit.cscms.model.ProductInventory;
import com.bit.cscms.repo.ProductInventoryRepo;
import com.bit.cscms.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductInventoryService {

    @Autowired
    private ProductInventoryRepo productInventoryRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ProductInventory addQuantity(ProductInventoryDTO productInventoryDTO) {
        ProductInventory productInventory = modelMapper.map(productInventoryDTO, ProductInventory.class);
        Product product= productRepo.findById(productInventoryDTO.getProductId()).orElseThrow();
        productInventory.setProduct(product);

        ProductInventory existingProductInventory = productInventoryRepo.findByProductId(product.getProduct_id());
        if (existingProductInventory != null) {

            existingProductInventory.setQuantity(existingProductInventory.getQuantity() + productInventory.getQuantity());
            productInventoryRepo.save(existingProductInventory);
            return existingProductInventory;
        } else {

            productInventoryRepo.save(productInventory);
            return productInventory;
        }
//
    }

    public ProductInventory deductQuantity(ProductInventoryDTO productInventoryDTO) {
        ProductInventory productInventory = modelMapper.map(productInventoryDTO, ProductInventory.class);
        Product product = productRepo.findById(productInventoryDTO.getProductId()).orElseThrow();
        productInventory.setProduct(product);

        ProductInventory existingProductInventory = productInventoryRepo.findByProductId(product.getProduct_id());
        if (existingProductInventory != null) {

            if (existingProductInventory.getQuantity() >= productInventory.getQuantity()) {
                existingProductInventory.setQuantity(existingProductInventory.getQuantity() - productInventory.getQuantity());
                productInventoryRepo.save(existingProductInventory);
                return existingProductInventory;
            } else {

                throw new RuntimeException("Not enough quantity in stock");
            }
        } else {
            // If the product does not exist, throw an exception
            throw new RuntimeException("Product does not exist in inventory");
        }
    }
}
