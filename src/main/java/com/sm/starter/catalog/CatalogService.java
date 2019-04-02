package com.sm.starter.catalog;

import com.sm.starter.catalog.domain.BookModel;
import com.sm.starter.catalog.domain.BookRepository;
import com.sm.starter.catalog.dto.BookDto;
import com.sm.starter.catalog.dto.BooksDto;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CatalogService {
    private final static Logger LOGGER = LoggerFactory.getLogger(CatalogService.class);
    private BookRepository bookRepository;

    public CatalogService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BooksDto getAllBooks() {
        BooksDto booksDto = new BooksDto();

        List<BookModel> books =
                StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());

        booksDto.setBooks(books.stream().map(b ->
                new BookDto(b.getId(), b.getTitle(), b.getAuthor(), b.getPrice())).collect(Collectors.toList()));


        LOGGER.debug(">> get all books, found {} books", books.size());
        return booksDto;
    }

    public void addBook(BookDto bookDto) {
        BookModel bookModel = new BookModel();
        bookModel.setTitle(bookDto.getTitle());
        bookModel.setAuthor(bookDto.getAuthor());
        bookModel.setPrice(bookDto.getPrice());
        bookModel.setCreatedAt(Date.from(Instant.now()));
        Long id = bookRepository.save(bookModel).getId();

        LOGGER.debug(">> Book Added with id: {}", id);
    }

    public BooksDto findByAuthorAndTitle(String author, String title) {
        BooksDto booksDto = new BooksDto();
        if (StringUtils.isNotBlank(author) && StringUtils.isNotBlank(title)) {
            booksDto.setBooks(convertToDto(bookRepository.findByTitleAndAuthor(title, author)));
        } else if (StringUtils.isNotBlank(author)) {
            booksDto.setBooks(convertToDto(bookRepository.findByAuthor(author)));
        } else if (StringUtils.isNotBlank(title)){
            booksDto.setBooks(convertToDto(bookRepository.findByTitle(title)));
        } else {
            List<BookModel> books =
                    StreamSupport.stream(bookRepository.findAll().spliterator(), false).collect(Collectors.toList());

            booksDto.setBooks(convertToDto(books));
        }

        LOGGER.debug(">> found books, found {} books", booksDto.getBooks().size());
        return booksDto;
    }

    private List<BookDto> convertToDto(List<BookModel> books) {
        return books.stream().map(b ->
                new BookDto(b.getId(), b.getTitle(), b.getAuthor(), b.getPrice())).collect(Collectors.toList());
    }
}
