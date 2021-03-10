package service;

import model.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {

    List<Customer> customerList = new ArrayList<>();

    {
        customerList.add(new Customer(1, "A", "a@gmail.com", "hue"));
        customerList.add(new Customer(2, "B", "b@gmail.com", "hue"));
        customerList.add(new Customer(3, "C", "c@gmail.com", "hue"));
        customerList.add(new Customer(4, "D", "d@gmail.com", "hue"));
    }

    public List<Customer> getAll() {
        return customerList;
    }

    public Customer getById(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public boolean update(Customer customer) {
        Customer customer1 = getById(customer.getId());
        if (customer1 == customer) {
            return false;
        }
        customer1.setName(customer.getName());
        customer1.setEmail(customer.getEmail());
        customer1.setAddress(customer.getAddress());
        return true;
    }

    public void add(Customer customer) {
        customerList.add(customer);
    }


}
