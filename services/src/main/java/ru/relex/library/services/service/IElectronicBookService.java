package ru.relex.library.services.service;

import ru.relex.library.services.dto.book.ElectronicBookDto;
import ru.relex.library.services.dto.book.ElectronicBookFileDto;

import javax.validation.Valid;
import java.util.List;

public interface IElectronicBookService {

    List<ElectronicBookDto> findBooks(String search);

    ElectronicBookDto findById(int id);

    ElectronicBookDto create(@Valid ElectronicBookDto electronicBooksDto);

    ElectronicBookDto update(@Valid ElectronicBookDto electronicBooksDto);

    void remove(int electronicBookId);

    void uploadFile(@Valid ElectronicBookFileDto fileDto);

    ElectronicBookFileDto getBookForReadingOnline(int id);
}