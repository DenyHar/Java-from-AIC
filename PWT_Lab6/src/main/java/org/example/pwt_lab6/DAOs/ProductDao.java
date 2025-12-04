package org.example.pwt_lab6.DAOs;

import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Product;
import org.example.pwt_lab6.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ProductDao {
    public void save(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(product);
            transaction.commit();
            System.out.println("Product has been saved successfully");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void update(Product product) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.merge(product);
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void delete(long id) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            Product np = session.find(Product.class, id);
            if (np != null) {
                session.remove(np);
                System.out.println("Product has been deleted");
            }
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Product getProduct(long id) {
        Transaction transaction = null;
        Product product = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            product = session.byId(Product.class).load(id);
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return product;
    }
    @SuppressWarnings("unchecked")
    public List<Product> getAllProduct() {
        Transaction transaction = null;
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            products = session.createQuery("from Product").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return products;
    }
    @SuppressWarnings("unchecked")
    public List<Product> getTopProduct() {
        Transaction transaction = null;
        List<Product> products = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            products = session.createQuery("select p from Product p join Invoice i on p = i.product group by p order by COUNT(i) DESC").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return products;
    }
}
