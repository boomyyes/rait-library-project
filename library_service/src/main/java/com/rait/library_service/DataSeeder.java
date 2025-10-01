package com.rait.library_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() == 0) {
            seedBooks();
        }
    }

    private void seedBooks() {
        Book book1 = new Book();
        book1.setTitle("The Great Gatsby");
        book1.setAuthor("F. Scott Fitzgerald");
        book1.setGenre("Classic");
        book1.setSynopsis("A story of the fabulously wealthy Jay Gatsby and his new love for the beautiful Daisy Buchanan.");
        book1.setPrice(10.99);
        book1.setRating(4.5);
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("To Kill a Mockingbird");
        book2.setAuthor("Harper Lee");
        book2.setGenre("Fiction");
        book2.setSynopsis("The unforgettable novel of a childhood in a sleepy Southern town and the crisis of conscience that rocked it.");
        book2.setPrice(12.50);
        book2.setRating(4.8);
        bookRepository.save(book2);
        
        Book book3 = new Book();
        book3.setTitle("1984");
        book3.setAuthor("George Orwell");
        book3.setGenre("Dystopian");
        book3.setSynopsis("A startling and haunting vision of the world, 1984 is so powerful that it is completely convincing from start to finish.");
        book3.setPrice(9.99);
        book3.setRating(4.7);
        bookRepository.save(book3);
    }
}

