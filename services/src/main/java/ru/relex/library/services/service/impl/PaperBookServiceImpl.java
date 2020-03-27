package ru.relex.library.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.PaperBookMapper;
import ru.relex.library.services.dto.paperbook.PaperBookDto;
import ru.relex.library.services.mapstruct.PaperBookStruct;
import ru.relex.library.services.service.IPaperBookService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class PaperBookServiceImpl implements IPaperBookService {

  private final PaperBookMapper paperBookMapper;
  private final PaperBookStruct paperBookStruct;

  @Autowired
  public PaperBookServiceImpl(PaperBookMapper paperBookMapper, PaperBookStruct paperBookStruct) {
    this.paperBookMapper = paperBookMapper;
    this.paperBookStruct = paperBookStruct;
  }

  @Override
  public List<PaperBookDto> findBooks(final String search) {
    var paperBooks = paperBookMapper.getPaperBooks(search);
    return paperBookStruct.toDto(paperBooks);
  }

  @Override
  public PaperBookDto findById(int id) {
    var paperBook = paperBookMapper.findById(id);
    return paperBookStruct.toDto(paperBook);
  }

  @Override
  public PaperBookDto create(@Valid final PaperBookDto paperBookDto) {
    var book = paperBookStruct.fromDto(paperBookDto);
    paperBookMapper.insert(book);
    return paperBookStruct.toDto(book);
  }

  @Override
  public PaperBookDto update(@Valid final PaperBookDto paperBookDto) {
    var paperBook = paperBookStruct.fromDto(paperBookDto);
    paperBookMapper.update(paperBook);
    return paperBookStruct.toDto(paperBook);
  }

  @Override
  public void remove(final int paperBookId) {
    paperBookMapper.delete(paperBookId);
  }
}
