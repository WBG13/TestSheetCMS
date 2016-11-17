package test;

import db.HibernateUtil;
import model.beans.Employee;
import org.hibernate.Session;

/**
 * Created by TH-221 on 08.11.2016.
 */
public class TestHibernateInsert {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Employee emp = new Employee();
        emp.setName("Bob");
        emp.setSurname("Zx");
        emp.setPatronymic("gupta");
        emp.setPosition("Director");

        session.save(emp);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
