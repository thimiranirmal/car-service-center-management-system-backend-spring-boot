package com.bit.cscms.controller;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.dto.MakeDTO;
import com.bit.cscms.service.CategoryService;
import com.bit.cscms.service.MakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/make")
public class MakeController {
    @Autowired
    private MakeService makeService;

    @GetMapping("/getmake/{make_id}")
    public MakeDTO getCategory(@PathVariable int make_id) {
        return makeService.getMakeById(make_id);
    }

    @GetMapping("/getallmake")
    public List<MakeDTO> getMake(){
        return makeService.getAllMake();
    }

    @PostMapping("/addmake")
    public MakeDTO addCategory(@RequestBody MakeDTO makeDTO){
        return makeService.addMake(makeDTO);
    }

    @PutMapping("/updatemake")
    public MakeDTO updateCategory(@RequestBody MakeDTO makeDTO){
        return makeService.updateMake(makeDTO);
    }

    @DeleteMapping("/deletemake/{make_id}")
    public String deleteCategory(@PathVariable int make_id){
        return makeService.deleteMake(make_id);
    }
}
