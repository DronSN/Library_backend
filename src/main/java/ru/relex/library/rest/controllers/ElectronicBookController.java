package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.ElectronicBookDto;
import ru.relex.library.services.service.IElectronicBookService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/electronicbooks",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ElectronicBookController {

    private final IElectronicBookService electronicBookService;

    @Autowired
    public ElectronicBookController(final IElectronicBookService electronicBookService) {
        this.electronicBookService = electronicBookService;
    }

    @GetMapping
    List<ElectronicBookDto> getElectronicBooks(@RequestParam(name = "search", required = false) String search) {
        return electronicBookService.findBooks(search);
    }

    @GetMapping("/{id}")
    ElectronicBookDto findById(@PathVariable("id") int id) {
        return electronicBookService.findById(id);
    }

    @PutMapping("/{id}")
    ElectronicBookDto update(@PathVariable("id") int id, @RequestBody ElectronicBookDto electronicBook) {
        electronicBook.setId(id);
        return electronicBookService.update(electronicBook);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ElectronicBookDto create(@RequestBody ElectronicBookDto electronicBook) {
        return electronicBookService.create(electronicBook);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        electronicBookService.remove(id);
    }
}