package ru.relex.library.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.relex.library.db.mappers.BookQueryMapper;
import ru.relex.library.services.dto.book.BookDto;
import ru.relex.library.services.mapstruct.BookStruct;
import ru.relex.library.services.service.IBookQueryService;

import java.util.List;

@Service
public class BookQueryServiceImpl implements IBookQueryService {
    private final BookQueryMapper bookQueryMapper;
    private final BookStruct bookStruct;

    @Autowired
    public BookQueryServiceImpl(BookQueryMapper bookQueryMapper, BookStruct bookStruct) {
        this.bookQueryMapper = bookQueryMapper;
        this.bookStruct = bookStruct;
    }

    @Override
    public List<BookDto> findPopBooks() {
        var books = bookQueryMapper.getPopBooks();
        return bookStruct.toDto(books);
    }
}
