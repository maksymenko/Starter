package com.sm.apistarter.apistarter.catalog;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogService {
    private BooksDto booksDto = new BooksDto();

    public BooksDto getAllBooks() {
        return booksDto;
    }

    public void addBook(BookDto bookDto) {
        List<BookDto> books = booksDto.getBooks();
        books.add(bookDto);
        booksDto.setBooks(books);
    }
}
