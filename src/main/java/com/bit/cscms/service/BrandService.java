package com.bit.cscms.service;

import com.bit.cscms.dto.BrandDTO;
import com.bit.cscms.model.Brand;
import com.bit.cscms.repo.BrandRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return modelMapper.map(brands, new TypeToken<List<BrandDTO>>() {}.getType());

    }

    public BrandDTO saveBrand(BrandDTO brandDTO) {
        Brand brand = modelMapper.map(brandDTO, Brand.class);
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
}
