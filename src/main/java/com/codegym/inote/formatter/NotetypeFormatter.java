package com.codegym.inote.formatter;

import com.codegym.inote.model.TypeNote;
import com.codegym.inote.service.NotetypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class NotetypeFormatter implements Formatter<TypeNote> {

    private NotetypeService notetypeService;

    @Autowired
    public NotetypeFormatter(NotetypeService notetypeService){
        this.notetypeService = notetypeService;
    }

    public NotetypeFormatter() {

    }

    @Override
    public TypeNote parse(String text, Locale locale) throws ParseException {
        return notetypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(TypeNote object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}
