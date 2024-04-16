// package com.example.Autoskola.service;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// import com.example.Autoskola.entity.Pieraksti;
// import com.example.Autoskola.repository.PierakstiRepository;

// @Component
// public class PierakstiDataInitializer implements CommandLineRunner {

//     private final PierakstiRepository pierakstirepository;

//     public PierakstiDataInitializer(PierakstiRepository pierakstirepository) {
//         this.pierakstirepository = pierakstirepository;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         Pieraksti pieraksti1 = new Pieraksti("2024-04-16 10:00", "Alberts", false);
//         Pieraksti pieraksti2 = new Pieraksti("2024-04-16 11:00", "Kleopatra", true);
        
//         pierakstirepository.save(pieraksti1);
//         pierakstirepository.save(pieraksti2);
//     }
// }