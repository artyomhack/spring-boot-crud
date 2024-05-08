package com.artyom.springbootcrud.dao;

import com.artyom.springbootcrud.entity.User;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface UserDAO {
    @Transactional
    void save(User user);
    @Transactional
    void updateById(Long id, User user);
    @Transactional(readOnly = true)
    Optional<List<User>> fetchAll();
    @Transactional(readOnly = true)
    Optional<User> fetchById(Long id);
    @Transactional
    void deleteById(Long id);
}
