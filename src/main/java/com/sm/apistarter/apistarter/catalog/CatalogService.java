package com.sm.apistarter.apistarter.catalog;

import com.sm.apistarter.apistarter.catalog.domain.BookModel;
import com.sm.apistarter.apistarter.catalog.domain.BookRepository;
import com.sm.apistarter.apistarter.catalog.dto.BookDto;
import com.sm.apistarter.apistarter.catalog.dto.BooksDto;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CatalogService {
    private BookRepository bookRepository;

    public CatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BooksDto getAllBooks() {
        BooksDto booksDto = new BooksDto();

        List<BookModel> books = StreamSupport
                .stream(bookRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());

        booksDto.setBooks(books.stream().map(b ->
                new BookDto(b.getId(), b.getTitle(), b.getAuthor(), b.getPrice())).collect(Collectors.toList()));

        return booksDto;
    }

    public void addBook(BookDto bookDto) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookDto.getTitle());
        bookModel.setAuthor(bookDto.getAuthor());
        bookModel.setPrice(bookDto.getPrice());
        bookModel.setCreatedAt(Date.from(Instant.now()));
        bookRepository.save(bookModel);
    }
}
