package com.empire.SpringBootRoleBasedAuthentication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    String showLoginForm(){

        return "index";
    }
}