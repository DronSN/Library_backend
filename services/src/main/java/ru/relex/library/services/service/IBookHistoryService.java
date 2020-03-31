package ru.relex.library.services.service;

import ru.relex.library.services.dto.booksmoving.BookHistoryDto;

import javax.validation.Valid;
import java.util.List;

public interface IBookHistoryService {

  List<BookHistoryDto> findBookHistorys(String search);

  BookHistoryDto findById(int id);

  BookHistoryDto create(@Valid BookHistoryDto bookHistoryDto);

  BookHistoryDto update(@Valid BookHistoryDto bookHistoryDto);

  void remove(int bookHistoryId);

}
