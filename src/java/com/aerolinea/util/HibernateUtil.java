package com.aerolinea.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static final SessionFactory SESSIONFACTORY;
    
    static {
        try {
            Configuration config = new Configuration();
            config.configure();
            ServiceRegistry service = new StandardServiceRegistryBuilder().
                    applySettings(config.getProperties()).build();
            SESSIONFACTORY = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory(service);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return SESSIONFACTORY;
    }
}

