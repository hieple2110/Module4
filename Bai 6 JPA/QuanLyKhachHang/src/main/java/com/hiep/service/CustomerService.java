package com.hiep.service;

import com.hiep.model.Customer;
import com.hiep.repository.CustomerRepository;
import com.hiep.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;


import javax.transaction.Transactional;
import java.util.List;

public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepository.findAll();
    }

    @Override
    @Transactional
    public void save(Customer customer) {
        iCustomerRepository.save(customer);
    }

    @Override
    public void remove(int id) {
        iCustomerRepository.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return iCustomerRepository.findById(id);
    }
}
