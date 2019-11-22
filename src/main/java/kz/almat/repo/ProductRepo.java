package kz.almat.repo;

import kz.almat.model.Product;

import java.util.List;

public interface ProductRepo {

    List<Product> getAll();
    Product getById(Long id);
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    List<Product> getByCategoryId(Long id);

}
