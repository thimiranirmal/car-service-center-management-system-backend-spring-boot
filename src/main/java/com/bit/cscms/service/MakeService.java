package com.bit.cscms.service;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.dto.MakeDTO;
import com.bit.cscms.model.Category;
import com.bit.cscms.model.Make;
import com.bit.cscms.repo.MakeRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class MakeService {

    @Autowired
    private MakeRepo makeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @SneakyThrows
    public MakeDTO addMake(MakeDTO makeDTO, MultipartFile image) {
        Make make = modelMapper.map(makeDTO, Make.class);
        make.setMake_img(image.getBytes());
        makeRepo.save(make);
        return modelMapper.map(make, MakeDTO.class);
    }

    public List<MakeDTO> getAllMake() {
        List<Make> makeList = makeRepo.findAll();
        return makeList.stream().map(this::convertToDTO).collect(Collectors.toList());
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

    private MakeDTO convertToDTO(Make make) {
        MakeDTO makeDTO = modelMapper.map(make, MakeDTO.class);

        // Encode image data to Base64
        if (make.getMake_img() != null) {
            String base64Image = Base64.getEncoder().encodeToString(make.getMake_img());
            makeDTO.setMake_img(base64Image);
        }

        return makeDTO;
    }
}
