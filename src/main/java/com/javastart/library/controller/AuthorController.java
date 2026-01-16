package com.javastart.library.controller;

import com.javastart.library.DTO.AuthorDTO;
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
    public AuthorDTO create(@RequestBody AuthorDTO dto){
        return authorService.save(dto);
    }

    @GetMapping
    public List<AuthorDTO> getAll(){
        return authorService.findAll();
    }
}
