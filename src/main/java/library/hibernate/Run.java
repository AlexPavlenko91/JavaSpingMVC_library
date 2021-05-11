package library.hibernate;

import library.hibernate.HibernateUtil;
import library.models.Library;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class Run {
    public static void main(String[] args) {
        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            Library lib = new Library();
            lib.setId(2L);
            lib.setName("Central library");
            lib.setCity("Kiev");

            session.save(lib);

            session.getTransaction().commit();
            HibernateUtil.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
