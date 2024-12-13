package org.launchcode.controllers;

import org.launchcode.Data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (verify.equals(user.getPassword())) {
            UserData.add(user);
            model.addAttribute("username", user.getUsername());
            model.addAttribute("users", UserData.getAll());
            return "user/index";
        }
        model.addAttribute("error", "The password did not match");
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        return "user/add";
    }

    @GetMapping("/add")
    public String displayAddUserForm() {

        return "user/add";
    }

    @GetMapping("/details/{id}")
    public String displayDetails(@PathVariable int id, Model model) {
        model.addAttribute("user", UserData.getById(id));
        return "user/details";
    }

    @PostMapping("/details")
    public String backButton() {
        return "user/index";
    }


}
