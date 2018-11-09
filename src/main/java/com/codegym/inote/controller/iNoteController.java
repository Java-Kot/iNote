package com.codegym.inote.controller;

import com.codegym.inote.model.iNote;
import com.codegym.inote.service.iNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class iNoteController {

    @Autowired
    private iNoteService iNoteService;
    @GetMapping("/")
    public ModelAndView showIndex(Pageable pageable){
        Page<iNote> iNotes;
        iNotes = iNoteService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("notes", iNotes);
        return modelAndView;
    }
}
