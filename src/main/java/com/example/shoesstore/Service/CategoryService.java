package com.example.shoesstore.Service;

import com.example.shoesstore.Entity.Category;
import com.example.shoesstore.Model.Requests.CreateCategoryRequest;


import java.util.List;

public interface CategoryService {
    List<Category> getListEnabled();

    Category createCategory(CreateCategoryRequest createCategoryRequest);

    Category updateCategory(Long cateId, CreateCategoryRequest createCategoryRequest);
    void deleteCategory(Long cateId);
}
