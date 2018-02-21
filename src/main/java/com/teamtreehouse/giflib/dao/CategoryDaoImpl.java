package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Category> q = cb.createQuery(Category.class);
        q.from(Category.class);

        List<Category> categories = session.createQuery(q).getResultList();

        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        return null;
    }

    @Override
    public void save(Category category) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.save(category);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(Category category) {

    }
}
