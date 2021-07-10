package com.example.learning.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table( name = "answers")
public class AnswerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "answer_content")
    private String answerContent;

    @Column(name = "is_correct")
    private Boolean isCorrect;

    @Column(name = "is_active")
    private Boolean isActive;

    @ManyToOne
    @JsonIgnore
    private QuestionEntity question;

}
