package com.sm.starter.catalog.rest;

import com.sm.starter.catalog.dto.BookDto;
import com.sm.starter.catalog.dto.BooksDto;
import com.sm.starter.catalog.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class CatalogSecuredController {
    private final static Logger LOGGER = LoggerFactory.getLogger(CatalogSecuredController.class);
    private CatalogService catalogService;

    @Autowired
    public CatalogSecuredController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @RequestMapping(value = "/api/books/", method = RequestMethod.POST, consumes = "application/json")
    public BooksDto addBook(@Valid @RequestBody BookDto bookDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            LOGGER.debug(">>> added by " + authentication.getName());
        }
        catalogService.addBook(bookDto);
        return catalogService.getAllBooks();
    }

    @CrossOrigin(origins = {"http://localhost:8000", "http://localhost:8001"})
    @RequestMapping(value = "/api/books/", method = RequestMethod.GET)
    public BooksDto findBy(@RequestParam(value = "author", defaultValue = "") String author, @RequestParam(value =
            "title", defaultValue = "") String title) {

        return catalogService.findByAuthorAndTitle(author, title);
    }

}
