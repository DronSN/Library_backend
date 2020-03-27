package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.model.PaperBook;
import ru.relex.library.services.dto.paperbook.PaperBookDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class PaperBookStruct {

  @Autowired
  private BookMapper bookMapper;

  @Autowired
  private BookStruct bookStruct;

  @AfterMapping
  protected void updateBook(PaperBook paperBook, @MappingTarget PaperBookDto paperBookDto) {
      paperBookDto.setBookDto(
              bookStruct.toDto(
                      bookMapper.findById(paperBook.getBooksId())
              )
      );
  }

  public abstract PaperBookDto toDto(PaperBook paperBook);

  public abstract PaperBook fromDto(PaperBookDto paperBookDto);

  public abstract List<PaperBookDto> toDto(List<PaperBook> paperBooks);

  public abstract List<PaperBook> fromDto(List<PaperBookDto> paperBookDtos);

}
