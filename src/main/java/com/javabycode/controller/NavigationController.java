package com.javabycode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.javabycode.model.MultiFileModel;

@Controller
public class NavigationController {


    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public String success(){
        return "success";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error(){
        return "error";
    }
        

}