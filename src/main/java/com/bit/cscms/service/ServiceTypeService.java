package com.bit.cscms.service;

import com.bit.cscms.dto.ServiceTypeDTO;
import com.bit.cscms.model.ServiceType;
import com.bit.cscms.repo.ServiceTypeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceTypeService {
    @Autowired
    private ServiceTypeRepo serviceTypeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ServiceTypeDTO getServiceType(int serviceTypeId) {
        return modelMapper.map(serviceTypeRepo.findById(serviceTypeId).get(), ServiceTypeDTO.class);
    }
    public List<ServiceTypeDTO> getAllServiceTypes() {
        return modelMapper.map(serviceTypeRepo.findAll(), new TypeToken<List<ServiceTypeDTO>>(){}.getType());
    }

    public ServiceTypeDTO createServiceType(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = modelMapper.map(serviceTypeDTO, ServiceType.class);
        serviceTypeRepo.save(serviceType);
        return modelMapper.map(serviceType, ServiceTypeDTO.class);
    }

    public ServiceTypeDTO updateServiceType(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = modelMapper.map(serviceTypeDTO, ServiceType.class);
        serviceTypeRepo.save(serviceType);
        return modelMapper.map(serviceType, ServiceTypeDTO.class);
    }

    public String deleteServiceType(int serviceTypeId) {
        serviceTypeRepo.deleteById(serviceTypeId);
        return "ServiceType Deleted";
    }
}
