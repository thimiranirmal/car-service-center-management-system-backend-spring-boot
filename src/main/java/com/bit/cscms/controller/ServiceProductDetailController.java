package com.bit.cscms.controller;

import com.bit.cscms.dto.ServiceProductDetailsDTO;
import com.bit.cscms.model.ServiceProductDetails;
import com.bit.cscms.service.ServiceProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/serviceproductdetails")
public class ServiceProductDetailController {

    @Autowired
    private ServiceProductDetailService serviceProductDetailService;

    @PostMapping("/createserviceproductdetail")
    public List<ServiceProductDetails> createServiceProductDetail(@RequestBody ServiceProductDetailsDTO serviceProductDetailsDTO) {
        return serviceProductDetailService.createServiceProductDetail(serviceProductDetailsDTO);
    }

    @GetMapping("/getallserviceproductdetails")
    public List<ServiceProductDetails> getAllServiceProductDetails() {
        return serviceProductDetailService.getAllServiceProductDetails();
    }
}
