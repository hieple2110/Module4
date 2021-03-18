package com.repository;

import java.util.List;

public interface BaseRepository<G> {

    List<G> getAll();

    void save(G g);

    void delete(int id);

    G findById(int id);
}
