package com.example.learning.utils.validation.anotation;


import com.example.learning.utils.validation.validator.RequiredValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {RequiredValidator.class})
public @interface Required {

    String message() default "{valid.validate.required}";

    Class<?>[] groups()default {};

    Class<? extends Payload>[] payload() default {};
}
