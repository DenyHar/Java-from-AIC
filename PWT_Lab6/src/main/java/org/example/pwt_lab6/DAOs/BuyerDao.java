package org.example.pwt_lab6.DAOs;

import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Seller;
import org.example.pwt_lab6.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BuyerDao {
    public void save(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(buyer);
            transaction.commit();
            System.out.println("Buyer has been saved successfully");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void update(Buyer buyer) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.merge(buyer);
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
            Buyer np = session.find(Buyer.class, id);
            if (np != null) {
                session.remove(np);
                System.out.println("Buyer has been deleted");
            }
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Buyer getBuyer(long id) {
        Transaction transaction = null;
        Buyer buyer = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            buyer = session.byId(Buyer.class).load(id);
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return buyer;
    }
    @SuppressWarnings("unchecked")
    public List<Buyer> getAllBuyer() {
        Transaction transaction = null;
        List<Buyer> buyers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            buyers = session.createQuery("from Buyer").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return buyers;
    }
    @SuppressWarnings("unchecked")
    public List<Buyer> getTopBuyer() {
        Transaction transaction = null;
        List<Buyer> buyers = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            buyers = session.createQuery("select b from Buyer b join Invoice i on b = i.buyer group by b order by COUNT(i) DESC").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return buyers;
    }
}
