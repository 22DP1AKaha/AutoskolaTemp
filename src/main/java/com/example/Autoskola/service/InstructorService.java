package com.example.Autoskola.service;
import com.example.Autoskola.entity.Instructor;
import com.example.Autoskola.repository.InstructorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstructorService {
    private final InstructorRepository instructorRepository;

    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public List<Instructor> findAll() {
        return instructorRepository.findAll();
    }
}
