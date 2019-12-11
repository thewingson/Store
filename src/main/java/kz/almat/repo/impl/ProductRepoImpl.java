package kz.almat.repo.impl;

import kz.almat.model.Product;
import kz.almat.model.dto.ProductFilterDTO;
import kz.almat.repo.ProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@SuppressWarnings("unchecked")
public class ProductRepoImpl implements ProductRepo {

    @Autowired
    private SessionFactory sessionFactory;

    public List<Product> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery(" from Product ").list();
    }

    public Product getById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Product.class, id);
//        return (Product) session.createQuery(" from Product where id=:id").setParameter("id", id).list();
    }

    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
//        session.close();
    }

    public void delete(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(product);

    }

    public void edit(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    public List<Product> getByCategoryId(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return (List<Product>) session.createQuery(" from Product where category.id=:categoryId").setParameter("categoryId", id).list();
    }

    public List<Product> getByFilter(ProductFilterDTO filterDTO) {
        Session session = sessionFactory.getCurrentSession();
        return (List<Product>) session.createQuery(" from Product " +
                "where " +
                "name like concat('%',:name,'%') " +
                "and vendor.name like concat('%',:vendor,'%') " +
                "and price between :minPrice and :maxPrice")
                .setParameter("name", filterDTO.getName())
                .setParameter("vendor", filterDTO.getVendor())
                .setParameter("minPrice", filterDTO.getMinPrice())
                .setParameter("maxPrice", filterDTO.getMaxPrice())
                .list();
    }

    public List<Product> getProductInId(Map<Long, Integer> cart) {
        Session session = sessionFactory.getCurrentSession();

//        StringBuilder ids = new StringBuilder();
//
//        for(Map.Entry<Long, Integer> c : cart.entrySet()){
//            ids.append(c.getKey());
//            ids.append(",");
//        }
//        ids.deleteCharAt(ids.length()-1);

        return (List<Product>) session
//                .createSQLQuery("select * from product where id in ("+ids+")").list();
                .createQuery(" from Product where id in (:ids)")
                .setParameterList("ids", cart.keySet())
                .list();
    }
}
