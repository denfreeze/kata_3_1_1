package ru.javamentor.__1_1_SpringBoot_mvc_crud.service;


import ru.javamentor.__1_1_SpringBoot_mvc_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    void saveUser(User user);

    User getOne(long id);

    void updateUser(Long id, User user);

    void deleteUser(Long id);
}
