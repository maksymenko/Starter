package com.sm.starter.catalog.rest;


import com.sm.starter.catalog.dto.BookDto;
import com.sm.starter.catalog.dto.BooksDto;
import com.sm.starter.catalog.service.CatalogService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import static org.springframework.test.web.servlet.ResultMatcher.matchAll;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(CatalogController.class)
public class CatalogControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(CatalogControllerTest.class);

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CatalogService catalogService;

    @InjectMocks
    private CatalogController catalogController;

    @Test
    public void getAllBook() throws Exception {
        BookDto bookDto = new BookDto(1, "title", "author", 123);

        Mockito.when(catalogService.findByAuthorAndTitle(Mockito.anyString(),
                Mockito.anyString())).thenReturn(new BooksDto(Arrays.asList(bookDto)));

        MvcResult result =
                mockMvc.perform(get("/books/").accept(MediaType.APPLICATION_JSON)).andReturn();
        logger.debug(">>> resp: {}", result.getResponse().getContentAsString());

        mockMvc.perform(get("/books/").accept(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(
                        matchAll(
                            jsonPath("$.books").exists(),
                            jsonPath("$.books").isArray(),
                            jsonPath("$.books[0].title").value("title"),
                            jsonPath("$.books[0].author").value("author")
                        ));


    }

}
