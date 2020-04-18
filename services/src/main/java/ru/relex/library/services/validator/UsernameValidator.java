package ru.relex.library.services.validator;

import org.springframework.beans.factory.annotation.Autowired;
import ru.relex.library.db.mappers.UserMapper;
import ru.relex.library.db.model.User;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<UsernameUnique, String> {

    private final UserMapper userMapper;

    @Autowired
    public UsernameValidator(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {

        User user = userMapper.findByUserName(value);
        return user == null;
    }
}
