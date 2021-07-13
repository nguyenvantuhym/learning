package com.example.learning.entity.request;

import com.example.learning.utils.validation.anotation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @Required
    private String questionContent;

    @NotEmpty(message = "Input movie list cannot be empty.")
    private List<AnswerRequest> answers;
}
