package com.javastart.library.service;

import com.javastart.library.DTO.AuthorDTO;
import com.javastart.library.entity.Author;
import com.javastart.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public Author save(Author author){
        return authorRepository.save(author);
    }

    public List<Author> findAll(){
        return authorRepository.findAll();
    }

    public AuthorDTO createAuthor(Author author){
        Author savedAuthor = authorRepository.save(author);

        AuthorDTO dto = new AuthorDTO();
        dto.setId(savedAuthor.getId());
        dto.setName(savedAuthor.getName());

        return dto;
    }

}
