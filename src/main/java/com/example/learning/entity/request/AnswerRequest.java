package com.example.learning.entity.request;

import com.example.learning.utils.validation.anotation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnswerRequest {
    @Required
    private String answerContent;


    private Boolean isCorrect;

}
