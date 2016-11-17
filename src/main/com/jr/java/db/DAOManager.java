package db;

import core.DocumentType;
import core.IDocument;
import db.interfaces.IDAOManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOManager< T extends IDocument > implements IDAOManager< T > {

    public abstract DocumentType GetQueryPrefix();

    @Override
    public void Create(T obj) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save( obj );
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    @Override
    public T Read( String query ) {
       return null;

    }

    @Override
    public List< T > ReadAll(String query, int limit, int offset) {
        List< T > result = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            result = session.createQuery(String.format("from {0} ", this.GetQueryPrefix() )).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return result;
    }

    @Override
    public void Update(T obj) {

    }

    @Override
    public void Delete(T obj) {

    }
}
