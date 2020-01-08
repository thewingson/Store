package kz.almat.repo.impl;

import kz.almat.model.Product;
import kz.almat.model.dto.ProductFilterDTO;
import kz.almat.repo.ProductRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
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
    }

    public void add(Product product) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
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

        StringBuilder queryString = new StringBuilder("from Product where name like concat('%',:name,'%') and category.id=:category and price between :minPrice and :maxPrice");

        if(filterDTO.getVendor() != null){
            queryString.append(" and vendor.id in(:vendor)");

            return (List<Product>) session.createQuery(queryString.toString())
                    .setParameter("category", filterDTO.getCategory())
                    .setParameter("name", filterDTO.getName())
                    .setParameter("minPrice", filterDTO.getMinPrice())
                    .setParameter("maxPrice", filterDTO.getMaxPrice())
                    .setParameterList("vendor", filterDTO.getVendor())
                    .list();

        }

        return (List<Product>) session.createQuery(queryString.toString())
                .setParameter("category", filterDTO.getCategory())
                .setParameter("name", filterDTO.getName())
                .setParameter("minPrice", filterDTO.getMinPrice())
                .setParameter("maxPrice", filterDTO.getMaxPrice())
                .list();
    }

    public List<Product> getProductInId(Map<Long, Integer> cart) {
        Session session = sessionFactory.getCurrentSession();

        List<Product> products = (List<Product>) session
                .createQuery(" from Product where id in (:ids)")
                .setParameterList("ids", cart.keySet())
                .list();

        return products;
    }
}
