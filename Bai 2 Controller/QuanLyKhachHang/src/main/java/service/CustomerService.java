package service;

import model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    List<Customer> customerList = new ArrayList<>();

    {
        customerList.add(new Customer(1, "a", "a@gmail.com", "hue"));
        customerList.add(new Customer(2, "b", "b@gmail.com", "hue"));
        customerList.add(new Customer(3, "c", "c@gmail.com", "hue"));
        customerList.add(new Customer(4, "d", "d@gmail.com", "hue"));
        customerList.add(new Customer(5, "e", "e@gmail.com", "hue"));
    }

    public List<Customer> getAll() {
        return this.customerList;
    }

    public void add(Customer customer) {
        this.customerList.add(customer);
    }

    public Customer findById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean edit(Customer customer) {
        Customer customer1 = this.findById(customer.getId());
        if (customer == customer1) {
            return false;
        }
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        return true;
    }

    public boolean delete(Customer customer){
        Customer customer1 = this.findById(customer.getId());
        if (customer1 == null){
            return false;
        }else {
            customerList.remove(customer);
            return true;
        }
    }
}
