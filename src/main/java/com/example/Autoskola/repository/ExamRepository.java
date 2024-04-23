package com.example.Autoskola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.Autoskola.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
