package com.artyom.springbootcrud.dao;

import com.artyom.springbootcrud.entity.User;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    void save(User user);
    void updateById(Long id, User user);
    Optional<List<User>> fetchAll();
    Optional<User> fetchById(Long id);
    void deleteById(Long id);
}
