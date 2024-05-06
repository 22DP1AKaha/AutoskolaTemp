package com.example.Autoskola.controller;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.entity.Exam;
import com.example.Autoskola.repository.ExamRepository;
import com.example.Autoskola.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ClientRepository clientRepository;

    private final int totalQuestions = 20;
    private int currentQuestionIndex = 0;
    private int score = 0;

    @GetMapping("/autotests")
    public String showExamPage(Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            List<Exam> examQuestions = examRepository.findAll();

            if (examQuestions.size() < totalQuestions) {
                model.addAttribute("error", "Nav pietiekami jautājumu datubāzē.");
                return "error_page";
            }

            if (currentQuestionIndex >= totalQuestions) {
                return "redirect:/testarezultats";
            }

            Exam currentQuestion = examQuestions.get(currentQuestionIndex);
            model.addAttribute("questionNumber", currentQuestionIndex + 1);
            model.addAttribute("question", currentQuestion);
            return "exam";
        }
        return "redirect:/";
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam("selectedAnswer") String selectedAnswer) {
        if (selectedAnswer == null || selectedAnswer.isEmpty()) {
            return "redirect:/autotests?error=izvēlieties atbildi";
        }

        List<Exam> examQuestions = examRepository.findAll();
        Exam currentQuestion = examQuestions.get(currentQuestionIndex);

        String correctAnswer = currentQuestion.getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            score++;
        }

        currentQuestionIndex++;

        return "redirect:/autotests";
    }

    @GetMapping("/testarezultats")
    public String showResultPage(Model model) {
        model.addAttribute("score", score);
        if (score >= 18) {
            model.addAttribute("result", "Congratulations! You passed the exam.");
        } else {
            model.addAttribute("result", "Sorry, you failed the exam.");
        }
        return "exam_result";
    }
}
