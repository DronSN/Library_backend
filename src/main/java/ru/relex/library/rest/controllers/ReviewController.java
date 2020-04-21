package ru.relex.library.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.relex.library.services.dto.book.ReviewDto;
import ru.relex.library.services.service.IReviewService;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
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
    List<ReviewDto> getReviews(@RequestParam(name = "search", required = false) String search) {
        return reviewService.findReviews(search);
    }

    @GetMapping("/{id}")
    ReviewDto findById(@PathVariable("id") int id) {
        return reviewService.findById(id);
    }

    @PutMapping("/{id}")
    @RolesAllowed("ROLE_USER")
    ReviewDto update(@PathVariable("id") int id, @RequestBody ReviewDto reviewDto) {
        reviewDto.setId(id);
        return reviewService.update(reviewDto);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @RolesAllowed("ROLE_USER")
    ReviewDto create(@RequestBody ReviewDto reviewDto) {
        return reviewService.create(reviewDto);
    }

    @DeleteMapping("/{id}")
    @RolesAllowed("ROLE_USER")
    void delete(@PathVariable("id") int id){
        reviewService.remove(id);
    }
}
