package com.bit.cscms.service;

import com.bit.cscms.dto.ServiceDetailDTO;
import com.bit.cscms.model.ServiceType;
import com.bit.cscms.model.Service_Detail;
import com.bit.cscms.repo.ServiceDetailRepo;
import com.bit.cscms.repo.ServiceRepo;
import com.bit.cscms.repo.ServiceTypeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceDetailService {
    @Autowired
    private ServiceDetailRepo serviceDetailRepo;

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ServiceTypeRepo serviceTypeRepo;


    @Autowired
    private ModelMapper modelMapper;

    public List<Service_Detail> createServiceDetail(ServiceDetailDTO serviceDetailDTO) {

        com.bit.cscms.model.Service service = serviceRepo.findById(serviceDetailDTO.getServiceId()).orElseThrow();

        List<Integer> serviceTypeIds = serviceDetailDTO.getServiceTypeIds();
        List<Service_Detail> serviceDetails = new ArrayList<>();

        for (Integer serviceTypeId : serviceTypeIds) {
            ServiceType serviceType = serviceTypeRepo.findById(serviceTypeId).orElseThrow();
            Service_Detail newServiceDetail = modelMapper.map(serviceDetailDTO, Service_Detail.class);
            newServiceDetail.setServiceType(serviceType);
            newServiceDetail.setService(service);
            serviceDetails.add(serviceDetailRepo.save(newServiceDetail));
        }

        return serviceDetails;
    }

    public List<ServiceDetailDTO> getAllServiceDetails() {
        return modelMapper.map(serviceDetailRepo.findAll(), List.class);
    }
}
