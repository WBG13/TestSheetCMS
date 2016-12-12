package Test;

import core.DocumentType;
import db.DAOManager;
import db.HibernateUtil;
import model.beans.Employee;
import org.hibernate.Session;


/**
 * Created by TH-221 on 30.11.2016.
 */
public class TestHibernateInsert {


    public static void main(String[] args) {


        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();



        Employee emp = new Employee();
//        DAOManager daoManager= new DAOManager<>() {
//            @Override
//            public DocumentType GetQueryPrefix() {
//                return null;
//            }
//
//            public DocumentType Employee() {
//                return null;
//            }
//        };



        emp.setName("Bob");
        emp.setSurname("Zx");
        emp.setPatronymic("gupta");
        emp.setPosition("Director");
        emp.setDepartmentId("1");
        emp.setOrganizationId("1");
        emp.setId(1);

        session.save(emp);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
