package com.example.sokolov.spring_boot_crud.controller;

import com.example.sokolov.spring_boot_crud.model.User;
import com.example.sokolov.spring_boot_crud.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String allUsers(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();

        model.addAttribute("edit_user", user);
        return "edit-user";
    }


    @PostMapping("/saveUser")
    public String saveUser(@Valid @ModelAttribute("edit_user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit-user";
        }

        userService.saveAndUpdateUser(user);

        return "redirect:/";
    }

    @PostMapping("/updateInfo")
    public String updateUser(@RequestParam("empId") long id, Model model) {
        model.addAttribute("edit_user", userService.getUserForId(id));
        return "edit-user";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("empId") long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }

}