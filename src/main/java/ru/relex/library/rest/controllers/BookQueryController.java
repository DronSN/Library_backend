package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.service.IBookQueryService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(
        path = "/api/query/popbooks",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BookQueryController {

    private final IBookQueryService bookQueryService;

    @Autowired
    public BookQueryController(final IBookQueryService bookQueryService) {
        this.bookQueryService = bookQueryService;
    }

    @GetMapping
    List<BookDto> getPopBooks(@RequestParam(name = "search", required = false) String search) {
        return bookQueryService.findPopBooks();
    }
}
