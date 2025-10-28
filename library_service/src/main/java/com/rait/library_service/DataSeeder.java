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
        
        Book book;
        
        book = new Book();
        book.setAuthor("Sachin Malhotra and Saurabh Chaudhary");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(24.99);
        book.setRating(4.6);
        book.setSynopsis("A book on programming in Java.");
        book.setTitle("Programming in Java");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("A. Silberschatz, H. F. Korth, and S. Sudarshan");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(35.0);
        book.setRating(4.8);
        book.setSynopsis("A book on database system concepts.");
        book.setTitle("Database System Concepts");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("M. L. Gillenson, et al.");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(32.5);
        book.setRating(4.6);
        book.setSynopsis("A project manual for database management.");
        book.setTitle("Introduction to Database Management - Project Manual");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("P. S. Deshpande");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(28.99);
        book.setRating(4.5);
        book.setSynopsis("A book on SQL and PL/SQL for Oracle 10g.");
        book.setTitle("SQL and PL/SQL for Oracle 10g Black Book");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("G. K. Gupta");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(25.0);
        book.setRating(4.4);
        book.setSynopsis("A book on database management systems.");
        book.setTitle("Database Management Systems");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("B. R. Desai");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(20.0);
        book.setRating(4.2);
        book.setSynopsis("A book on database management systems.");
        book.setTitle("Database Management Systems");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Bernad Kolman, et al.");
        book.setAvailable(true);
        book.setGenre("Mathematics");
        book.setPrice(45.0);
        book.setRating(4.7);
        book.setSynopsis("A book on discrete mathematical structures.");
        book.setTitle("Discrete Mathematical Structures");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("K.H. Rosen");
        book.setAvailable(true);
        book.setGenre("Mathematics");
        book.setPrice(49.99);
        book.setRating(4.9);
        book.setSynopsis("A book on discrete mathematics and its applications.");
        book.setTitle("Discrete Mathematics and applications");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("C.L. Liu");
        book.setAvailable(true);
        book.setGenre("Mathematics");
        book.setPrice(40.0);
        book.setRating(4.6);
        book.setSynopsis("A book on the elements of discrete mathematics.");
        book.setTitle("Elements of Discrete Mathematics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("J. P. Tremblay & R. Manohar");
        book.setAvailable(true);
        book.setGenre("Mathematics");
        book.setPrice(42.5);
        book.setRating(4.5);
        book.setSynopsis("A book on discrete mathematical structures with applications to computer science.");
        book.setTitle("Discrete Mathematical Structures with Application to Computer Science");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Seymour Lipschutz, Marc Lars Lipson");
        book.setAvailable(true);
        book.setGenre("Mathematics");
        book.setPrice(38.99);
        book.setRating(4.4);
        book.setSynopsis("An outline of discrete mathematics.");
        book.setTitle("Discrete Mathematics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("M. Morris Mano");
        book.setAvailable(true);
        book.setGenre("Digital Design");
        book.setPrice(55.0);
        book.setRating(4.8);
        book.setSynopsis("An introduction to digital design with Verilog HDL, VHDL, and System Verilog.");
        book.setTitle("Digital Design: With an Introduction to the Verilog HDL, VHDL, and System Verilog");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Thomas L. Floyd");
        book.setAvailable(true);
        book.setGenre("Digital Design");
        book.setPrice(52.0);
        book.setRating(4.7);
        book.setSynopsis("A book on digital fundamentals.");
        book.setTitle("Digital Fundamentals");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mazidi M.A");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(60.0);
        book.setRating(4.9);
        book.setSynopsis("A book on the 8051 microcontroller and embedded systems.");
        book.setTitle("The 8051 Microcontroller and Embedded systems");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Kenneth Ayala");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(58.0);
        book.setRating(4.8);
        book.setSynopsis("A book on the 8051 microcontroller.");
        book.setTitle("The 8051 Microcontroller");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Rajkamal");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(65.0);
        book.setRating(4.9);
        book.setSynopsis("A book on the architecture, programming, and design of embedded systems.");
        book.setTitle("Embedded Systems: Architecture, Programming and Design");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dreamtech Press");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(18.99);
        book.setRating(4.3);
        book.setSynopsis("A comprehensive book on JAVA Programming.");
        book.setTitle("JAVA Programming");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Steve Heath");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(62.0);
        book.setRating(4.7);
        book.setSynopsis("A book on embedded systems design.");
        book.setTitle("Embedded Systems Design");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("David Simon");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(55.0);
        book.setRating(4.6);
        book.setSynopsis("A primer on embedded software.");
        book.setTitle("Embedded Software Primer");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Staredu Solutions");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(15.99);
        book.setRating(4.2);
        book.setSynopsis("A book to master Java programming.");
        book.setTitle("Learn to Master Java programming");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("R. Elmasri, Navathe");
        book.setAvailable(true);
        book.setGenre("Databases");
        book.setPrice(39.99);
        book.setRating(4.9);
        book.setSynopsis("A book on the fundamentals of database systems.");
        book.setTitle("Fundamentals of Database Systems");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("ARM");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(70.0);
        book.setRating(4.9);
        book.setSynopsis("A generic user guide for Cortex-M4 devices.");
        book.setTitle("Cortex-M4 Devices Generic User Guide");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Jonathan W. Valvano");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(75.0);
        book.setRating(4.9);
        book.setSynopsis("A book on real-time interfacing to ARM Cortex-M microcontrollers.");
        book.setTitle("Embedded System: Real-Time Interfacing to ARM Cortex-M Microcontrollers");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Andrew N SLOSS, Dominic SYMES, Chris WRIGHT");
        book.setAvailable(true);
        book.setGenre("Embedded Systems");
        book.setPrice(80.0);
        book.setRating(4.9);
        book.setSynopsis("A guide for ARM system developers.");
        book.setTitle("ARM System Developers guide");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Garry Dessler & Varkkey");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(40.0);
        book.setRating(4.5);
        book.setSynopsis("A book on human resource management.");
        book.setTitle("Human Resource Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Alan Price");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(38.0);
        book.setRating(4.4);
        book.setSynopsis("A book on human resource management.");
        book.setTitle("Human Resource Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Pravin Durai");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(35.0);
        book.setRating(4.3);
        book.setSynopsis("A book on human resource management.");
        book.setTitle("Human Resource Mangement");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Snell, Bohlander & Vohra");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(42.0);
        book.setRating(4.6);
        book.setSynopsis("A book on human resources management.");
        book.setTitle("Human Resources Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Venkata Ratnam C. S. & Srivatsava B. K.");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(39.0);
        book.setRating(4.5);
        book.setSynopsis("A book on personnel management and human resources.");
        book.setTitle("Personnel Management And Human Resources");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Aswathappa");
        book.setAvailable(true);
        book.setGenre("Management");
        book.setPrice(36.0);
        book.setRating(4.4);
        book.setSynopsis("A book on human resource management.");
        book.setTitle("Human Resource Mangement");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Chris Bailey");
        book.setAvailable(true);
        book.setGenre("Technology");
        book.setPrice(25.0);
        book.setRating(4.2);
        book.setSynopsis("A book on digital education and learning.");
        book.setTitle("Digital Education and Learning");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Brooke B. Eisenbach, Paula Greathouse");
        book.setAvailable(true);
        book.setGenre("Technology");
        book.setPrice(28.0);
        book.setRating(4.3);
        book.setSynopsis("Resources for effective middle level virtual education.");
        book.setTitle("The Online Classroom: Resources for Effective Middle Level Virtual Education");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mihaly Csikszentmihalyi");
        book.setAvailable(true);
        book.setGenre("Psychology");
        book.setPrice(30.0);
        book.setRating(4.7);
        book.setSynopsis("A book on the psychology of discovery and invention.");
        book.setTitle("Creativity: The Psychology of Discovery and Invention");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Herbert Schildt");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(19.99);
        book.setRating(4.5);
        book.setSynopsis("A comprehensive guide to Java programming.");
        book.setTitle("JAVA: The Complete Reference");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Ivor Horton");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(22.5);
        book.setRating(4.4);
        book.setSynopsis("A beginner's guide to Java.");
        book.setTitle("Beginning JAVA");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Deitel and Deitel");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(29.99);
        book.setRating(4.7);
        book.setSynopsis("A guide on how to program in Java.");
        book.setTitle("Java: How to Program");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Pradip N Khandwalla");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(32.0);
        book.setRating(4.6);
        book.setSynopsis("A book on lifelong creativity.");
        book.setTitle("Lifelong Creativity, An Unending Quest");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Vinnie Jauhari, Sudanshu Bhushan");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(34.0);
        book.setRating(4.5);
        book.setSynopsis("A book on innovation management.");
        book.setTitle("Innovation Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("A.DaleTimpe");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(29.0);
        book.setRating(4.4);
        book.setSynopsis("A book on creativity.");
        book.setTitle("Creativity");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Brian Clegg, Paul Birch");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(28.0);
        book.setRating(4.3);
        book.setSynopsis("A book on creativity.");
        book.setTitle("Creativity");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Austin Kleon");
        book.setAvailable(true);
        book.setGenre("Art");
        book.setPrice(15.0);
        book.setRating(4.8);
        book.setSynopsis("10 things nobody told you about being creative.");
        book.setTitle("Steal Like an Artist: 10 Things Nobody Told You About Being Creative");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("P. N. Rastogi");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(33.0);
        book.setRating(4.5);
        book.setSynopsis("A book on managing creativity for corporate excellence.");
        book.setTitle("Managing Creativity for Corporate Excellence");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("C. S. G. Krishnamacharyulu, R. Lalitha");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(31.0);
        book.setRating(4.4);
        book.setSynopsis("A book on innovation management.");
        book.setTitle("Innovation Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Clayton M. Christensen");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(36.0);
        book.setRating(4.8);
        book.setSynopsis("A book on when new technologies cause great firms to fail.");
        book.setTitle("The Innovator's Dilemma: When New Technologies Cause Great Firms to Fail");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("L. Hatfield");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(18.0);
        book.setRating(4.1);
        book.setSynopsis("A book on the basics of accounting.");
        book.setTitle("Accounting Basics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("C. T. Horngren, et al.");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(22.0);
        book.setRating(4.3);
        book.setSynopsis("An introduction to financial accounting.");
        book.setTitle("Introduction to Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("S. A. Siddiqui");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(20.0);
        book.setRating(4.2);
        book.setSynopsis("A book on book keeping and accountancy.");
        book.setTitle("Book Keeping & Accountancy");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("D. Sehgal");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(24.0);
        book.setRating(4.4);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("P. C. Tulsian");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(26.0);
        book.setRating(4.5);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("A. Mukharji, & M. Hanif");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(25.0);
        book.setRating(4.4);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("S. N. Maheshwari, et al.");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(28.0);
        book.setRating(4.6);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("S. Mukherjee, & A. K. Mukherjee");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(27.0);
        book.setRating(4.5);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("S. P. Jain, & K. L. Narang");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(23.0);
        book.setRating(4.3);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("R. L. Gupta, & M. Radhaswamy");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(21.0);
        book.setRating(4.2);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("J. Lal, & S. Srivastava");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(19.0);
        book.setRating(4.1);
        book.setSynopsis("A book of financial accounting text and problems.");
        book.setTitle("Financial Accounting Text & Problems");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("J. R. Monga");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(29.0);
        book.setRating(4.7);
        book.setSynopsis("A book on financial accounting concepts and applications.");
        book.setTitle("Financial Accounting: Concepts and Applications");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("B. K. Goyal, & H. N. Tiwari");
        book.setAvailable(true);
        book.setGenre("Accounting");
        book.setPrice(30.0);
        book.setRating(4.8);
        book.setSynopsis("A book on financial accounting.");
        book.setTitle("Financial Accounting");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Asha Kaul");
        book.setAvailable(true);
        book.setGenre("Communication");
        book.setPrice(35.0);
        book.setRating(4.6);
        book.setSynopsis("A book on effective business communication.");
        book.setTitle("Effective Business Communication");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Sanjay Kumar PushpLata");
        book.setAvailable(true);
        book.setGenre("Communication");
        book.setPrice(32.0);
        book.setRating(4.5);
        book.setSynopsis("A book on communication skills.");
        book.setTitle("Communication Skills: Second Edition");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Rizvi Ashraf");
        book.setAvailable(true);
        book.setGenre("Communication");
        book.setPrice(38.0);
        book.setRating(4.7);
        book.setSynopsis("A book on effective technical communication.");
        book.setTitle("Effective Technical Communication");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Jeff Butterfield");
        book.setAvailable(true);
        book.setGenre("Self-Help");
        book.setPrice(25.0);
        book.setRating(4.4);
        book.setSynopsis("A book on soft skills for everyone.");
        book.setTitle("Soft Skills for Everyone");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Chaturvedi and Chaturvedi");
        book.setAvailable(true);
        book.setGenre("Communication");
        book.setPrice(33.0);
        book.setRating(4.5);
        book.setSynopsis("A book on business communication.");
        book.setTitle("Business Communication");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Masters Wallace");
        book.setAvailable(true);
        book.setGenre("Self-Help");
        book.setPrice(28.0);
        book.setRating(4.3);
        book.setSynopsis("A book on personal development for life and work.");
        book.setTitle("Personal Development for Life and Work");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Manuel G. Velasquez");
        book.setAvailable(true);
        book.setGenre("Business");
        book.setPrice(40.0);
        book.setRating(4.8);
        book.setSynopsis("A book on business ethics concepts and cases.");
        book.setTitle("Business Ethics-Concepts & Cases");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Benny Joseph");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(22.0);
        book.setRating(4.2);
        book.setSynopsis("A book on environmental studies.");
        book.setTitle("Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("R.Rajagopalan");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(24.0);
        book.setRating(4.3);
        book.setSynopsis("A book on environmental studies.");
        book.setTitle("Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("AnanditaBasak");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(23.0);
        book.setRating(4.2);
        book.setSynopsis("A book on environmental studies.");
        book.setTitle("Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Kurian Joseph & Nagendran");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(26.0);
        book.setRating(4.4);
        book.setSynopsis("A book on the essentials of environmental studies.");
        book.setTitle("Essentials of Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Varadbal G. Mhatre");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(20.0);
        book.setRating(4.1);
        book.setSynopsis("A book on the fundamentals of environmental studies.");
        book.setTitle("Fundamentals of Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Kaushik and Kaushik");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(21.0);
        book.setRating(4.2);
        book.setSynopsis("A book on the perspective of environmental studies.");
        book.setTitle("Perspective of Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Godfrey Boyle");
        book.setAvailable(true);
        book.setGenre("Energy");
        book.setPrice(30.0);
        book.setRating(4.6);
        book.setSynopsis("A book on renewable energy.");
        book.setTitle("Renewable Energy");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dave and Katewa");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(27.0);
        book.setRating(4.5);
        book.setSynopsis("A textbook of environmental studies.");
        book.setTitle("Textbook of Environmental Studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("ErachBharucha");
        book.setAvailable(true);
        book.setGenre("Environment");
        book.setPrice(29.0);
        book.setRating(4.7);
        book.setSynopsis("A textbook of environmental studies.");
        book.setTitle("Textbook of Environmental studies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("C.S. Rao");
        book.setAvailable(true);
        book.setGenre("Engineering");
        book.setPrice(45.0);
        book.setRating(4.8);
        book.setSynopsis("A book on environmental pollution control engineering.");
        book.setTitle("Environmental pollution control engineering");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Terry Felke-Morris");
        book.setAvailable(true);
        book.setGenre("Web Development");
        book.setPrice(35.0);
        book.setRating(4.6);
        book.setSynopsis("A book on web development and design foundations with HTML5.");
        book.setTitle("Web Development and Design Foundations with HTML5");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Marijn Haverbeke");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(40.0);
        book.setRating(4.8);
        book.setSynopsis("An eloquent guide to JavaScript.");
        book.setTitle("Eloquent JavaScript");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Shama Hoque");
        book.setAvailable(true);
        book.setGenre("Web Development");
        book.setPrice(45.0);
        book.setRating(4.7);
        book.setSynopsis("A book on full-stack web development with React and Node.");
        book.setTitle("Full-Stack Web Development with React and Node");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Vasan Subramanian");
        book.setAvailable(true);
        book.setGenre("Web Development");
        book.setPrice(50.0);
        book.setRating(4.9);
        book.setSynopsis("A book on full stack web app development with Mongo, Express, React, and Node.");
        book.setTitle("Pro MERN Stack: Full Stack Web App Development with Mongo, Express, React, and Node");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Laura Cassell, Alan Gauld");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(30.0);
        book.setRating(4.5);
        book.setSynopsis("A book of Python projects.");
        book.setTitle("Python Projects");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Kyle Simpson");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(0.0);
        book.setRating(4.9);
        book.setSynopsis("A series of books on JavaScript.");
        book.setTitle("You Don't Know JS");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Alex Banks & Eve Porcello");
        book.setAvailable(true);
        book.setGenre("Web Development");
        book.setPrice(42.0);
        book.setRating(4.7);
        book.setSynopsis("A book on modern patterns for developing React apps.");
        book.setTitle("Learning React: Modern Patterns for Developing React Apps");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mario Casciaro & Luciano Mammino");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(48.0);
        book.setRating(4.8);
        book.setSynopsis("A book on scalable backend development using Node.js and Express.js.");
        book.setTitle("Node.js Design Patterns");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mathias Biilmann & Phil Hawksworth");
        book.setAvailable(true);
        book.setGenre("Web Development");
        book.setPrice(55.0);
        book.setRating(4.9);
        book.setSynopsis("A book on modern web development on the JAMstack.");
        book.setTitle("Modern Web Development on the JAMstack");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("James F. Kurose & K W Ross");
        book.setAvailable(true);
        book.setGenre("Networking");
        book.setPrice(60.0);
        book.setRating(4.9);
        book.setSynopsis("A top-down approach to computer networking.");
        book.setTitle("Computer Networking: A Top Down Approach");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("B.A. Forouzan");
        book.setAvailable(true);
        book.setGenre("Networking");
        book.setPrice(58.0);
        book.setRating(4.8);
        book.setSynopsis("A book on data communications and networking.");
        book.setTitle("Data Communications and Networking");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("A.S. Tanenbaum");
        book.setAvailable(true);
        book.setGenre("Networking");
        book.setPrice(62.0);
        book.setRating(4.9);
        book.setSynopsis("A book on computer networks.");
        book.setTitle("Computer Networks");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Douglas E. Comer");
        book.setAvailable(true);
        book.setGenre("Networking");
        book.setPrice(55.0);
        book.setRating(4.7);
        book.setSynopsis("A book on computer networks and the internet.");
        book.setTitle("Computer Network & Internet");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Reema Thareja");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(40.0);
        book.setRating(4.6);
        book.setSynopsis("A book on data structures using C.");
        book.setTitle("Data Structures using C");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Aaron M Tenenbaum, et al.");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(45.0);
        book.setRating(4.7);
        book.setSynopsis("A book on data structures using C.");
        book.setTitle("Data Structures Using C");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Kruse et. al.");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(42.0);
        book.setRating(4.5);
        book.setSynopsis("A book on data structures and program design.");
        book.setTitle("Data Structures and Program Design");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Balagurusamy");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(38.0);
        book.setRating(4.4);
        book.setSynopsis("A book on data structures using C.");
        book.setTitle("Data Structure Using C");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Richard F. Gilberg and Behrouz A. Forouzan");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(48.0);
        book.setRating(4.8);
        book.setSynopsis("A pseudocode approach to data structures with C.");
        book.setTitle("Data Structures: A Pseudocode Approach with C");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Jean Paul Tremblay, P. G. Sorenson");
        book.setAvailable(true);
        book.setGenre("Data Structures");
        book.setPrice(50.0);
        book.setRating(4.9);
        book.setSynopsis("An introduction to data structures and its applications.");
        book.setTitle("Introduction to Data Structure and Its Applications");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Hopcroft, Motwani, and Ullman");
        book.setAvailable(true);
        book.setGenre("Computer Science");
        book.setPrice(65.0);
        book.setRating(4.9);
        book.setSynopsis("An introduction to automata theory, languages, and computation.");
        book.setTitle("Introduction to Automata Theory, Languages and Computation");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("P. Linz");
        book.setAvailable(true);
        book.setGenre("Computer Science");
        book.setPrice(60.0);
        book.setRating(4.8);
        book.setSynopsis("An introduction to formal language and computation.");
        book.setTitle("Introduction to Formal Language and Computation");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Lames Allen");
        book.setAvailable(true);
        book.setGenre("Computer Science");
        book.setPrice(55.0);
        book.setRating(4.7);
        book.setSynopsis("A book on natural language understanding.");
        book.setTitle("Natural Language Understanding");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dexter C. Kozen");
        book.setAvailable(true);
        book.setGenre("Computer Science");
        book.setPrice(70.0);
        book.setRating(4.9);
        book.setSynopsis("A book on automata and computability.");
        book.setTitle("Automata and Computability");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mishra & Chandrasekharan");
        book.setAvailable(true);
        book.setGenre("Computer Science");
        book.setPrice(68.0);
        book.setRating(4.8);
        book.setSynopsis("A book on the theory of computer science: automata language and computation.");
        book.setTitle("Theory of computer science: Automata language and computation");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("David Hanes, et al.");
        book.setAvailable(true);
        book.setGenre("IoT");
        book.setPrice(75.0);
        book.setRating(4.9);
        book.setSynopsis("A book on IoT fundamentals: networking technologies, protocols, and use cases for the Internet of Things.");
        book.setTitle("IoT Fundamentals: Networking Technologies, Protocols, and Use Cases for the Internet of Things");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Arshdeep Bahga, Vijay Madisetti");
        book.setAvailable(true);
        book.setGenre("IoT");
        book.setPrice(72.0);
        book.setRating(4.8);
        book.setSynopsis("A hands-on approach to the Internet of Things.");
        book.setTitle("Internet of Things - A hands-on approach");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Daniel Minoli");
        book.setAvailable(true);
        book.setGenre("IoT");
        book.setPrice(80.0);
        book.setRating(4.9);
        book.setSynopsis("A book on building the Internet of Things with IPv6 and MIPv6.");
        book.setTitle("Building the Internet of Things with IPv6 and MIPv6: The Evolving World of M2M Communications");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Bernd Scholz-Reiter, Florian Michahelles");
        book.setAvailable(true);
        book.setGenre("IoT");
        book.setPrice(78.0);
        book.setRating(4.8);
        book.setSynopsis("A book on architecting the Internet of Things.");
        book.setTitle("Architecting the Internet of Things");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Jack Meredith & Samuel Mantel");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(50.0);
        book.setRating(4.7);
        book.setSynopsis("A managerial approach to project management.");
        book.setTitle("Project Management: A managerial approach");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dennis Lock");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(48.0);
        book.setRating(4.6);
        book.setSynopsis("A book on project management.");
        book.setTitle("Project Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Harold Kerzner");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(55.0);
        book.setRating(4.8);
        book.setSynopsis("A systems approach to planning, scheduling, and controlling projects.");
        book.setTitle("Project Management: A Systems Approach to Planning, Scheduling, and Controlling");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Project Management Institute");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(0.0);
        book.setRating(4.9);
        book.setSynopsis("A guide to the project management body of knowledge.");
        book.setTitle("A Guide to the Project Management Body of Knowledge (PMBOK® Guide)");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Terry Schmid");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(45.0);
        book.setRating(4.5);
        book.setSynopsis("Practical tools for leaders and teams in strategic project management.");
        book.setTitle("Strategic Project Management Made Simple: Practical Tools for Leaders and Teams");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Scott Berkun");
        book.setAvailable(true);
        book.setGenre("Project Management");
        book.setPrice(42.0);
        book.setRating(4.4);
        book.setSynopsis("A book on mastering project management.");
        book.setTitle("Making Things Happen: Mastering Project Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Sushil Bhardwaj");
        book.setAvailable(true);
        book.setGenre("Marketing");
        book.setPrice(35.0);
        book.setRating(4.3);
        book.setSynopsis("A book on e-commerce and digital marketing.");
        book.setTitle("E-Commerce And Digital Marketing");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Rajan Gupta, Supriya Madan");
        book.setAvailable(true);
        book.setGenre("Marketing");
        book.setPrice(38.0);
        book.setRating(4.4);
        book.setSynopsis("A book on the science and magic of digital marketing.");
        book.setTitle("Digital Marketing: The Science and Magic of Digital Marketing Can Help You Become a Successful Marketing Professional");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dave Chaffey, Fiona Ellis-Chadwick");
        book.setAvailable(true);
        book.setGenre("Marketing");
        book.setPrice(40.0);
        book.setRating(4.5);
        book.setSynopsis("A book on digital marketing.");
        book.setTitle("Digital Marketing");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Stephanie Diamond");
        book.setAvailable(true);
        book.setGenre("Marketing");
        book.setPrice(30.0);
        book.setRating(4.2);
        book.setSynopsis("An all-in-one guide for dummies on digital marketing.");
        book.setTitle("Digital Marketing All-In-One For Dummies");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Lockwood, Thomas");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(50.0);
        book.setRating(4.7);
        book.setSynopsis("A book on integrating innovation, customer experience, and brand value through design thinking.");
        book.setTitle("Design Thinking: Integrating Innovation, Customer Experience, and Brand Value");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Brown, Tim");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(55.0);
        book.setRating(4.8);
        book.setSynopsis("A book on how design thinking transforms organizations and inspires innovation.");
        book.setTitle("Change by Design, Revised and Updated: How Design Thinking Transforms Organizations and Inspires Innovation");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Springer Berlin Heidelberg");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(45.0);
        book.setRating(4.6);
        book.setSynopsis("A book to understand, improve, and apply design thinking.");
        book.setTitle("Design Thinking: Understand - Improve - Apply");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Wiley");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(48.0);
        book.setRating(4.7);
        book.setSynopsis("New product development essentials from the PDMA.");
        book.setTitle("Design Thinking: New Product Development Essentials from the PDMA");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Springer Nature Singapore");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(52.0);
        book.setRating(4.8);
        book.setSynopsis("A book on creativity, design thinking, and interdisciplinary.");
        book.setTitle("Creativity, Design Thinking and Interdisciplinary");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Springer International Publishing");
        book.setAvailable(true);
        book.setGenre("Design");
        book.setPrice(58.0);
        book.setRating(4.9);
        book.setSynopsis("A book on making design thinking foundational.");
        book.setTitle("Design Thinking Research: Making Design Thinking Foundational");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Mankiw, N. Gregory");
        book.setAvailable(true);
        book.setGenre("Economics");
        book.setPrice(60.0);
        book.setRating(4.9);
        book.setSynopsis("A book on the principles of microeconomics.");
        book.setTitle("Principles of Microeconomics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Bernheim, B., Whinston, M.");
        book.setAvailable(true);
        book.setGenre("Economics");
        book.setPrice(58.0);
        book.setRating(4.8);
        book.setSynopsis("A book on microeconomics.");
        book.setTitle("Microeconomics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Pindyck, Robert S., and Daniel L. Rubinfeld");
        book.setAvailable(true);
        book.setGenre("Economics");
        book.setPrice(62.0);
        book.setRating(4.9);
        book.setSynopsis("A book on microeconomics.");
        book.setTitle("Microeconomics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Varian, Hal R.");
        book.setAvailable(true);
        book.setGenre("Economics");
        book.setPrice(65.0);
        book.setRating(4.9);
        book.setSynopsis("A modern approach to intermediate microeconomics.");
        book.setTitle("Intermediate Microeconomics: A Modern Approach");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Case, Karl E., Fair, Ray C., and Oster, Sharon E.");
        book.setAvailable(true);
        book.setGenre("Economics");
        book.setPrice(55.0);
        book.setRating(4.7);
        book.setSynopsis("A book on the principles of microeconomics.");
        book.setTitle("Principles of Microeconomics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Prasanna Chandra");
        book.setAvailable(true);
        book.setGenre("Finance");
        book.setPrice(70.0);
        book.setRating(4.9);
        book.setSynopsis("A book on the theory and practice of financial management.");
        book.setTitle("Financial Management Theory & Practice");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Eugene F. Brigham and Joel F. Houston");
        book.setAvailable(true);
        book.setGenre("Finance");
        book.setPrice(75.0);
        book.setRating(4.9);
        book.setSynopsis("A book on the fundamentals of financial management.");
        book.setTitle("Fundamentals of Financial Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Van Horne");
        book.setAvailable(true);
        book.setGenre("Finance");
        book.setPrice(72.0);
        book.setRating(4.8);
        book.setSynopsis("A book on the fundamentals of financial management.");
        book.setTitle("Fundamentals of Financial Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("I. M. Pandey");
        book.setAvailable(true);
        book.setGenre("Finance");
        book.setPrice(68.0);
        book.setRating(4.7);
        book.setSynopsis("A book on financial management.");
        book.setTitle("Financial Management");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Yashavant Kanetkar");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(30.0);
        book.setRating(4.5);
        book.setSynopsis("A book on Python.");
        book.setTitle("Let us Python: Python is Future, Embrace it fastl");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("James Payne");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(35.0);
        book.setRating(4.6);
        book.setSynopsis("A book on beginning Python using Python 2.6 and Python 3.1.");
        book.setTitle("Beginning Python: Using Python 2.6 and Python 3.1");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("E Balagurusamy");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(32.0);
        book.setRating(4.4);
        book.setSynopsis("AREEn introduction to computing and problem-solving using python.");
        book.setTitle("Introduction to computing and problem-solving using python");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("John Grayson");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(40.0);
        book.setRating(4.7);
        book.setSynopsis("A book on Python and Tkinter programming.");
        book.setTitle("Python and Tkinter Programming");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Dr. R. Nageswara Rao");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(42.0);
        book.setRating(4.8);
        book.setSynopsis("A book on core Python programming.");
        book.setTitle("Core Python Programming");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Eric Matthes");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(45.0);
        book.setRating(4.9);
        book.setSynopsis("A hands-on, project-based introduction to programming with Python.");
        book.setTitle("Python Crash Course A hands-on, Project Based Introduction to programming");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Paul Barry");
        book.setAvailable(true);
        book.setGenre("Programming");
        book.setPrice(38.0);
        book.setRating(4.6);
        book.setSynopsis("A head first guide to Python.");
        book.setTitle("Head First Python");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Andreas C. Mueller");
        book.setAvailable(true);
        book.setGenre("Machine Learning");
        book.setPrice(50.0);
        book.setRating(4.9);
        book.setSynopsis("An introduction to machine learning with Python.");
        book.setTitle("Introduction to Machine Learning with Python");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Laxmikanth");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(25.0);
        book.setRating(4.3);
        book.setSynopsis("A book on Indian polity.");
        book.setTitle("Indian Polity");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Durga Das Basu");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(30.0);
        book.setRating(4.4);
        book.setSynopsis("An introduction to the Constitution of India.");
        book.setTitle("Introduction to the Constitution of India");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Subash Kashyap");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(28.0);
        book.setRating(4.2);
        book.setSynopsis("A book on the Indian Constitution.");
        book.setTitle("Indian Constitution");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("D.C. Gupta");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(32.0);
        book.setRating(4.5);
        book.setSynopsis("A book on the dynamics of Indian government and politics.");
        book.setTitle("Dynamics of Indian Government & Politics");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("H.M.Sreevai");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(40.0);
        book.setRating(4.7);
        book.setSynopsis("A 3-volume book on the constitutional law of India.");
        book.setTitle("Constitutional Law of India");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Subhash Kashyap");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(26.0);
        book.setRating(4.1);
        book.setSynopsis("A book on Indian administration.");
        book.setTitle("Indian Administration");
        bookRepository.save(book);

        book = new Book();
        book.setAuthor("Avasthi and Maheshwari");
        book.setAvailable(true);
        book.setGenre("Politics");
        book.setPrice(27.0);
        book.setRating(4.2);
        book.setSynopsis("A book on Indian administration.");
        book.setTitle("Indian Administration");
        bookRepository.save(book);
    }
}

