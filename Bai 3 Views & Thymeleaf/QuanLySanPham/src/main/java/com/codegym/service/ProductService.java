package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductService implements IBaseService<Product> {
    private static Map<Integer, Product> listProduct;

    static {
        listProduct = new HashMap<>();
        listProduct.put(1, new Product(1, "Coca Cola", "1 barrel", "30000", "Not Gas"));
        listProduct.put(2, new Product(2, "Pepsi ", "1 barrel", "30000", "Not Gas"));
        listProduct.put(3, new Product(3, "Green tea", "1 barrel", "30000", "Not Gas"));
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(listProduct.values());
    }

    @Override
    public void add(Product product) {
        listProduct.put(product.getId(), product);
    }

    @Override
    public void update(int id, Product product) {
        listProduct.put(id, product);
    }

    @Override
    public void delete(int id) {
        listProduct.remove(id);
    }

    @Override
    public Product findById(int id) {
        return listProduct.get(id);
    }
}
