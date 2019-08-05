package com.codegym.repository.Customer;

import com.codegym.model.Customer;
import com.codegym.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
@Transactional
public class CustomerRepositoryImpl implements CustomerRepository {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<Customer> findAll() {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c", Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer findById(Long id) {
        TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.id=:id",Customer.class);
        query.setParameter("id",id);
        return query.getSingleResult();
    }

    @Override
    public void save(Customer customer) {
        if (customer.getId()!=null){
            em.merge(customer);
        }
        else {
            em.persist(customer);
        }
    }

    @Override
    public void delete(Long id) {
        Customer customer = findById(id);
        if (customer.getId()!=null){
            em.remove(customer);
        }
    }
}
