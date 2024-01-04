package com.omertasci.passvault.controller;

import com.omertasci.passvault.dto.EntryDto;
import com.omertasci.passvault.service.EntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EntryController {

    @Autowired
    EntryService entryService;

    @GetMapping(value = {"/entries"})
    public ModelAndView entryList(Model model){

        model.addAttribute("entries", entryService.findAll());
        return new ModelAndView("entrylist");
    }

    @GetMapping(value = {"/entry/{id}"})
    @ResponseBody
    public EntryDto getEntry(@PathVariable Long id ){
        return entryService.getById(id);
    }
    @PostMapping(value = {"/entry"})
    @ResponseBody
    public EntryDto saveEntry(@RequestBody EntryDto entry ){
        return entryService.saveEntry(entry);
    }

}
