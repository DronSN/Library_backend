package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.PaperBookDto;
import ru.relex.library.services.service.IPaperBookService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/paperbooks",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class PaperBookController {

    private final IPaperBookService paperBookService;

    @Autowired
    public PaperBookController(final IPaperBookService paperBookService) {
        this.paperBookService = paperBookService;
    }

    @GetMapping
    List<PaperBookDto> getBooks(@RequestParam(name = "search", required = false) String search) {
        return paperBookService.findBooks(search);
    }

    @GetMapping("/{id}")
    PaperBookDto findById(@PathVariable("id") int id) {
        return paperBookService.findById(id);
    }

    @PutMapping("/{id}")
    PaperBookDto update(@PathVariable("id") int id, @RequestBody PaperBookDto paperBook) {
        paperBook.setId(id);
        return paperBookService.update(paperBook);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    PaperBookDto create(@RequestBody PaperBookDto paperBook) {
        return paperBookService.create(paperBook);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        paperBookService.remove(id);
    }
}
