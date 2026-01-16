package com.javastart.library.DTO;

import lombok.Data;

@Data
public class BookDTO {
    private Long id;
    private String title;
    private String isbn;
    private Long authorId;
}
