package ru.relex.library.services.service;

import ru.relex.library.services.dto.book.ReviewDto;

import javax.validation.Valid;
import java.util.List;

public interface IReviewService {

  List<ReviewDto> findReviews(String search);

  ReviewDto findById(int id);

  ReviewDto create(@Valid ReviewDto reviewDto);

  ReviewDto update(@Valid ReviewDto reviewDto);

  void remove(int reviewId);

}
