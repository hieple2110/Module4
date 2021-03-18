package com.hiep.repository;

import com.hiep.model.Customer;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Transactional

public class CustomerRepository implements ICustomerRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = entityManager.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId() != -1 || customer.getId() != 0) {
            entityManager.merge(customer);
        } else {
            entityManager.persist(customer);
        }
    }

    @Override
    public void remove(int id) {
        Customer customer = findById(id);
        if (customer != null) {
            entityManager.remove(customer);
        }
    }

    @Override
    public Customer findById(int id) {
        TypedQuery<Customer> query = entityManager.createQuery("select  c from Customer c where c.id =:id", Customer.class);
        query.setParameter("id", id);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }

    }
}
