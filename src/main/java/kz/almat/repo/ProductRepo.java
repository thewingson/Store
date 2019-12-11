package kz.almat.repo;

import kz.almat.model.Product;
import kz.almat.model.dto.ProductFilterDTO;

import java.util.List;
import java.util.Map;

public interface ProductRepo {

    List<Product> getAll();
    Product getById(Long id);
    void add(Product product);
    void delete(Product product);
    void edit(Product product);
    List<Product> getByCategoryId(Long id);

    List<Product> getByFilter(ProductFilterDTO filterDTO);

    List<Product> getProductInId(Map<Long,Integer> cart);
}
