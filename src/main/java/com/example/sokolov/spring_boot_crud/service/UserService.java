package com.example.sokolov.spring_boot_crud.service;



import com.example.sokolov.spring_boot_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveAndUpdateUser(User user);

    User getUserForId(long id);


    void deleteUser(long id);
}

