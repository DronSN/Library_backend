package ru.relex.library.services.service;

import ru.relex.library.services.dto.book.BookDto;

import javax.validation.Valid;
import java.util.List;

public interface IBookService {

  List<BookDto> findBooks(String search);

  BookDto findById(int id);

  BookDto create(@Valid BookDto booksDto);

  BookDto update(@Valid BookDto booksDto);

  void remove(int bookId);

}
