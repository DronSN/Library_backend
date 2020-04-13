package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.relex.library.services.dto.book.ElectronicBookDto;
import ru.relex.library.services.dto.book.ElectronicBookFileDto;
import ru.relex.library.services.service.IElectronicBookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/electronicbooks",
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

    @PutMapping(path = "/{id}")
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

    @PutMapping(path = "/{id}/attach", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    void attachFileToBook(@PathVariable("id") int id, @RequestParam(value = "file") MultipartFile file) {
        try {
            byte[] newFile = file.getBytes();
            ElectronicBookFileDto fileDto = new ElectronicBookFileDto(newFile, id);
            electronicBookService.uploadFile(fileDto);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @GetMapping(path = "/{id}/receive")
    HttpServletResponse receiveBook(@PathVariable("id") int id, final HttpServletResponse response){
        ElectronicBookFileDto fileDto = electronicBookService.getBookForReadingOnline(id);
        writeBinary(response, fileDto, id);
        return response;
    }

    private static void writeBinary(final HttpServletResponse response, final ElectronicBookFileDto fileDto, int id){
        response.setHeader("Content-Disposition", "attachment;filename=\"" + id + '"');
        response.setContentType(fileDto.getFileType());
        try {
            response.getOutputStream().write(fileDto.getFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
