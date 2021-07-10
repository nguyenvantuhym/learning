package com.example.learning.controller;

import com.example.learning.entity.request.AnswerRequest;
import com.example.learning.entity.request.QuestionRequest;
import com.example.learning.model.AnswerEntity;
import com.example.learning.model.QuestionEntity;
import com.example.learning.repository.QuestionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping()
    public ResponseEntity<Object> createQuestion(@Valid @RequestBody QuestionRequest questionRequest) {
        QuestionEntity questionEntity = new QuestionEntity();

        BeanUtils.copyProperties(questionRequest,questionEntity);
        List<AnswerEntity> answerRequestList = questionRequest.getAnswers().stream().map(answer ->{
            AnswerEntity answerEntity = new AnswerEntity();
            BeanUtils.copyProperties(answer,answerEntity);
            return answerEntity;
        }).collect(Collectors.toList());
        questionEntity.setAnswers(answerRequestList);
        questionRepository.save(questionEntity);
        return new ResponseEntity<>(questionEntity, HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Object> searchQuestion(){
        Page<QuestionEntity> pageQuestion = questionRepository.findPageable(
                PageRequest.of(1, 5, Sort.by("question_content").ascending())
        );
        return new ResponseEntity<>(pageQuestion,HttpStatus.ACCEPTED);
    }

    @GetMapping("/searchAll")
    public ResponseEntity<Object> searchQuestionAll(){
        List<QuestionEntity> pageQuestion = questionRepository.findAll();
        return new ResponseEntity<>(pageQuestion,HttpStatus.ACCEPTED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> getQuestionById(@PathVariable("id") Long id){
        Optional<QuestionEntity> questionEntity = questionRepository.findById(id);
        return new ResponseEntity<>(questionEntity.get(),HttpStatus.ACCEPTED);
    }

}
