package com.jonathanmakunga.server.web.controller;

import com.jonathanmakunga.server.web.user.UserAlreadyExistException;
import com.jonathanmakunga.server.web.user.UserDao;
import com.jonathanmakunga.server.web.user.UserDto;
import com.jonathanmakunga.server.web.user.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class Interface {
    private Logger log = LoggerFactory.getLogger(Interface.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @RequestMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("userDto", new UserDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signupProcess(@ModelAttribute UserDto userDto, Model model) {
        model.addAttribute("userDto", userDto);
        userService.registerNewUserAccount(userDto);
        log.info("User created");
        return "success";
    }

    @RequestMapping("/chat")
    public String chatHome() {
        return "chat";
    }

    @RequestMapping("/profile")
    @ResponseBody
    public String profile() {
        return "profile.html";
    }
}
