package com.weilyu.springframework.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage() {
        return "index"; // this must match the index.html file name under templates folder
    }
}
