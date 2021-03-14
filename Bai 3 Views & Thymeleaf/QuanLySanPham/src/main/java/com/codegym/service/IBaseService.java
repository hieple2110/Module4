package com.codegym.service;

import java.util.List;

public interface IBaseService<G> {
    List<G> getAll();

    void add(G g);

    void update(int id, G g);

    void delete(int id);

    G findById(int id);
}
