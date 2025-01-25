package com.empire.SpringBootRoleBasedAuthentication.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    private String showAdminForm(){

        return "admin";
    }
}
