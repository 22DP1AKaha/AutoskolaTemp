// package com.example.Autoskola.service;

// import com.example.Autoskola.entity.Contact;
// import com.example.Autoskola.entity.Instructor;
// import com.example.Autoskola.repository.ContactRepository;
// import com.example.Autoskola.repository.InstructorRepository;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.stereotype.Component;

// @Component
// public class DataInitializer implements CommandLineRunner {

//     private final ContactRepository contactRepository;
//     private final InstructorRepository instructorRepository;

//     public DataInitializer(ContactRepository contactRepository, InstructorRepository instructorRepository) {
//         this.contactRepository = contactRepository;
//         this.instructorRepository = instructorRepository;
//     }

//     @Override
//     public void run(String... args) throws Exception {
//         Contact contact1 = new Contact("Alberts", "BiskapsAlbis@inbox.lv", "+37128787301");
//         Contact contact2 = new Contact("Kleopatra", "BaddieKleo@yahoo.com", "+987654322");
//         Contact contact3 = new Contact("Rūdolfs", "SantasPaligs@gmail.com", "+127411322");
        
//         contactRepository.save(contact1);
//         contactRepository.save(contact2);
//         contactRepository.save(contact3);

//         // Instructor instructor1 = new Instructor("Jānis", 45, "https://i.etsystatic.com/43307617/r/il/11a9e0/5140114168/il_fullxfull.5140114168_k7vp.jpg", "15$");
//         // Instructor instructor2 = new Instructor("Marija", 37, "https://mir-s3-cdn-cf.behance.net/project_modules/max_1200/1febe5117097689.606f189a91584.jpg", "20$");
//         // Instructor instructor3 = new Instructor("Arča", 37, "https://www.splendidbeast.com/wp-content/uploads/2020/12/cat-painting-01.jpg", "20$");
//         // Instructor instructor4 = new Instructor("Jāzeps", 37, "https://artyourcat.com/cdn/shop/files/Cat_Portrait_-_Customer_Review_-_V.S._1024x1024.jpg?v=1710997076", "20$");
//         // instructorRepository.save(instructor1);
//         // instructorRepository.save(instructor2);
//         // instructorRepository.save(instructor3);
//         // instructorRepository.save(instructor4);
//     }
// }
