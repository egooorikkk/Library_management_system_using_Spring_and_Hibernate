package com.javastart.library.service;

import com.javastart.library.DTO.BookDTO;
import com.javastart.library.entity.Author;
import com.javastart.library.entity.Book;
import com.javastart.library.repository.AuthorRepository;
import com.javastart.library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookService {

    public final BookRepository bookRepository;
    public final AuthorRepository authorRepository;

    public BookDTO createBook(BookDTO dto){
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new RuntimeException("Автор не найден!"));

        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setIsbn(dto.getIsbn());

        book.setAuthor(author);

        Book savedBook = bookRepository.save(book);

        BookDTO response = new BookDTO();
        response.setId(savedBook.getId());
        response.setTitle(savedBook.getTitle());
        response.setIsbn(savedBook.getIsbn());
        response.setAuthorId(savedBook.getAuthor().getId());

        return response;
    }
}
