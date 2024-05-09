package com.example.Autoskola.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Autoskola.entity.Client;
import com.example.Autoskola.entity.Exam;
import com.example.Autoskola.entity.ExamResults;
import com.example.Autoskola.repository.ClientRepository;
import com.example.Autoskola.repository.ExamRepository;
import com.example.Autoskola.repository.ExamResultsRepository;

@Controller
public class ExamController {

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ExamResultsRepository examResultsRepository;

    private final int totalQuestions = 20;
    private int currentQuestionIndex = 0;
    public int score = 0;

    private List<Exam> shuffledQuestions;

    @GetMapping("/autotests")
    public String showExamPage(Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            if (shuffledQuestions == null || shuffledQuestions.isEmpty()) {
                List<Exam> examQuestions = examRepository.findAll();

                if (examQuestions.size() < totalQuestions) {
                    model.addAttribute("error", "Nav pietiekami jautājumu datubāzē.");
                    return "error_page";
                }

                shuffleQuestions(examQuestions);
            }

            if (currentQuestionIndex >= totalQuestions) {
                return "redirect:/testarezultats";
            }

            Exam currentQuestion = shuffledQuestions.get(currentQuestionIndex);
            model.addAttribute("questionNumber", currentQuestionIndex + 1);
            model.addAttribute("question", currentQuestion);
            return "exam";
        }
        return "redirect:/";
    }

    private void shuffleQuestions(List<Exam> questions) {
        shuffledQuestions = questions.subList(0, totalQuestions);
        Collections.shuffle(shuffledQuestions);
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam("selectedAnswer") String selectedAnswer, Model model, RedirectAttributes redirectAttributes) {
        if (selectedAnswer == null || selectedAnswer.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Izvēlieties atbildi"); 
            return "redirect:/autotests";
        }

        Exam currentQuestion = shuffledQuestions.get(currentQuestionIndex);

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
        Client client = clientRepository.findByIsActiveTrue();
        saveResult(score, client.getUsername());
        return "exam_result";
    }

    @GetMapping("/atkartotTestu")
    public String restartExam(){
        currentQuestionIndex = 0;
        score = 0;
        shuffledQuestions = null;
        return "redirect:/autotests";
    }

    public void saveResult(int score, String ClientUsername){
        ExamResults examResult = new ExamResults(score, ClientUsername);
        examResultsRepository.save(examResult);
    }

    @GetMapping("/testaRezultati")
    public String ApskatitRezultatus(Model model) {
        List<ExamResults> examResults =  examResultsRepository.findAll();
        model.addAttribute("examResults", examResults);
        return "ExamResults";
    }
    
}
