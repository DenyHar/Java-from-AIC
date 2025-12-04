package org.example.pwt_lab6;

import org.example.pwt_lab6.Classes.Buyer;
import org.example.pwt_lab6.Classes.Invoice;
import org.example.pwt_lab6.Classes.Product;
import org.example.pwt_lab6.Classes.Seller;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
                configuration.addAnnotatedClass(Seller.class);
                configuration.addAnnotatedClass(Buyer.class);
                configuration.addAnnotatedClass(Product.class);
                configuration.addAnnotatedClass(Invoice.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                System.out.println("Hibernate Java Config serviceRegistry created");
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
                return sessionFactory;
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return sessionFactory;
    }

}
