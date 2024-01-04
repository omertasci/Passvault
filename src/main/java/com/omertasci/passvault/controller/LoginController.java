package com.omertasci.passvault.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login(){
        return new ModelAndView("login");
    }

/*    @GetMapping(value = {"/manage-students"})
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public ModelAndView manageStudents(){
        return new ModelAndView("manage-students");
    }*/
    @GetMapping(value = {"/access-denied"})
    public ModelAndView accesDenied(){
        return new ModelAndView("access-denied");
    }
}
