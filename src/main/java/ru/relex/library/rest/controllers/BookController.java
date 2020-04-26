package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.service.IBookService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@RequestMapping(
        path = "/api/books",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BookController {

    private final IBookService bookService;

    @Autowired
    public BookController(final IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookDto> getBooks(@RequestParam(name = "search", required = false) String search) {
        return bookService.findBooks(search);
    }

    @GetMapping("/{id}")
    BookDto findById(@PathVariable("id") int id) {
        return bookService.findById(id);
    }

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    BookDto update(@PathVariable("id") int id, @RequestBody BookDto book) {
        book.setId(id);
        return bookService.update(book);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("ROLE_ADMIN")
    BookDto create(@RequestBody BookDto book) {
        return bookService.create(book);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_ADMIN")
    void delete(@PathVariable("id") int id){
        bookService.remove(id);
    }
}
