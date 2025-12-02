package org.example.pwt_lab5;

import jakarta.transaction.Transactional;
import org.hibernate.Filter;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class NotepadDao {
    public void save(Notepad notepad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.persist(notepad);
            transaction.commit();
            System.out.println("Notepad has been saved successfully");
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public void update(Notepad notepad) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            session.merge(notepad);
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
            Notepad np = session.find(Notepad.class, id);
            if (np != null) {
                session.remove(np);
                System.out.println("Notepad has been deleted");
            }
            transaction.commit();
        }  catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    public Notepad getNotepad(long id) {
        Transaction transaction = null;
        Notepad notepad = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepad = session.byId(Notepad.class).load(id);
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepad;
    }
    @SuppressWarnings("unchecked")
    public List<Notepad> getAllNotepad() {
        Transaction transaction = null;
        List<Notepad> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationByCountry() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("select n.country, SUM(n.circulation) from Notepad n GROUP BY n.country").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationByPublisher() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("select n.publisher, SUM(n.circulation) from Notepad n GROUP BY n.publisher").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationTopCountry() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("SELECT n.country, SUM(n.circulation) as sum from Notepad n GROUP BY n.country ORDER BY sum DESC").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationBottomCountry() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("SELECT n.country, SUM(n.circulation) as sum from Notepad n GROUP BY n.country ORDER BY sum").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationTopPublisher() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("SELECT n.publisher, SUM(n.circulation) as sum from Notepad n GROUP BY n.publisher ORDER BY sum DESC").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getCirculationBottomPublisher() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("SELECT n.publisher, SUM(n.circulation) as sum from Notepad n GROUP BY n.publisher ORDER BY sum").setMaxResults(1).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getAllHardCover() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad where cover = 'Hard'").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Object[]> getAllSoftCover() {
        Transaction transaction = null;
        List<Object[]> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad where cover = 'Soft'").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Notepad> getAllByCountry(String country) {
        Transaction transaction = null;
        List<Notepad> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad where country = ?1").setParameter(1, country).getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Notepad> getFilteredByPageType(String pageType) {
        Transaction transaction = null;
        List<Notepad> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Filter filter = session.enableFilter("pageType");
            filter.setParameter("pPageType", pageType);
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Notepad> getFilteredByPages(int pages) {
        Transaction transaction = null;
        List<Notepad> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Filter filter = session.enableFilter("pages");
            filter.setParameter("pPages", pages);
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
    @SuppressWarnings("unchecked")
    public List<Notepad> getFilteredByCirculation(long circulation) {
        Transaction transaction = null;
        List<Notepad> notepads = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession();){
            Filter filter = session.enableFilter("circulation");
            filter.setParameter("pCirculation", circulation);
            transaction = session.beginTransaction();
            notepads = session.createQuery("from Notepad").getResultList();
        } catch (Exception ex){
            if (transaction != null) {
                transaction.rollback();
            }
        }
        return notepads;
    }
}
