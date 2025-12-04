package org.example.pwt_lab6.DAOs;

import org.example.pwt_lab6.Classes.Seller;
import org.example.pwt_lab6.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SellerDao {
    public void save(Seller seller) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(seller);
            transaction.commit();
            System.out.println("Seller has been saved successfully");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void update(Seller seller) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.merge(seller);
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
            Seller np = session.find(Seller.class, id);
            if (np != null) {
                session.remove(np);
                System.out.println("Seller has been deleted");
            }
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Seller getSeller(long id) {
        Transaction transaction = null;
        Seller seller = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            seller = session.byId(Seller.class).load(id);
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return seller;
    }
    @SuppressWarnings("unchecked")
    public List<Seller> getAllSeller() {
        Transaction transaction = null;
        List<Seller> sellers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            sellers = session.createQuery("from Seller").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return sellers;
    }
    @SuppressWarnings("unchecked")
    public List<Seller> getTopSeller() {
        Transaction transaction = null;
        List<Seller> sellers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            sellers = session.createQuery("select s from Seller s join Invoice i on s = i.seller group by s order by COUNT(i) DESC").setMaxResults(1).getResultList();
            System.out.println(sellers.getFirst().toString());
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return sellers;
    }

}
