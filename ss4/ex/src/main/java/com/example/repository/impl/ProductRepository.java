package com.example.repository.impl;


import com.example.model.Product;
import com.example.repository.IProductRepository;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import com.example.SessionUtil;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
//    public static List<Product> productList;
//
//    static {
//        productList = new ArrayList<Product>() {{
//            add(new Product(1, "Iphone 14", 25000000, "64G", "Apple"));
//            add(new Product(2, "Galaxy S11", 20000000, "32G", "Samsung"));
//            add(new Product(3, "Iphone 13", 18000000, "16G", "Apple"));
//        }};
//    }

    @Override
    public List<Product> listProduct(String nameSearch) {
//        if (nameSearch == null) {
//            return productList;
//        }
//        List<Product> products = new ArrayList<>();
//        for (Product product : productList) {
//            if (product.getName().contains(nameSearch)) {
//                products.add(product);
//            }
//        }
//        return products;
        List<Product> productList = null;
        Session session = null;

        try {
            session = SessionUtil.sessionFactory.openSession();
            productList = session.createQuery("from Product where name like concat('%', :nameSearch, '%') ")
                    .setParameter("nameSearch", nameSearch).getResultList();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return productList;
    }

    @Override
    public void create(Product product) {
//        product.setId(productList.size() + 1);
//        productList.add(product);
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.getTransaction();
            transaction.begin();
            session.persist(product);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
//        for (Product product : productList) {
//            if (product.getId() == id) {
//                return product;
//            }
//        }
//
        String query = "select p from Product p where p.id = :id";
        TypedQuery<Product> productTypedQuery = SessionUtil.entityManager.createQuery(query, Product.class);
        productTypedQuery.setParameter("id", id);
        return productTypedQuery.getSingleResult();
    }

    @Override
    public void update(Product product) {
//        for (Product value : productList) {
//            if (product.getId() == value.getId()) {
//                value.setName(product.getName());
//                value.setPrice(product.getPrice());
//                value.setStatus(product.getStatus());
//                value.setProducer(product.getProducer());
//            }
//        }
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product products = findById(product.getId());
            products.setName(product.getName());
            products.setPrice(product.getPrice());
            products.setStatus(product.getStatus());
            products.setProducer(product.getProducer());
            session.saveOrUpdate(products);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }


    @Override
    public void delete(int id) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = SessionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            Product products = findById(id);
            session.remove(products);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
