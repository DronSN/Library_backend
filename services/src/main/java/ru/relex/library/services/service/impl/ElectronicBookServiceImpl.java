package ru.relex.library.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.ElectronicBookMapper;
import ru.relex.library.db.model.ElectronicBookFile;
import ru.relex.library.services.dto.book.ElectronicBookDto;
import ru.relex.library.services.dto.book.ElectronicBookFileDto;
import ru.relex.library.services.mapstruct.ElectronicBookStruct;
import ru.relex.library.services.service.IElectronicBookService;

import javax.validation.Valid;
import java.util.List;


@Service
@Validated
public class ElectronicBookServiceImpl implements IElectronicBookService {
    private final ElectronicBookMapper electronicBookMapper;
    private final ElectronicBookStruct electronicBookStruct;

    @Autowired
    public ElectronicBookServiceImpl(ElectronicBookMapper electronicBookMapper, ElectronicBookStruct electronicBookStruct) {
        this.electronicBookMapper = electronicBookMapper;
        this.electronicBookStruct = electronicBookStruct;
    }

    @Override
    public List<ElectronicBookDto> findBooks(final String search) {
        var electronicBooks = electronicBookMapper.getElectronicBooks(search);
        return electronicBookStruct.toDto(electronicBooks);
    }

    @Override
    public ElectronicBookDto findById(int id) {
        var electronicBook = electronicBookMapper.findById(id);
        return electronicBookStruct.toDto(electronicBook);
    }

    @Override
    public ElectronicBookDto create(@Valid final ElectronicBookDto electronicBookDto) {
        var book = electronicBookStruct.fromDto(electronicBookDto);
        electronicBookMapper.insert(book);
        return electronicBookStruct.toDto(book);
    }

    @Override
    public ElectronicBookDto update(@Valid final ElectronicBookDto electronicBookDto) {
        var electronicBook = electronicBookStruct.fromDto(electronicBookDto);
        electronicBookMapper.update(electronicBook);
        return electronicBookStruct.toDto(electronicBook);
    }

    @Override
    public void remove(final int electronicBookId) {
        electronicBookMapper.delete(electronicBookId);
    }

    @Override
    public void uploadFile(@Valid final ElectronicBookFileDto fileDto){
        var file = electronicBookStruct.fromDto(fileDto);
        electronicBookMapper.uploadBinaryFile(file);
    }

    @Override
    public ElectronicBookFileDto getBookForReadingOnline(int id) {
        ElectronicBookFile file = electronicBookMapper.getBookForReadingOnline(id);
        return electronicBookStruct.toDto(file);
    }
}
