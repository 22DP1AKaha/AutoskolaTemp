package com.example.Autoskola.controller;

import com.example.Autoskola.entity.Exam;
import com.example.Autoskola.repository.ExamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @GetMapping("/autotests")
    public String startExam() {
        return "redirect:/question?questionIndex=0&score=0";
    }

    @GetMapping("/question")
    public String showQuestion(@RequestParam("questionIndex") int questionIndex, @RequestParam("score") int score, Model model) {
        List<Exam> allExams = examRepository.findAll();
        Collections.shuffle(allExams);

        if (questionIndex >= 20) {
            return "redirect:/exam_result?score=" + score;
        }

        Exam currentExam = allExams.get(questionIndex);
        model.addAttribute("question", currentExam);
        model.addAttribute("questionNumber", questionIndex + 1);
        model.addAttribute("totalQuestions", 7);
        model.addAttribute("score", score);
        return "exam";
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam("questionIndex") int questionIndex,
                               @RequestParam("selectedAnswer") String selectedAnswer,
                               @RequestParam("score") int score) {
        List<Exam> allExams = examRepository.findAll();
        Exam currentExam = allExams.get(questionIndex);

        if (selectedAnswer.equals(currentExam.getCorrectAnswer())) {
            score++;
        }

        questionIndex++;
        return "redirect:/question?questionIndex=" + questionIndex + "&score=" + score;
    }

    @GetMapping("/exam_result")
    public String showExamResult(@RequestParam("score") int score, Model model) {
        model.addAttribute("score", score);
        return "exam_result";
    }
}
