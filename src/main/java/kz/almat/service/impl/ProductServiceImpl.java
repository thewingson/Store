package kz.almat.service.impl;

import kz.almat.model.Product;
import kz.almat.repo.ProductRepo;
import kz.almat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepo productRepo;

    public List<Product> getAll() {
        return productRepo.getAll();
    }

    public Product getById(Long id) {
        return productRepo.getById(id);
    }

    public void add(Product product) {
        productRepo.add(product);
    }

    public void delete(Product product) {
        productRepo.delete(product);

    }

    public void edit(Product product) {
        productRepo.edit(product);
    }
}
