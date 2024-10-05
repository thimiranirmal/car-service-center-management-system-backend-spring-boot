package com.bit.cscms.service;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.dto.ProductDTO;
import com.bit.cscms.model.Brand;
import com.bit.cscms.model.Category;
import com.bit.cscms.model.Make;
import com.bit.cscms.model.Product;
import com.bit.cscms.repo.BrandRepo;
import com.bit.cscms.repo.CategoryRepo;
import com.bit.cscms.repo.MakeRepo;
import com.bit.cscms.repo.ProductRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private BrandRepo brandRepo;
    @Autowired
    private MakeRepo makeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public Product getProduct(int id) {
        Product product = productRepo.findById(id).orElseThrow();
        return product;
    }

    public List<Product> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return products;
    }

    @SneakyThrows
    public ProductDTO createProduct(ProductDTO productDTO, MultipartFile image) {
        Product product = modelMapper.map(productDTO, Product.class);

        Category category = categoryRepo.findById(productDTO.getCat_id()).orElseThrow();
        product.setCategory(category);

        Brand brand = brandRepo.findById(productDTO.getBrand_id()).orElseThrow();
        product.setBrand(brand);

        Make make = makeRepo.findById(productDTO.getMake_id()).orElseThrow();
        product.setMake(make);

        product.setProduct_image(image.getBytes());

        return modelMapper.map(productRepo.save(product), ProductDTO.class);
    }

    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        Category category = categoryRepo.findById(productDTO.getCat_id()).orElseThrow();
        product.setCategory(category);

        Brand brand = brandRepo.findById(productDTO.getBrand_id()).orElseThrow();
        product.setBrand(brand);

        Make make = makeRepo.findById(productDTO.getMake_id()).orElseThrow();
        product.setMake(make);

        return modelMapper.map(productRepo.save(product), ProductDTO.class);

    }

    public String deleteProduct(int id) {
        productRepo.deleteById(id);
        return "Product deleted";
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        // Encode image data to Base64
        if (product.getProduct_image() != null) {
            String base64Image = Base64.getEncoder().encodeToString(product.getProduct_image());
            productDTO.setProduct_image(base64Image);
        }

        return productDTO;
    }
}
