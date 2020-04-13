package ru.relex.library.services.service;

import ru.relex.library.services.dto.book.BookDto;

import java.util.List;

public interface IBookQueryService {
    List<BookDto> findPopBooks();
}
