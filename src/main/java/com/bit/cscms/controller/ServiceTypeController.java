package com.bit.cscms.controller;

import com.bit.cscms.dto.ServiceTypeDTO;
import com.bit.cscms.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/servicetype")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService serviceTypeService;

    @GetMapping("/getservicetype/{ser_typ_id}")
    public ServiceTypeDTO getServiceType(@PathVariable int ser_typ_id) {
        return serviceTypeService.getServiceType(ser_typ_id);
    }

    @GetMapping("/getallservicetypes")
    public List<ServiceTypeDTO> getAllServiceTypes() {
        return serviceTypeService.getAllServiceTypes();
    }

    @PutMapping("/updateservicetype")
    public ServiceTypeDTO updateServiceType(@RequestBody ServiceTypeDTO serviceTypeDTO) {
        return serviceTypeService.updateServiceType(serviceTypeDTO);
    }

    @PostMapping("/addservicetype")
    public ServiceTypeDTO addServiceType(@RequestBody ServiceTypeDTO serviceTypeDTO) {
        return serviceTypeService.createServiceType(serviceTypeDTO);
    }

    @DeleteMapping("/deleteservicetype/{ser_typ_id}")
    public String deleteServiceType(@PathVariable int ser_typ_id) {
        return serviceTypeService.deleteServiceType(ser_typ_id);
    }
}
