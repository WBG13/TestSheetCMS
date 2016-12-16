package db;

import core.DocumentType;
import core.IDocument;
import db.interfaces.IDAOManager;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class DAOManager<T extends IDocument> implements IDAOManager<T> {

    public abstract DocumentType GetQueryPrefix();

    public void Create(T obj) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.save(obj);
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

    public T Read(String id, String table) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        T result = null;
        try {
            //todo read from where?
            String queryString = String.format("from %2$s where id = %1$s", id, table);
            Query query = session.createQuery(queryString);
            result = (T) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return result;
    }

    public List<T> ReadAll(String query, int limit, int offset) {
        List<T> result = new ArrayList();
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            String fullQuery = String.format("FROM %1$s WHERE %2$s", this.GetQueryPrefix(), query);
            result = session.createQuery(fullQuery)
                    .setMaxResults(limit).setFirstResult(offset).list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return result;
    }

    public void Update(T obj) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            session.update(obj);
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

    public void Delete(String id) {
        Transaction transaction = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            T obj = null;
            session.load(obj, new Integer(id));
            session.delete(obj);
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
}
