package ru.relex.library.services.service;

import ru.relex.library.services.dto.book.PaperBookDto;

import javax.validation.Valid;
import java.util.List;

public interface IPaperBookService {

  List<PaperBookDto> findBooks(String search);

  PaperBookDto findById(int id);

  PaperBookDto create(@Valid PaperBookDto paperBooksDto);

  PaperBookDto update(@Valid PaperBookDto paperBooksDto);

  void remove(int paperBookId);

}
