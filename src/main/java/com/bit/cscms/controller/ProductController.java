package com.bit.cscms.controller;

import com.bit.cscms.dto.ProductDTO;
import com.bit.cscms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct/{productId}")
    public ProductDTO getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/getallproducts")
    public List<ProductDTO> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/addproduct")
    public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
        return productService.createProduct(productDTO);
    }

    @PutMapping("/updateproduct")
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {
        return productService.updateProduct(productDTO);
    }

    @DeleteMapping("/deleteproduct/{productId}")
    public String deleteProduct(@PathVariable int productId) {
        return productService.deleteProduct(productId);
    }
}
