package com.javastart.library.controller;

import com.javastart.library.DTO.BookDTO;
import com.javastart.library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

    @PostMapping
    public BookDTO createBook(@RequestBody BookDTO dto){
        return bookService.createBook(dto);
    }
}
