package com.repository;

import com.model.Blog;
import org.hibernate.criterion.NotExpression;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class BlogRepository implements BlogRepositoryIp {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Blog> getAll() {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c", Blog.class);
        return query.getResultList();
    }

    @Override
    public void save(Blog blog) {
        if (blog.getId() != -1){
            entityManager.merge(blog);
        }else {
            entityManager.persist(blog);
        }
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        if (blog != null) {
            entityManager.remove(blog);
        }
    }

    @Override
    public Blog findById(int id) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog c where c.id = :id", Blog.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
        }
    }

