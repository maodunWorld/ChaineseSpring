package com.maodun.ctl;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserCtl {

    @GetMapping("/list/{username}")
    public String getAllUser(@PathVariable String username, Model model){
        model.addAttribute("username", username);
        return "admin-list";
    }

}
