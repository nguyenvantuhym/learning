package com.example.learning.repository;

import com.example.learning.model.QuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {

    @Query(value = "select * from questions order by rand() ", nativeQuery = true)
    Page<QuestionEntity> findAllPagable(Pageable pageable);
}
