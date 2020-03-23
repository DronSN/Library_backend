package ru.relex.library.services.mapstruct;

import org.mapstruct.Mapper;
import ru.relex.library.db.model.Book;
import ru.relex.library.services.dto.book.BookDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookStruct {

  BookDto toDto(Book book);

  Book fromDto(BookDto bookDto);

  List<BookDto> toDto(List<Book> books);

  List<Book> fromDto(List<BookDto> bookDtos);
}
