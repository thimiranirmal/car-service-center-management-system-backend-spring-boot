package com.bit.cscms.controller;

import com.bit.cscms.dto.ServiceDTO;
import com.bit.cscms.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/services")
public class ServiceController {

    @Autowired
    private ServiceService serviceService;

    @GetMapping("/getallservice")
    public List<ServiceDTO> getAllService(){
        return serviceService.getAllServices();
    }

    @GetMapping("/getservice/{ser_id}")
    public com.bit.cscms.model.Service getServiceById(@PathVariable int ser_id){
        return serviceService.getServiceById(ser_id);
    }

    @PostMapping("/createservice")
    public ServiceDTO createService(@RequestBody ServiceDTO serviceDTO){
        return serviceService.createService(serviceDTO);
    }

    @PutMapping("/updateservice")
    public ServiceDTO updateService(@RequestBody ServiceDTO serviceDTO){
        return serviceService.updateService(serviceDTO);
    }
}
