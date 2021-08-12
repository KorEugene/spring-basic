package ru.geekbrains.spring.basic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.basic.model.Customer;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDao {

    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Customer findById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            TypedQuery<Customer> query = session.createQuery("select c from Customer c join fetch c.productList", Customer.class);
            query.getResultList();
            session.getTransaction().commit();
            return customer;
        }
    }

    public List<Customer> findAll() {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c", Customer.class).getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    public void deleteById(Long id) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("delete from Customer c where c.id = :id")
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        }
    }

    public Customer saveOrUpdate(Customer customer) {
        try (Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(customer);
            session.getTransaction().commit();
            return customer;
        }
    }
}
