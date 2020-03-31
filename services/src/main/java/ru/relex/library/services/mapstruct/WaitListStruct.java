package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.WaitList;
import ru.relex.library.services.dto.booksmoving.WaitListDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class WaitListStruct {

  @Autowired
  private BookMapper bookMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private BookStruct bookStruct;

  @Autowired
  private UserStruct userStruct;

  @AfterMapping
  protected void updateBook(WaitList waitList, @MappingTarget WaitListDto waitListDto) {
      waitListDto.setBookDto(
              bookStruct.toDto(
                      bookMapper.findById(waitList.getBooksId())));
  }

  @AfterMapping
  protected void updateUser(WaitList waitList, @MappingTarget WaitListDto waitListDto) {
      waitListDto.setUserDto(
              userStruct.toDto(
                      userMapper.findById(waitList.getUserId())));
    }


  public abstract WaitListDto toDto(WaitList waitList);

  public abstract WaitList fromDto(WaitListDto waitListDto);

  public abstract List<WaitListDto> toDto(List<WaitList> waitLists);

  public abstract List<WaitList> fromDto(List<WaitListDto> waitListDtos);

}
