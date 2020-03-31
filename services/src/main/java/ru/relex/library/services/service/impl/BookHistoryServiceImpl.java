package ru.relex.library.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.BookHistoryMapper;
import ru.relex.library.services.dto.booksmoving.BookHistoryDto;
import ru.relex.library.services.mapstruct.BookHistoryStruct;
import ru.relex.library.services.service.IBookHistoryService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BookHistoryServiceImpl implements IBookHistoryService {

  private final BookHistoryMapper bookHistoryMapper;
  private final BookHistoryStruct bookHistoryStruct;

  @Autowired
  public BookHistoryServiceImpl(BookHistoryMapper bookHistoryMapper, BookHistoryStruct bookHistoryStruct) {
    this.bookHistoryMapper = bookHistoryMapper;
    this.bookHistoryStruct = bookHistoryStruct;
  }

  @Override
  public List<BookHistoryDto> findBookHistorys(final String search) {
    var bookHistory = bookHistoryMapper.getBookHistorys(search);
    return bookHistoryStruct.toDto(bookHistory);
  }

  @Override
  public BookHistoryDto findById(int id) {
    var bookHistory = bookHistoryMapper.findById(id);
    return bookHistoryStruct.toDto(bookHistory);
  }

  @Override
  public BookHistoryDto create(@Valid final BookHistoryDto bookHistoryDto) {
    var bookHistory = bookHistoryStruct.fromDto(bookHistoryDto);
    bookHistoryMapper.insert(bookHistory);
    return bookHistoryStruct.toDto(bookHistory);
  }

  @Override
  public BookHistoryDto update(@Valid final BookHistoryDto bookHistoryDto) {
    var bookHistory = bookHistoryStruct.fromDto(bookHistoryDto);
    bookHistoryMapper.update(bookHistory);
    return bookHistoryStruct.toDto(bookHistory);
  }

  @Override
  public void remove(final int bookHistoryId) {
    bookHistoryMapper.delete(bookHistoryId);
  }
}
