package com.javastart.library.controller;

import com.javastart.library.entity.Author;
import com.javastart.library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping
    public Author create(@RequestBody Author author){
        return authorService.save(author);
    }

    @GetMapping
    public List<Author> getAll(){
        return authorService.findAll();
    }
}
