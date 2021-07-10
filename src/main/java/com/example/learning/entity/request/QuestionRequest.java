package com.example.learning.entity.request;

import com.example.learning.utils.validation.anotation.Required;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class QuestionRequest {
    @Required
    private String questionContent;

    @NotEmpty(message = "Input movie list cannot be empty.")
    @Valid
    private List<AnswerRequest> answers;
}
