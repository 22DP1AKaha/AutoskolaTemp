// package com.example.Autoskola.service;

// import com.example.Autoskola.entity.Contact;
// import com.example.Autoskola.repository.ContactRepository;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class DataInitializer implements CommandLineRunner {

//     private final ContactRepository contactRepository;

//     public DataInitializer(ContactRepository contactRepository) {
//         this.contactRepository = contactRepository;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         Contact contact1 = new Contact("Aleksis Kahanovskis", "AK00285@rvt.lv", "+37128782990");
//         Contact contact2 = new Contact("Rinalds Lazdiņš", "Runcitis@rvt.lv", "+987654321");

//         contactRepository.save(contact1);
//         contactRepository.save(contact2);
//     }
// }
