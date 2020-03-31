package ru.relex.library.services.mapstruct;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.Review;
import ru.relex.library.services.dto.book.ReviewDto;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class ReviewStruct {

  @Autowired
  private BookMapper bookMapper;

  @Autowired
  private UserMapper userMapper;

  @Autowired
  private BookStruct bookStruct;

  @Autowired
  private UserStruct userStruct;

  @AfterMapping
  protected void updateBook(Review review, @MappingTarget ReviewDto reviewDto) {
      reviewDto.setBookDto(
              bookStruct.toDto(
                      bookMapper.findById(review.getBooksId())));
  }

  @AfterMapping
  protected void updateUser(Review review, @MappingTarget ReviewDto reviewDto) {
      reviewDto.setUserDto(
              userStruct.toDto(
                      userMapper.findById(review.getUserId())));
    }


  public abstract ReviewDto toDto(Review review);

  public abstract Review fromDto(ReviewDto reviewDto);

  public abstract List<ReviewDto> toDto(List<Review> reviews);

  public abstract List<Review> fromDto(List<ReviewDto> reviewDtos);

}
