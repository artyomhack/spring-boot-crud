package com.artyom.springbootcrud.dto;

import com.artyom.springbootcrud.entity.User;

import java.util.Objects;

public interface UserList extends Iterable<UserList.Item> {
    static UserList of(Iterable<Item> items) {
        return items::iterator;
    }

    record Item(Long id, String name, String lastName, Byte age)  {
        public static Item from(User user) {
            return new Item(user.getId(), user.getName(), user.getLastname(), user.getAge());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Item item = (Item) o;
            return Objects.equals(id, item.id) && Objects.equals(age, item.age) && Objects.equals(name, item.name) && Objects.equals(lastName, item.lastName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, lastName, age);
        }

        @Override
        public String toString() {
            return "Item{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
