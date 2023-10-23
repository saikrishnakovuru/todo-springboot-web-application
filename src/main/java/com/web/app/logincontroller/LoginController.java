package com.web.app.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("n")
public class LoginController {

    private AuthenticationService service;

    public LoginController(AuthenticationService service) {
        this.service = service;
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "/views/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
        if (service.isUserNamePasswordValid(name, password)) {
            model.addAttribute("n", name);
            return "/views/welcome";
        }
        model.addAttribute("errorMessage", "Either the password or userName is incorrect");
        return "/views/login";
    }
}
