package org.example.pwt_lab6.DAOs;

import org.example.pwt_lab6.Classes.Invoice;
import org.example.pwt_lab6.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;
import java.util.List;

public class InvoiceDao {
    public void save(Invoice invoice) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(invoice);
            transaction.commit();
            System.out.println("Invoice has been saved successfully");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void update(Invoice invoice) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.merge(invoice);
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
            Invoice np = session.find(Invoice.class, id);
            if (np != null) {
                session.remove(np);
                System.out.println("Invoice has been deleted");
            }
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Invoice getInvoice(long id) {
        Transaction transaction = null;
        Invoice invoice = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            invoice = session.byId(Invoice.class).load(id);
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return invoice;
    }
    @SuppressWarnings("unchecked")
    public List<Invoice> getAllInvoice() {
        Transaction transaction = null;
        List<Invoice> invoices = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            invoices = session.createQuery("select distinct i from Invoice i join fetch i.product join fetch i.seller join fetch i.buyer").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return invoices;
    }
    @SuppressWarnings("unchecked")
    public List<Invoice> getByDate(LocalDate beginDate, LocalDate endDate) {
        Transaction transaction = null;
        List<Invoice> invoices = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            invoices = session.createQuery("select distinct i " +
                    "from Invoice i " +
                    "join fetch i.product " +
                    "join fetch i.seller " +
                    "join fetch i.buyer " +
                    "where i.date >= :beginDate and i.date <= :endDate")
                    .setParameter("beginDate", beginDate).setParameter("endDate", endDate).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return invoices;
    }
    public List<Invoice> getByDate(LocalDate date) {
        return getByDate(date, date);
    }
    @SuppressWarnings("unchecked")
    public List<Invoice> getBySeller(Long id) {
        Transaction transaction = null;
        List<Invoice> invoices = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            invoices = session.createQuery("select distinct i " +
                            "from Invoice i " +
                            "join fetch i.product " +
                            "join fetch i.seller " +
                            "join fetch i.buyer " +
                            "where i.seller.id = :id")
                    .setParameter("id", id).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return invoices;
    }
    @SuppressWarnings("unchecked")
    public List<Invoice> getByBuyer(Long id) {
        Transaction transaction = null;
        List<Invoice> invoices = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            invoices = session.createQuery("select distinct i " +
                            "from Invoice i " +
                            "join fetch i.product " +
                            "join fetch i.seller " +
                            "join fetch i.buyer " +
                            "where i.buyer.id = :id")
                    .setParameter("id", id).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return invoices;
    }
}
