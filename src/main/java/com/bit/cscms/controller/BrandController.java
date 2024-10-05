package com.bit.cscms.controller;

import com.bit.cscms.dto.BrandDTO;
import com.bit.cscms.model.Brand;
import com.bit.cscms.service.BrandService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;

    @GetMapping("/getbrand/{brand_id}")
    public BrandDTO getBrand(@PathVariable int brand_id) {
        return brandService.getBrandById(brand_id);
    }

    @GetMapping("/getallbrands")
    public List<BrandDTO> getAllBrands() {
        return brandService.getAllBrands();
    }


    @PostMapping(value = "/addbrand", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BrandDTO addBrand(@ModelAttribute BrandDTO brandDTO, @RequestParam("image") MultipartFile image) {
        return brandService.saveBrand(brandDTO,image);
    }

    @PutMapping("/updatebrand")
    public BrandDTO updateBrand(@RequestBody BrandDTO brandDTO) {
        return brandService.updateBrand(brandDTO);
    }

    @DeleteMapping("/deletebrand/{brand_id}")
    public String deleteBrand(@PathVariable int brand_id) {
        return brandService.deleteBrand(brand_id);
    }
}
