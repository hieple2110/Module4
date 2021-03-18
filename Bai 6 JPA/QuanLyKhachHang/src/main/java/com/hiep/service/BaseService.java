package com.hiep.service;

import java.util.List;

public interface BaseService <G>{

    List<G> findAll();

    void save(G g);

    void remove(int id);

    G findById( int id);
}
