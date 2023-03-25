package com.example.sokolov.spring_boot_crud.service;

import com.example.sokolov.spring_boot_crud.dao.DaoRepository;
import com.example.sokolov.spring_boot_crud.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private DaoRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void saveAndUpdateUser(User user) {
        userRepository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public User getUserForId(long id) {
        User user = null;
        Optional<User> byId = userRepository.findById(id);
        if (byId.isPresent()) {
            user = byId.get();
        }
        return user;
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
