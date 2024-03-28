package com.dokuku.semi.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dokuku.semi.Entity.CategoryEntity;
import com.dokuku.semi.Repository.CategoryRepository;

@Service
public class CategoryService {
    @Autowired(required = true)
    private CategoryRepository CategoryRepository;

    public List<CategoryEntity> findAll() {
        List<CategoryEntity> Categorys = new ArrayList<>();
        CategoryRepository.findAll().forEach(e -> Categorys.add(e));
        return Categorys;
    }

    public List<CategoryEntity> findByCategoryId(Long id) {
        List<CategoryEntity> Category = CategoryRepository.findByCategoryId(id);
        return Category;
    }

    public void deleteById(Long id) {
        CategoryRepository.deleteById(id);
    }

    public CategoryEntity save(CategoryEntity Category) {
        CategoryRepository.save(Category);
        return Category;
    }

    public void updateById(Long id, CategoryEntity Category) {
        Optional<CategoryEntity> e = CategoryRepository.findById(id);

        if (e.isPresent()) {
            //e.get().setId(Category.toString());
            CategoryRepository.save(Category);
        }
    }
}


