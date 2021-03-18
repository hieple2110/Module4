package com.service;

import com.model.Blog;
import com.repository.BlogRepositoryIp;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;


public class BlogService implements BlogServiceIm {
    @Autowired
    private BlogRepositoryIp blogRepository;


    @Override
    public List<Blog> findAll() {
        return blogRepository.getAll();
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    @Transactional
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(int id) {
        blogRepository.delete(id);
    }
}
