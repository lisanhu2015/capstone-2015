package org.lsh.util.db;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by lsh on 15/3/3.
 */
public class HibernateUtils {

    @Autowired
    private SessionFactory sf;

    public void add(Object object) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.save(object);

        session.getTransaction().commit();
        session.close();
    }

    public void delete(Object object) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.delete(object);

        session.getTransaction().commit();
        session.close();
    }

    public void update(Object object) {
        Session session = sf.openSession();
        session.beginTransaction();

        session.update(object);

        session.getTransaction().commit();
        session.close();
    }

    public List query(String hql, Object... objects) {
        Session session = sf.openSession();

        Query query = session.createQuery(hql);
        for (int i = 0; i < objects.length; ++i) {
            query.setParameter(i, objects[i]);
        }
        List result = query.list();

        session.close();
        return result;
    }

}
