package ru.relex.library.services.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.BookMapper;
import ru.relex.library.db.model.Book;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BookValidator implements ConstraintValidator<BookPresent, Integer> {

    private final BookMapper bookMapper;

    @Autowired
    public BookValidator(final BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        Book book = bookMapper.findById(value);
        return book != null;
    }
}
