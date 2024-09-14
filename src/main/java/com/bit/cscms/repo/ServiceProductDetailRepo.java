package com.bit.cscms.repo;

import com.bit.cscms.model.ServiceProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface ServiceProductDetailRepo extends JpaRepository<ServiceProductDetails, Integer> {
}
