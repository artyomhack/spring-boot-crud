package com.artyom.springbootcrud.dto;

import com.artyom.springbootcrud.entity.User;

public record UserInfo(
        Long id,
        String name,
        String lastName,
        Byte age
) {
    public static UserInfo from(User user) {
        return new UserInfo(user.getId(), user.getName(), user.getLastname(), user.getAge());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
