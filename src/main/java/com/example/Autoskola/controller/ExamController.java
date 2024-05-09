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

import jakarta.servlet.http.HttpSession;

@Controller
public class ExamController {

    @Autowired
    private HttpSession session;

    @Autowired
    private ExamRepository examRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ExamResultsRepository examResultsRepository;

    private final int totalQuestions = 20;
    private int score = 0;

    @SuppressWarnings("unchecked")
    private List<Exam> getShuffledQuestions() {
        return (List<Exam>) session.getAttribute("shuffledQuestions");
    }

    private void setShuffledQuestions(List<Exam> questions) {
        session.setAttribute("shuffledQuestions", questions);
    }

    @GetMapping("/autotests")
    public String showExamPage(Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            List<Exam> shuffledQuestions = getShuffledQuestions();
            if (shuffledQuestions == null || shuffledQuestions.isEmpty()) {
                score = 0;
                List<Exam> examQuestions = examRepository.findAll();
                if (examQuestions.size() < totalQuestions) {
                    model.addAttribute("error", "Nav pietiekami jautājumu datubāzē.");
                    return "error_page";
                }
                shuffleQuestions(examQuestions);
                shuffledQuestions = getShuffledQuestions();
            }
            int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
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
        Collections.shuffle(questions);
        setShuffledQuestions(questions.subList(0, totalQuestions));
        session.setAttribute("currentQuestionIndex", 0);
        session.setAttribute("score", 0);
    }

    @PostMapping("/submit")
    public String submitAnswer(@RequestParam("selectedAnswer") String selectedAnswer, Model model, RedirectAttributes redirectAttributes) {
        if (selectedAnswer == null || selectedAnswer.isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "Izvēlieties atbildi");
            return "redirect:/autotests";
        }

        List<Exam> shuffledQuestions = getShuffledQuestions();
        int currentQuestionIndex = (int) session.getAttribute("currentQuestionIndex");
        Exam currentQuestion = shuffledQuestions.get(currentQuestionIndex);

        String correctAnswer = currentQuestion.getCorrectAnswer();
        if (selectedAnswer.equals(correctAnswer)) {
            score++;
            session.setAttribute("score", score);
        }

        currentQuestionIndex++;
        session.setAttribute("currentQuestionIndex", currentQuestionIndex);

        return "redirect:/autotests";
    }

    @GetMapping("/testarezultats")
    public String showResultPage(Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            Integer score = (Integer) session.getAttribute("score");
            if (score != null) {
                saveResult(score, client.getUsername());
                session.removeAttribute("score");
            }
            model.addAttribute("score", score);
            return "exam_result";
        }
        return "redirect:/";
    }

    @GetMapping("/atkartotTestu")
    public String restartExam() {
        shuffleQuestions(examRepository.findAll());
        return "redirect:/autotests";
    }

    public void saveResult(int score, String clientUsername) {
        ExamResults examResult = new ExamResults(score, clientUsername);
        examResultsRepository.save(examResult);
    }

    @GetMapping("/testaRezultati")
    public String ApskatitRezultatus(@RequestParam(value = "sortBy", defaultValue = "mostPoints") String sortBy, Model model) {
        Client client = clientRepository.findByIsActiveTrue();
        if (client != null) {
            List<ExamResults> examResults;

            switch (sortBy) {
                case "mostPoints":
                    examResults = examResultsRepository.findAllByClientUsernameOrderByScoreDesc(client.getUsername());
                    break;
                case "leastPoints":
                    examResults = examResultsRepository.findAllByClientUsernameOrderByScoreAsc(client.getUsername());
                    break;
                case "date":
                    examResults = examResultsRepository.findAllByClientUsernameOrderByIdAsc(client.getUsername());
                    break;
                default:
                    examResults = examResultsRepository.findAllByClientUsernameOrderByScoreDesc(client.getUsername());
                    break;
            }

            model.addAttribute("examResults", examResults);
            return "ExamResults";
        }
        return "redirect:/";
    }
}
