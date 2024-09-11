package com.bit.cscms.controller;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/getcategory/{cat_id}")
    public CategoryDTO getCategory(@PathVariable int cat_id) {
        return categoryService.getCategoryById(cat_id);
    }

    @GetMapping("/getallcategory")
    public List<CategoryDTO> getCategory(){
        return categoryService.getAllCategory();
    }

    @PostMapping("/addcategory")
    public CategoryDTO addCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.saveCategory(categoryDTO);
    }

    @PutMapping("/updatecategory")
    public CategoryDTO updateCategory(@RequestBody CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryDTO);
    }

    @DeleteMapping("/deletecategory/{cat_id}")
    public String deleteCategory(@PathVariable int cat_id){
        return categoryService.deleteCategory(cat_id);
    }

}
