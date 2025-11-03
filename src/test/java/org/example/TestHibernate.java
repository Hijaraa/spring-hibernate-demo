package org.example;

import org.example.util.HibernateConfig;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

import static org.junit.Assert.*;

public class TestHibernate {

    @Test
    public void testHibernateConfiguration() {
        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        // Test SessionFactory configuration
        SessionFactory sessionFactory = context.getBean(SessionFactory.class);
        assertNotNull("SessionFactory should not be null", sessionFactory);

        // Test TransactionManager configuration
        HibernateTransactionManager txManager = context.getBean(HibernateTransactionManager.class);
        assertNotNull("Transaction Manager should not be null", txManager);
    }
}
