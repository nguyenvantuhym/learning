package com.example.learning.utils.validation.validator;

import com.example.learning.utils.validation.anotation.Required;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RequiredValidator implements ConstraintValidator<Required, Object> {

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext){
        if(o instanceof String){
            return ! StringUtils.isEmpty(o.toString().trim());
        }
        return !ObjectUtils.isEmpty(o);
    }
}
