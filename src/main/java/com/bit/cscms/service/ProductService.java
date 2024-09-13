package com.bit.cscms.service;

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
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductDTO getProduct(int id) {
        return modelMapper.map(productRepo.findById(id), ProductDTO.class);
    }

    public List<ProductDTO> getAllProducts() {
        List<Product> products = productRepo.findAll();
        return modelMapper.map(products, List.class);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = modelMapper.map(productDTO, Product.class);

        Category category = categoryRepo.findById(productDTO.getCat_id()).orElseThrow();
        product.setCategory(category);

        Brand brand = brandRepo.findById(productDTO.getBrand_id()).orElseThrow();
        product.setBrand(brand);

        Make make = makeRepo.findById(productDTO.getMake_id()).orElseThrow();
        product.setMake(make);

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
}
