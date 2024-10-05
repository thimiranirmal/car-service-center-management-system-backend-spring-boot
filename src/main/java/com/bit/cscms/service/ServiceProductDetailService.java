package com.bit.cscms.service;

import com.bit.cscms.dto.ServiceDetailDTO;
import com.bit.cscms.dto.ServiceProductDetailsDTO;
import com.bit.cscms.model.*;
import com.bit.cscms.repo.ProductRepo;
import com.bit.cscms.repo.ServiceProductDetailRepo;
import com.bit.cscms.repo.ServiceRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class ServiceProductDetailService {

    @Autowired
    private ServiceProductDetailRepo serviceProductDetailRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private ProductRepo productRepo;

    public List<ServiceProductDetails> createServiceProductDetail(ServiceProductDetailsDTO serviceProductDetailsDTO) {

        com.bit.cscms.model.Service service = serviceRepo.findById(serviceProductDetailsDTO.getServiceId()).orElseThrow();

        List<ProductDetailsQty> productIds = serviceProductDetailsDTO.getProductIdWithQty();
        List<ServiceProductDetails> serviceProductDetails = new ArrayList<>();

        for (ProductDetailsQty productId : productIds) {
            Product product = productRepo.findById(productId.getProductId()).orElseThrow();
            ServiceProductDetails serviceProductDetails1 = modelMapper.map(serviceProductDetailsDTO, ServiceProductDetails.class);
            serviceProductDetails1.setProduct(product);
            serviceProductDetails1.setService(service);
            serviceProductDetails1.setQuantity(productId.getQty());
            serviceProductDetails.add(serviceProductDetailRepo.save(serviceProductDetails1));
        }

        return serviceProductDetails;
    }

    public List<ServiceProductDetails> getAllServiceProductDetails() {
        return modelMapper.map(serviceProductDetailRepo.findAll(), List.class);
    }
}
