package com.bit.cscms.repo;

import com.bit.cscms.model.Make;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakeRepo extends JpaRepository<Make,Integer> {
}
