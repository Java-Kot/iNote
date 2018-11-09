package com.codegym.inote.controller;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.model.iNote;
import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.iNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class iNoteController {

    @Autowired
    private iNoteService iNoteService;

    @Autowired
    private NotetypeService notetypeService;

    @ModelAttribute("notetypes")
    public Iterable<TypeNote> typeNotes(){
        return notetypeService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showIndex(Pageable pageable){
        Page<iNote> iNotes;
        iNotes = iNoteService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", iNotes);
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAdd() {
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", new iNote());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addNote(@ModelAttribute("note") iNote inote) {
        iNoteService.save(inote);
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", new iNote());
        modelAndView.addObject("message", "New iNote created successfully");
        return modelAndView;
    }

    @GetMapping("/note/{id}")
    public ModelAndView detailNote(@PathVariable Integer id) {
        iNote inote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("inote", inote);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        iNote inote = iNoteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", inote);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editNote(@ModelAttribute("note") iNote inote){
        iNoteService.save(inote);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", inote);
        modelAndView.addObject("message", "iNote edit successfully");
        return modelAndView;
    }

//    @GetMapping("/del/{id}")
//    public ModelAndView
}
