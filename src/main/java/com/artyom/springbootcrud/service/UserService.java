package com.artyom.springbootcrud.service;

import com.artyom.springbootcrud.dto.UserInfo;
import com.artyom.springbootcrud.dto.UserList;
import com.artyom.springbootcrud.dto.UserRequest;

public interface UserService {
    void create(UserRequest request);
    void updateById(Long id, UserRequest request);
    UserInfo findById(Long id);
    UserList findAll();
    void deleteById(Long id);
}
