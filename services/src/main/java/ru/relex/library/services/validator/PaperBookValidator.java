package ru.relex.library.services.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.PaperBookMapper;
import ru.relex.library.db.model.PaperBook;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PaperBookValidator implements ConstraintValidator<PaperBookPresent, Integer> {

    private final PaperBookMapper paperBookMapper;

    @Autowired
    public PaperBookValidator(final PaperBookMapper paperBookMapper) {
        this.paperBookMapper = paperBookMapper;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        PaperBook paperBook = paperBookMapper.findById(value);
        return paperBook != null;
    }
}
