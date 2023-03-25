package com.example.sokolov.spring_boot_crud.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Size(min = 3, max = 30, message = "Minimum 3 characters")
    @NotBlank
    @Column(name = "name")
    private String name;
    @Size(min = 3, max = 30, message = "Minimum 3 characters")
    @NotBlank
    @Column(name = "surname")
    private String surname;

    @Max(value = 180)
    @Min(value = 1, message = "Age begins at 1 year")
    @Column(name = "age")
    private int age;


    public User(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
}
