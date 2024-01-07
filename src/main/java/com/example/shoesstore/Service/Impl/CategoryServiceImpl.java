package com.example.shoesstore.Service.Impl;

import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Exception.ResourceNotFoundException;
import com.example.shoesstore.Model.Requests.CreateCategoryRequest;
import com.example.shoesstore.Repository.CategoryRepository;
import com.example.shoesstore.Service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> getListEnabled() {
        List<Category> list = categoryRepository.findALLByEnabled();
        return list;
    }

    @Override
    public Category createCategory(CreateCategoryRequest request) {
        Category category = new Category();
        category.setCateName(request.getCateName());
        category.setCateState(true);
        categoryRepository.save(category);
        return category;
    }

    @Override
    public Category updateCategory(Long cateId, CreateCategoryRequest request) {
        Category category = categoryRepository.findById(cateId)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Category With Id: " + cateId));
        category.setCateName(request.getCateName());
        categoryRepository.save(category);
        return category;
    }

    @Override
    public void deleteCategory(Long cateId) {
        Category category = categoryRepository.findById(cateId)
                .orElseThrow(()-> new ResourceNotFoundException("Not Found Category With Id: " + cateId));
        categoryRepository.delete(category);
    }
}
