package com.example.learning.utils.validation;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Locale;

@Component
public class MessageSourceUtils {
    @Resource
    private MessageSource messageSource;

    protected String getMessage(String key, Object[] object, Locale locale){
        return messageSource.getMessage(key, object, locale);
    }
}
