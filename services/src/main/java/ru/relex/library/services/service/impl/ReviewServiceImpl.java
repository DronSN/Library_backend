package ru.relex.library.services.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import ru.relex.library.db.mappers.ReviewMapper;
import ru.relex.library.services.dto.book.ReviewDto;
import ru.relex.library.services.mapstruct.ReviewStruct;
import ru.relex.library.services.service.IReviewService;

import javax.validation.Valid;
import java.util.List;

@Service
@Validated
public class ReviewServiceImpl implements IReviewService {

  private final ReviewMapper reviewMapper;
  private final ReviewStruct reviewStruct;

  @Autowired
  public ReviewServiceImpl(ReviewMapper reviewMapper, ReviewStruct reviewStruct) {
    this.reviewMapper = reviewMapper;
    this.reviewStruct = reviewStruct;
  }

  @Override
  public List<ReviewDto> findReviews(final String search) {
    var reviews = reviewMapper.getReviews(search);
    return reviewStruct.toDto(reviews);
  }

  @Override
  public ReviewDto findById(int id) {
    var review = reviewMapper.findById(id);
    return reviewStruct.toDto(review);
  }

  @Override
  public ReviewDto create(@Valid final ReviewDto reviewDto) {
    var review = reviewStruct.fromDto(reviewDto);
    reviewMapper.insert(review);
    return reviewStruct.toDto(review);
  }

  @Override
  public ReviewDto update(@Valid final ReviewDto reviewDto) {
    var review = reviewStruct.fromDto(reviewDto);
    reviewMapper.update(review);
    return reviewStruct.toDto(review);
  }

  @Override
  public void remove(final int reviewId) {
    reviewMapper.delete(reviewId);
  }
}
