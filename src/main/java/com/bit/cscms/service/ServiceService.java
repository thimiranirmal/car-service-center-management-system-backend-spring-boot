package com.bit.cscms.service;

import com.bit.cscms.dto.ServiceDTO;
import com.bit.cscms.model.Booking;
import com.bit.cscms.repo.BookingRepo;
import com.bit.cscms.repo.ServiceRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ServiceService {

    @Autowired
    private ServiceRepo serviceRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    public ServiceDTO createService(ServiceDTO serviceDTO) {
        com.bit.cscms.model.Service service = modelMapper.map(serviceDTO, com.bit.cscms.model.Service.class);

        Booking booking = bookingRepo.findById(serviceDTO.getBooking_id()).orElseThrow();
        service.setBooking(booking);

        return modelMapper.map(serviceRepo.save(service), ServiceDTO.class);
    }

    public ServiceDTO updateService(ServiceDTO serviceDTO) {
        com.bit.cscms.model.Service service = modelMapper.map(serviceDTO, com.bit.cscms.model.Service.class);

        Booking booking = bookingRepo.findById(serviceDTO.getBooking_id()).orElseThrow();
        service.setBooking(booking);

        return modelMapper.map(serviceRepo.save(service), ServiceDTO.class);
    }

    public List<ServiceDTO> getAllServices() {
        List<com.bit.cscms.model.Service> serviceList = serviceRepo.findAll();
        return modelMapper.map(serviceList, new TypeToken<List<ServiceDTO>>() {}.getType());
    }

    public com.bit.cscms.model.Service getServiceById(int id) {
        return modelMapper.map(serviceRepo.findById(id), com.bit.cscms.model.Service.class);
    }
}
