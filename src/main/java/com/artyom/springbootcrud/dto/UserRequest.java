package com.artyom.springbootcrud.dto;

import com.artyom.springbootcrud.entity.User;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;




public class UserRequest {
    private Long id;
    @NotBlank(message = "Имя не должно иметь пробелов")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Ваше име должно иметь от 2 до 30 символов")
    private String name;
    @NotBlank(message = "Имя не должно иметь пробелов")
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 30, message = "Ваша фамилия должна быть от 2 до 30 символов")
    private String lastName;
    @NotNull(message = "Возраст не должен быть пустым")
    @Min(value = 12, message = "Ваш возраст должен быть от 12 лет")
    @Max(value = 127, message = "Ваш возраст не может превышать 127 лет")
    private Integer age;

    public UserRequest() {
    }

    public UserRequest(Long id, String name, String lastName, Integer age) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public static UserRequest from(User user) {
        return new UserRequest(user.getId(), user.getName(), user.getLastname(), user.getAge().intValue());
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
