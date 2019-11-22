package kz.almat.service;

import kz.almat.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category getById(Long id);
    void add(Category category);
    void delete(Category category);
    void edit(Category category);

}
