package com.example.SpringWebApp.controller;

import com.example.SpringWebApp.entity.User;
import com.example.SpringWebApp.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    final UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("users", userServices.readAllUser());
        return "allUsers";
    }

    @GetMapping("/create")
    public String launchCreateUser(Model model){
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/saveCreatedUser")
    public String createUser(User user){
        userServices.createUser(user);
        return "redirect:/";
    }

    @GetMapping("edit/{id}")
    public String launchEditpage(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userServices.readUserById(id));
        return "editUser";
    }

    @PostMapping("updateUser/{id}")
    public String updateUser(User user){
        userServices.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userServices.deleteUserById(id);
        return "redirect:/";
    }

}
