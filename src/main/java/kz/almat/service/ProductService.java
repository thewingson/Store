package kz.almat.service;

import kz.almat.model.Product;
import kz.almat.model.dto.ProductFilterDTO;

import java.util.List;
import java.util.Map;

public interface ProductService {

    List<Product> getAll();
    Product getById(Long id);
    List<Product> getByFilter(ProductFilterDTO filterDTO);
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    List<Product> getByCategoryId(Long id);

    Map<Product,Integer> getCartItems(Map<Long,Integer> cart);
}
