package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.PaperBookMapper;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.BookHistory;
import ru.relex.library.services.dto.booksmoving.BookHistoryDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class BookHistoryStruct {

  @Autowired
  private PaperBookMapper paperBookMapper;

  @Autowired
  private PaperBookStruct paperBookStruct;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private UserStruct userStruct;

  @AfterMapping
  protected void updateBook(BookHistory bookHistory, @MappingTarget BookHistoryDto bookHistoryDto) {
      bookHistoryDto.setPaperBook(
              paperBookStruct.toDto(
                      paperBookMapper.findById(bookHistory.getPaperBookId())
              )
      );
  }

   @AfterMapping
   protected void updateUser(BookHistory bookHistory, @MappingTarget BookHistoryDto bookHistoryDto) {
       bookHistoryDto.setUser(
               userStruct.toDto(
                       userMapper.findById(bookHistory.getUserId())));
   }


  public abstract BookHistoryDto toDto(BookHistory bookHistory);

  public abstract BookHistory fromDto(BookHistoryDto bookHistoryDto);

  public abstract List<BookHistoryDto> toDto(List<BookHistory> bookHistories);

  public abstract List<BookHistory> fromDto(List<BookHistoryDto> bookHistoryDtos);

}
