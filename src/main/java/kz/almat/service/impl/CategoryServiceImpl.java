package kz.almat.service.impl;

import kz.almat.model.Category;
import kz.almat.repo.CategoryRepo;
import kz.almat.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAll() {
        return categoryRepo.getAll();
    }

    public Category getById(Long id) {
        return categoryRepo.getById(id);
    }

    public Category getByIdWithProducts(Long id) {
        return categoryRepo.getByIdWithProducts(id);
    }

    public void add(Category category) {
        categoryRepo.add(category);
    }

    public void delete(Category category) {
        categoryRepo.delete(category);
    }

    public void edit(Category category) {
        categoryRepo.edit(category);
    }
}
