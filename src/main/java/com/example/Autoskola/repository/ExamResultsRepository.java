package com.example.Autoskola.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Autoskola.entity.ExamResults;

@Repository
public interface ExamResultsRepository extends JpaRepository<ExamResults, Long> {
    
    @Query("SELECT er FROM ExamResults er WHERE er.ClientUsername = ?1 ORDER BY er.score DESC")
    List<ExamResults> findAllByClientUsernameOrderByScoreDesc(String clientUsername);
    
    @Query("SELECT er FROM ExamResults er WHERE er.ClientUsername = ?1 ORDER BY er.score ASC")
    List<ExamResults> findAllByClientUsernameOrderByScoreAsc(String clientUsername);
    
    @Query("SELECT er FROM ExamResults er WHERE er.ClientUsername = ?1 ORDER BY er.id ASC")
    List<ExamResults> findAllByClientUsernameOrderByIdAsc(String clientUsername);
}
