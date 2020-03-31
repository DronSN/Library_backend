package ru.relex.library.services.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UserValidator implements ConstraintValidator<UserPresent, Integer> {

    private final UserMapper userMapper;

    @Autowired
    public UserValidator(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {

        User user = userMapper.findById(value);
        return user != null;
    }
}
