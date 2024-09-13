package com.bit.cscms.controller;

import com.bit.cscms.dto.ServiceDetailDTO;
import com.bit.cscms.model.Service_Detail;
import com.bit.cscms.service.ServiceDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/servicedetails")
public class ServiceDetailController {

    @Autowired
    private ServiceDetailService serviceDetailService;

    @PostMapping("/createservicedetail")
    public List<Service_Detail> createServiceDetail(@RequestBody ServiceDetailDTO serviceDetailDTO) {
        return serviceDetailService.createServiceDetail(serviceDetailDTO);
    }

    @GetMapping("/getallservicedetails")
    public List<ServiceDetailDTO> getAllServiceDetails() {
        return serviceDetailService.getAllServiceDetails();
    }
}
