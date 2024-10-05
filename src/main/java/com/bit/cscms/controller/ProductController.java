package com.bit.cscms.controller;

import com.bit.cscms.dto.ProductDTO;
import com.bit.cscms.model.Product;
import com.bit.cscms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getproduct/{productId}")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId);
    }

    @GetMapping("/getallproducts")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping(value = "/addproduct", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductDTO addProduct(@ModelAttribute ProductDTO productDTO, @RequestParam("image") MultipartFile image) {
        return productService.createProduct(productDTO,image);
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
