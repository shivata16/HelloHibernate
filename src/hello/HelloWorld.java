package hello;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.Hello;

public class HelloWorld {

    public static void main(String[] args) throws HibernateException {

        Configuration config = new Configuration();
        config = config.configure();

        SessionFactory sessionFactory = config.buildSessionFactory();
        Session session = sessionFactory.openSession();

        List list = session.createCriteria(Hello.class).list();

        for (int i = 0; i < list.size(); i++) {
            Hello hello = (Hello)list.get(i);
            System.out.println(hello.getId() + ":" + hello.getName());
        }
    }
}
