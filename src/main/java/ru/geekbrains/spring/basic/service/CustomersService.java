package ru.geekbrains.spring.basic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.basic.dao.CustomerDao;
import ru.geekbrains.spring.basic.model.Customer;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomersService {

    private CustomerDao customerDao;

    @Autowired
    public CustomersService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> findAll() {
        return customerDao.findAll().stream().sorted(Comparator.comparing(Customer::getId)).collect(Collectors.toList());
    }

    public Customer findById(Long id) {
        return customerDao.findById(id);
    }



//    public void save(Customer customer) {
//        customerDao.saveOrUpdate(customer);
//    }
//
//    public void deleteById(Long id) {
//        customerDao.deleteById(id);
//    }


}
