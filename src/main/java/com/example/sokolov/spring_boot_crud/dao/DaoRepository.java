package com.example.sokolov.spring_boot_crud.dao;


import com.example.sokolov.spring_boot_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DaoRepository extends JpaRepository<User, Long> {
}
