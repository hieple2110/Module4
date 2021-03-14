package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;
import java.util.Map;

public interface ICustomerService <G>{

    List<G> getAll();

    void add(G g);

    void update(int id, G g);

    void delete(int id);

    G findById(int id);
}
