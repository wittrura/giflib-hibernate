package com.teamtreehouse.giflib.dao;

import com.teamtreehouse.giflib.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

        Root<Category> routeRoot = q.from(Category.class);
        q.select(routeRoot);

        List<Order> orderList = new ArrayList();
        orderList.add(cb.asc(routeRoot.get("id")));

        q.orderBy(orderList);

        List<Category> categories = session.createQuery(q).getResultList();

        session.close();

        return categories;
    }

    @Override
    public Category findById(Long id) {
        Session session = sessionFactory.openSession();

        Category category = session.get(Category.class, id);

        session.close();

        return category;
    }

    @Override
    public void save(Category category) {
        Session session = sessionFactory.openSession();

        session.beginTransaction();
        session.saveOrUpdate(category);
        session.getTransaction().commit();

        session.close();
    }

    @Override
    public void delete(Category category) {

    }
}
