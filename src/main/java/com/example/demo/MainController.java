package com.example.demo;


import com.example.demo.Security.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {

    @Autowired
    UserListRepository userListRepository;

    @Autowired
    RoleListRepository roleListRepository;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model)
    {
        model.addAttribute("newUser",new UserList());
        return "registration";
    }

    @PostMapping("/register")
    public String addNewUser(@Valid @ModelAttribute("NewUser") UserList newUser, BindingResult result, Model model)
    {

        if(result.hasErrors())
        {
            System.out.println(result.toString());
            return "registration";
        }
        else{
            if(newUser.getUsertype() == true){
                model.addAttribute(newUser.getUsername()+" created");
                RoleList r = roleListRepository.findByRole("EMPLOYER");
                userListRepository.save(newUser);
                newUser.addRole(r);
                userListRepository.save(newUser);
                return "redirect:/";
            }else {
                //Create a new ordinary user
                model.addAttribute(newUser.getUsername() + " created");
                RoleList r = roleListRepository.findByRole("APPLICANT");
                userListRepository.save(newUser);
                newUser.addRole(r);
                userListRepository.save(newUser);
                return "redirect:/";
            }
        }
    }


    // Homepage Methods
    @GetMapping("/")
    public String resumeStarter(){
        return "homepage";
    }

}
