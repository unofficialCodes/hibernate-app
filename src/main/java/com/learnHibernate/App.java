package com.learnHibernate;

import com.learnHibernate.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App
{
    public static void main( String[] args )
    {

//        Configuration cfg = new Configuration();
        // cfg.addResource("item.cfg.xml");
        // cfg.setProperties(new Properties());
        /*Configuration config = new Configuration()
                .setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect")
                .setProperty("hibernate.connection.datasource", "java:comp/env/jdbc/test")
                .setProperty("hibernate.order_updates", "true");*/
        /*cfg.configure();

        SessionFactory factory = cfg.buildSessionFactory();
        factory.fromTransaction(session -> {
            return session.get("", "");
        });*/

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("student_pu");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();

        transaction.begin();
        /*entityManager.createQuery("this is jpql/hql entity based query");
        entityManager.createNativeQuery("this is native query");*/
        Student s1 = new Student(1L, "student1", "student1@email.com");
        entityManager.persist(s1);
        transaction.commit();

        /*System.out.println(factory.isOpen());

        factory.close();*/
    }
}
