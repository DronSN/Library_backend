package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.ReviewDto;
import ru.relex.library.services.service.IReviewService;

import java.util.List;

@RestController
@RequestMapping(
        path = "/api/reviews",
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class ReviewController {

    private final IReviewService reviewService;

    @Autowired
    public ReviewController(IReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    List<ReviewDto> getBooks(@RequestParam(name = "search", required = false) String search) {
        return reviewService.findReviews(search);
    }

    @GetMapping("/{id}")
    ReviewDto findById(@PathVariable("id") int id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    ReviewDto update(@PathVariable("id") int id, @RequestBody ReviewDto reviewDto) {
        reviewDto.setId(id);
        return reviewService.update(reviewDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")
    void delete(@PathVariable("id") int id){
        reviewService.remove(id);
    }
}
