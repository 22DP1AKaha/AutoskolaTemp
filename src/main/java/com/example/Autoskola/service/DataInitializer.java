// package com.example.Autoskola.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.Autoskola.entity.Exam;
// import com.example.Autoskola.repository.ExamRepository;

// import java.util.Arrays;
// import java.util.List;

// @Component
// public class DataInitializer implements CommandLineRunner {

//     @Autowired
//     private ExamRepository examRepository;

//     @Override
//     public void run(String... args) {
//         // Add initial exam questions to the database
//         List<Exam> initialQuestions = Arrays.asList(
//             new Exam("Cik riepas ir automašīnai (normālos apstākļos)?", "2", "3", "5", "4", "4"),
//             new Exam("Kāds ir maksimāli atļautais ātrums pilsētā?", "50 km/h", "45 km/h", "30 km/h", "70 km/h", "50 km/h"),
//             new Exam("Kāds ir maksimāli atļautais ātrums ārpus apdzīvotās vietas (pēc noklusējuma)?", "120 km/h", "90 km/h", "100 km/h", "80 km/h", "90 km/h")
//             // Add more questions here
//         );
//         examRepository.saveAll(initialQuestions);
//     }
// }
