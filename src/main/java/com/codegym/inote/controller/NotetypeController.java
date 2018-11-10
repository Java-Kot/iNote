package com.codegym.inote.controller;

import com.codegym.inote.service.NotetypeService;
import com.codegym.inote.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class NotetypeController {

    @Autowired
    private NoteService inoteService;

    @Autowired
    private NotetypeService notetypeService;

}
