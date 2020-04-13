package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.booksmoving.WaitListDto;
import ru.relex.library.services.service.IWaitListService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/waitlists",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class WaitListController {

    private final IWaitListService waitListService;

    @Autowired
    public WaitListController(IWaitListService iWaitListService) {
        this.waitListService = iWaitListService;
    }

    @GetMapping
    List<WaitListDto> getWaitLists(@RequestParam(name = "search", required = false) String search) {
        return waitListService.findWaitLists(search);
    }

    @GetMapping("/{id}")
    WaitListDto findById(@PathVariable("id") int id) {
        return waitListService.findById(id);
    }

    @PutMapping("/{id}")
    WaitListDto update(@PathVariable("id") int id, @RequestBody WaitListDto waitListDto) {
        waitListDto.setId(id);
        return waitListService.update(waitListDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    WaitListDto create(@RequestBody WaitListDto waitListDto) {
        return waitListService.create(waitListDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        waitListService.remove(id);
    }

}
