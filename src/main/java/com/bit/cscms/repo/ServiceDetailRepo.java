package com.bit.cscms.repo;

import com.bit.cscms.model.Service_Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceDetailRepo extends JpaRepository<Service_Detail,Integer> {
}
