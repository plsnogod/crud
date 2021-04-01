package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UsController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String ShowAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("all_us", allUsers);
        return "all-users";
    }
    @PostMapping("/addNewUser")
    public String addUser( Model model){
        model.addAttribute("user",new User());
        return "user-info";
    }
    @PostMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }
}


