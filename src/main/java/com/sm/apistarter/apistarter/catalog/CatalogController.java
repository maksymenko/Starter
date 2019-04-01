package com.sm.apistarter.apistarter.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CatalogController {
    private CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public BooksDto getAllBooks() {
        return catalogService.getAllBooks();
    }

    @RequestMapping(value = "/books/", method = RequestMethod.POST, consumes="application/json")
    public void addBook(@RequestBody BookDto bookDto) {
        catalogService.addBook(bookDto);
    }
}
