package ru.relex.library.services.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PaperBookValidator.class)
@Documented
public @interface PaperBookPresent {
    String message() default "Paper Book is not allowed.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
