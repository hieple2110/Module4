package com.codegym.service;

import com.codegym.model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class CustomerService implements ICustomerService<Customer> {
    private static Map<Integer, Customer> listCustomer;

    static {
        listCustomer = new HashMap<>();
        listCustomer.put(1, new Customer(1, "A", "a@gmail.com", "Hue"));
        listCustomer.put(2, new Customer(2, "B", "b@gmail.com", "Hue"));
        listCustomer.put(3, new Customer(3, "C", "c@gmail.com", "Hue"));
    }

    @Override
    public List<Customer> getAll() {
        return new ArrayList<>(listCustomer.values());
    }

    @Override
    public void add(Customer customer) {
        listCustomer.put(customer.getId(), customer);
    }

    @Override
    public void update(int id, Customer customer) {
        listCustomer.put(id, customer);
    }

    @Override
    public void delete(int id) {
        listCustomer.remove(id);
    }

    @Override
    public Customer findById(int id) {
        return listCustomer.get(id);
    }
}
