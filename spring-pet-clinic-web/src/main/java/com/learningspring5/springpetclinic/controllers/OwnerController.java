package com.learningspring5.springpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({"/","/index","/index.html"})
    public String getOwners(){
        return "owners/index";
    }
}
