package kz.almat.service.impl;

import kz.almat.model.Product;
import kz.almat.model.dto.ProductFilterDTO;
import kz.almat.repo.ProductRepo;
import kz.almat.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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

    public List<Product> getByFilter(ProductFilterDTO filterDTO) {
        return productRepo.getByFilter(filterDTO);
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

    public List<Product> getByCategoryId(Long id) {
        return productRepo.getByCategoryId(id);
    }

    public Map<Product, Integer> getCartItems(Map<Long, Integer> cart) {
        List<Product> products = productRepo.getProductInId(cart);

        Map<Product, Integer> items = new HashMap<Product, Integer>();

//        Iterator itr = products.iterator();
//
//        while(itr.hasNext()){
//            Product product = (Product) itr.next();
//            items.put(product, cart.get(product.getId()));
//        }

        for(Product p: products){
            items.put(p, cart.get(p.getId()));
        }

        return  items;
    }
}
