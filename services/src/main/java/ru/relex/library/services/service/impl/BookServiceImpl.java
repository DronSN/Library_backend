package ru.relex.library.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.mapstruct.BookStruct;
import ru.relex.library.services.service.IBookService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class BookServiceImpl implements IBookService {

  private final BookMapper bookMapper;
  private final BookStruct bookStruct;

  @Autowired
  public BookServiceImpl(
          final BookMapper bookMapper,
          final BookStruct bookStruct) {
    this.bookMapper = bookMapper;
    this.bookStruct = bookStruct;
  }

  @Override
  public List<BookDto> findBooks(final String search) {
    var books = bookMapper.getBooks(search);
    return bookStruct.toDto(books);
  }

  @Override
  public BookDto findById(int id) {
    var book = bookMapper.findById(id);
    return bookStruct.toDto(book);
  }

  @Override
  public BookDto create(@Valid final BookDto bookDto) {
    var book = bookStruct.fromDto(bookDto);
    bookMapper.insert(book);
    return bookStruct.toDto(book);
  }

  @Override
  public BookDto update(@Valid final BookDto bookDto) {
    var book = bookStruct.fromDto(bookDto);
    bookMapper.update(book);
    return bookStruct.toDto(book);
  }

  @Override
  public void remove(final int bookId) {
    bookMapper.delete(bookId);
  }
}
