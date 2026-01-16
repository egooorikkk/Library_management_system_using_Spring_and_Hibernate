package com.javastart.library.service;

import com.javastart.library.DTO.AuthorDTO;
import com.javastart.library.entity.Author;
import com.javastart.library.repository.AuthorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorDTO save(AuthorDTO dto){
        Author author = new Author();
        author.setName(dto.getName());

        Author savedAuthor = authorRepository.save(author);

        AuthorDTO responseDto = new AuthorDTO();
        responseDto.setId(savedAuthor.getId());
        responseDto.setName(savedAuthor.getName());

        return responseDto;
    }

    public List<AuthorDTO> findAll(){
        List<Author> authors = authorRepository.findAll();

        List<AuthorDTO> dtos = new ArrayList<>();

        for (Author author : authors){
            AuthorDTO dto = new AuthorDTO();
            dto.setId(author.getId());
            dto.setName(author.getName());

            dtos.add(dto);
        }
        return dtos;
    }

}
