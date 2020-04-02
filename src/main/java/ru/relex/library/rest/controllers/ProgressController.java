package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.user.ProgressDto;
import ru.relex.library.services.service.IProgressService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/progress",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ProgressController {

    private final IProgressService progressService;

    @Autowired
    public ProgressController(IProgressService progressService) {
        this.progressService = progressService;
    }

    @GetMapping
    List<ProgressDto> getProgress(@RequestParam(name = "search", required = false) String search) {
        return progressService.findProgress(search);
    }

    @GetMapping("/{id}")
    ProgressDto findById(@PathVariable("id") int id) {
        return progressService.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ProgressDto create(@RequestBody ProgressDto progressDto) {
        return progressService.create(progressDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        progressService.remove(id);
    }
}
