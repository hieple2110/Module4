package com.service;

import java.util.List;

public interface BaseService <G>{

    List<G> findAll();

    G findById(int id);

    void save(G g);

    void remove(int id);
}
