package com.hiep.repository;

import java.util.List;

public interface Repository <G>{

    List<G> findAll();

    void save(G g);

    void remove(int id);

    G findById( int id);
}
