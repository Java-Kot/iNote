package com.codegym.inote.controller;

import com.codegym.inote.model.Note;
import com.codegym.inote.model.Notetype;
import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @Autowired
    private NotetypeService notetypeService;

    @ModelAttribute("notetypes")
    public Iterable<Notetype> notetypes(){
        return notetypeService.findAll();
    }

    @GetMapping("/")
    public ModelAndView showIndex(@RequestParam("search") Optional<String> search, Pageable pageable){
        Page<Note> notes;
        if(search.isPresent()){
            notes = noteService.findAllByTitleContainingOrContentContaining(search.get(), search.get(), pageable);
        } else {
            notes = noteService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", notes);
        return modelAndView;
    }

    @GetMapping("/edit-note/{id}")
    public ModelAndView showEdit(@PathVariable Integer id){
        Note note = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/edit-note")
    public ModelAndView editNote(@ModelAttribute("note") Note note) {
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("note", note);
        modelAndView.addObject("message", "Edit Success !");
        return modelAndView;
    }

    @GetMapping("/add")
    public ModelAndView showAdd(){
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", new Note());
        return modelAndView;
    }

    @PostMapping("/add")
    public ModelAndView addNote(@ModelAttribute("note") Note note){
        noteService.save(note);
        ModelAndView modelAndView = new ModelAndView("add");
        modelAndView.addObject("note", new Note());
        modelAndView.addObject("message", "Add Success !");
        return modelAndView;
    }

    @GetMapping("/del-note/{id}")
    public ModelAndView showDel(@PathVariable Integer id) {
        Note note = noteService.findById(id);
        ModelAndView modelAndView = new ModelAndView("del");
        modelAndView.addObject("note", note);
        return modelAndView;
    }

    @PostMapping("/del-note")
    public String delNote(@ModelAttribute("note") Note note) {
        noteService.remove(note.getId());
        return "redirect:/";
    }
}
