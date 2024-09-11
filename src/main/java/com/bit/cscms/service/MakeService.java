package com.bit.cscms.service;

import com.bit.cscms.dto.MakeDTO;
import com.bit.cscms.model.Make;
import com.bit.cscms.repo.MakeRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class MakeService {

    @Autowired
    private MakeRepo makeRepo;

    @Autowired
    private ModelMapper modelMapper;

    public MakeDTO addMake(MakeDTO makeDTO) {
        Make make = modelMapper.map(makeDTO, Make.class);
        makeRepo.save(make);
        return modelMapper.map(make, MakeDTO.class);
    }

    public List<MakeDTO> getAllMake() {
        List<Make> makeList = makeRepo.findAll();
        return modelMapper.map(makeList, new TypeToken<List<MakeDTO>>() {}.getType());
    }

    public MakeDTO getMakeById(int id) {
        return modelMapper.map(makeRepo.findById(id).get(), MakeDTO.class);
    }

    public MakeDTO updateMake(MakeDTO makeDTO) {
        Make make = modelMapper.map(makeDTO, Make.class);
        makeRepo.save(make);
        return modelMapper.map(make, MakeDTO.class);
    }

    public String deleteMake(int id) {
        makeRepo.deleteById(id);
        return "Make deleted";

    }
}
