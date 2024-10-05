package com.bit.cscms.service;

import com.bit.cscms.dto.CategoryDTO;
import com.bit.cscms.model.Category;
import com.bit.cscms.repo.CategoryRepo;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

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
        return categories.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private CategoryDTO convertToDTO(Category category) {
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);

        // Encode image data to Base64
        if (category.getCat_img() != null) {
            String base64Image = Base64.getEncoder().encodeToString(category.getCat_img());
            categoryDTO.setCat_img(base64Image);
        }

        return categoryDTO;
    }

    @SneakyThrows
    public CategoryDTO saveCategory(CategoryDTO categoryDTO, MultipartFile image) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        category.setCat_img(image.getBytes());
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
