package com.omertasci.passvault.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping(value = {"/home"})
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public ModelAndView home(Model model){

        model.addAttribute("entrieslink", "entriesxxxxx");

        return new ModelAndView("home");
    }

}
