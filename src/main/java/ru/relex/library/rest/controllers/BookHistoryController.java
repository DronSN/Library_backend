package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.booksmoving.BookHistoryDto;
import ru.relex.library.services.service.IBookHistoryService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/bookhistorys",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class BookHistoryController {

    private final IBookHistoryService bookHistoryService;

    @Autowired
    public BookHistoryController(IBookHistoryService bookHistoryService) {
        this.bookHistoryService = bookHistoryService;
    }

    @GetMapping
    List<BookHistoryDto> getWaitLists(@RequestParam(name = "search", required = false) String search) {
        return bookHistoryService.findBookHistorys(search);
    }

    @GetMapping("/{id}")
    BookHistoryDto findById(@PathVariable("id") int id) {
        return bookHistoryService.findById(id);
    }

    @PutMapping("/{id}")
    BookHistoryDto update(@PathVariable("id") int id, @RequestBody BookHistoryDto bookHistoryDto) {
        bookHistoryDto.setId(id);
        return bookHistoryService.update(bookHistoryDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    BookHistoryDto create(@RequestBody BookHistoryDto bookHistoryDto) {
        return bookHistoryService.create(bookHistoryDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        bookHistoryService.remove(id);
    }

}