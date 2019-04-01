package com.sm.apistarter.apistarter.catalog;

import com.sm.apistarter.apistarter.catalog.dto.BookDto;
import com.sm.apistarter.apistarter.catalog.dto.BooksDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CatalogController {
    private CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @CrossOrigin(origins = {"http://localhost:8000", "http://localhost:8001"})
    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public BooksDto getAllBooks() {
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/books/", method = RequestMethod.POST, consumes="application/json")
    public BooksDto addBook(@Valid @RequestBody BookDto bookDto) {
        catalogService.addBook(bookDto);
        return catalogService.getAllBooks();
    }
}
