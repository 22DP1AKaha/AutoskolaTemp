package com.example.Autoskola.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.Autoskola.entity.Exam;
import com.example.Autoskola.repository.ExamRepository;

import java.util.Collections;
import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/autotests")
    public String showExam(Model model) {
        List<Exam> allExams = examRepository.findAll();
        Collections.shuffle(allExams);
        List<Exam> randomQuestions = allExams.subList(0, 4);
        model.addAttribute("questions", randomQuestions);
        return "exam.html";
    }

    @PostMapping("/submit")
    public String submitExam(@RequestParam("answers") List<String> selectedAnswers, Model model) {
        List<Exam> allExams = examRepository.findAll();
        int correctAnswers = 0;

        for (int i = 0; i < selectedAnswers.size(); i++) {
            String selectedAnswer = selectedAnswers.get(i);
            String correctAnswer = allExams.get(i).getCorrectAnswer();

            if (selectedAnswer.equals(correctAnswer)) {
                correctAnswers++;
            }
        }

        model.addAttribute("score", correctAnswers);
        return "exam_result";
    }
}

