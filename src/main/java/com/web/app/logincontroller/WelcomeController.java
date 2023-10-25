package com.web.app.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("n")
public class WelcomeController {

    // private AuthenticationService service;

    // public LoginController(AuthenticationService service) {
    // this.service = service;
    // }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomePage() {
        return "/views/welcome";
    }

    // @RequestMapping(value = "/login", method = RequestMethod.POST)
    // public String welcomePage(@RequestParam String name, @RequestParam String
    // password, ModelMap model) {
    // if (service.isUserNamePasswordValid(name, password)) {
    // model.addAttribute("n", name);
    // return "/views/welcome";
    // }
    // model.addAttribute("errorMessage", "Either the password or userName is
    // incorrect");
    // return "/views/login";
    // }
}
