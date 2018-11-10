package com.codegym.inote.controller;

import com.codegym.inote.model.Notetype;
import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.NoteService;
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
    private NoteService inoteService;

    @Autowired
    private NotetypeService notetypeService;

    @GetMapping("/type")
    public ModelAndView showType(){
        ModelAndView modelAndView = new ModelAndView("notetype/list");
        modelAndView.addObject("notetypes", notetypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/type/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        Notetype notetype = notetypeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("notetype", notetype);
        return modelAndView;
    }

    @PostMapping("/type/edit")
    public ModelAndView editType(@ModelAttribute("notetype") Notetype notetype) {
        notetypeService.save(notetype);
        ModelAndView modelAndView = new ModelAndView("/notetype/edit");
        modelAndView.addObject("notetype", notetype);
        modelAndView.addObject("message", "Edit Success !");
        return modelAndView;
    }
}
