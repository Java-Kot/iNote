package com.codegym.inote.controller;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.iNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NotetypeController {

    @Autowired
    private iNoteService inoteService;

    @Autowired
    private NotetypeService notetypeService;

    @GetMapping("/notetypes")
    public ModelAndView listTypeNote(){
        Iterable<TypeNote> notetype = notetypeService.findAll();
        ModelAndView modelAndView = new ModelAndView("/notetype/list");
        modelAndView.addObject("notetypes", notetype);
        return modelAndView;
    }

    @GetMapping("/t/edit/{id}")
    public ModelAndView showTypenote(@PathVariable Integer id){
        TypeNote typeNote = notetypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("typenotes", typeNote);
        return modelAndView;
    }

    @PostMapping("/t/edit")
    public ModelAndView editTypenote(@ModelAttribute("notetype") TypeNote typeNote){
        notetypeService.save(typeNote);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("typenotes", typeNote);
        modelAndView.addObject("message", "Edit success");
        return modelAndView;
    }
}
