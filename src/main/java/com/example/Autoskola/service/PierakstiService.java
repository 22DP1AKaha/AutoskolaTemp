package com.example.Autoskola.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Autoskola.entity.Pieraksti;
import com.example.Autoskola.repository.PierakstiRepository;

@Service
public class PierakstiService {
    private final PierakstiRepository pierakstiRepository;

    public PierakstiService(PierakstiRepository pierakstiRepository) {
        this.pierakstiRepository = pierakstiRepository;
    }

    public List<Pieraksti> findAll() {
        return pierakstiRepository.findAll();
    }
}
