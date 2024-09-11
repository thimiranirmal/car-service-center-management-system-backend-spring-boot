package com.bit.cscms.service;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.model.Category;
import com.bit.cscms.repo.CategoryRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public CategoryDTO getCategoryById(int id) {
        Category category= categoryRepo.findById(id).get();
        return modelMapper.map(category, CategoryDTO.class);
    }

    public List<CategoryDTO> getAllCategory() {
        List<Category> categories = categoryRepo.findAll();
        return modelMapper.map(categories,new TypeToken<List<CategoryDTO>>(){}.getType());
    }

    public CategoryDTO saveCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepo.save(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    public CategoryDTO updateCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        categoryRepo.save(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    public String deleteCategory(int cat_id) {
        categoryRepo.deleteById(cat_id);
        return "Category deleted";
    }
}
