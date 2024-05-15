package com.artyom.springbootcrud.service;

import com.artyom.springbootcrud.dao.UserDAO;
import com.artyom.springbootcrud.dto.UserInfo;
import com.artyom.springbootcrud.dto.UserList;
import com.artyom.springbootcrud.dto.UserRequest;
import com.artyom.springbootcrud.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Transactional
    @Override
    public void create(UserRequest request) {
        userDAO.save(User.newOf(request));
    }

    @Transactional
    @Override
    public void updateById(Long id, UserRequest request) {
        userDAO.updateById(id, User.newOf(request));
    }

    @Transactional(readOnly = true)
    @Override
    public UserInfo findById(Long id) {
        Optional<User> userOptional = userDAO.fetchById(id);
       return userOptional.map(UserInfo::from).orElse(null);
    }

    @Transactional(readOnly = true)
    @Override
    public UserList findAll() {
        return UserList.of( userDAO.fetchAll().orElse(Collections.emptyList())
                .stream()
                .map(UserList.Item::from)
                .toList()
        );
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        userDAO.deleteById(id);
    }
}
