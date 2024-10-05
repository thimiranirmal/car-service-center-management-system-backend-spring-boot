package com.bit.cscms.service;

import com.bit.cscms.dto.BrandDTO;
import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.model.Brand;
import com.bit.cscms.model.Category;
import com.bit.cscms.repo.BrandRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class BrandService {

    @Autowired
    private BrandRepo brandRepo;

    @Autowired
    private ModelMapper modelMapper;

    public BrandDTO getBrandById(int id) {
        Brand brand = brandRepo.findById(id).get();
        return modelMapper.map(brand, BrandDTO.class);
    }

    public List<BrandDTO> getAllBrands() {
        List<Brand> brands = brandRepo.findAll();
        return brands.stream().map(this::convertToDTO).collect(Collectors.toList());

    }

    @SneakyThrows
    public BrandDTO saveBrand(BrandDTO brandDTO, MultipartFile image){
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        brand.setBrand_img(image.getBytes());
        brand = brandRepo.save(brand);
        return modelMapper.map(brand, BrandDTO.class);
    }

    public BrandDTO updateBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
        brand = brandRepo.save(brand);
        return modelMapper.map(brand, BrandDTO.class);
    }

    public String deleteBrand(int id) {
        brandRepo.deleteById(id);
        return "Brand Deleted";

    }

    private BrandDTO convertToDTO(Brand brand) {
        BrandDTO brandDTO = modelMapper.map(brand, BrandDTO.class);

        // Encode image data to Base64
        if (brand.getBrand_img() != null) {
            String base64Image = Base64.getEncoder().encodeToString(brand.getBrand_img());
            brandDTO.setBrand_image(base64Image);
        }

        return brandDTO;
    }
}
