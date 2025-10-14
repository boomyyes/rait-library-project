package com.rait.library_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

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
        List<Book> books = new ArrayList<>();

        books.add(createBook("JAVA: The Complete Reference", "Herbert Schildt", "Programming", "A comprehensive guide to Java programming.", 19.99, 4.5));
        books.add(createBook("Programming in Java", "Sachin Malhotra and Saurabh Chaudhary", "Programming", "A book on programming in Java.", 24.99, 4.6));
        books.add(createBook("Beginning JAVA", "Ivor Horton", "Programming", "A beginner's guide to Java.", 22.5, 4.4));
        books.add(createBook("Java: How to Program", "Deitel and Deitel", "Programming", "A guide on how to program in Java.", 29.99, 4.7));
        books.add(createBook("JAVA Programming", "Dreamtech Press", "Programming", "A comprehensive book on JAVA Programming.", 18.99, 4.3));
        books.add(createBook("Learn to Master Java programming", "Staredu Solutions", "Programming", "A book to master Java programming.", 15.99, 4.2));
        books.add(createBook("Database System Concepts", "A. Silberschatz, H. F. Korth, and S. Sudarshan", "Databases", "A book on database system concepts.", 35.0, 4.8));
        books.add(createBook("Fundamentals of Database Systems", "R. Elmasri, Navathe", "Databases", "A book on the fundamentals of database systems.", 39.99, 4.9));
        books.add(createBook("Introduction to Database Management - Project Manual", "M. L. Gillenson, et al.", "Databases", "A project manual for database management.", 32.5, 4.6));
        books.add(createBook("SQL and PL/SQL for Oracle 10g Black Book", "P. S. Deshpande", "Databases", "A book on SQL and PL/SQL for Oracle 10g.", 28.99, 4.5));
        books.add(createBook("Database Management Systems", "G. K. Gupta", "Databases", "A book on database management systems.", 25.0, 4.4));
        books.add(createBook("Database Management Systems", "B. R. Desai", "Databases", "A book on database management systems.", 20.0, 4.2));
        books.add(createBook("Discrete Mathematical Structures", "Bernad Kolman, et al.", "Mathematics", "A book on discrete mathematical structures.", 45.0, 4.7));
        books.add(createBook("Discrete Mathematics and applications", "K.H. Rosen", "Mathematics", "A book on discrete mathematics and its applications.", 49.99, 4.9));
        books.add(createBook("Elements of Discrete Mathematics", "C.L. Liu", "Mathematics", "A book on the elements of discrete mathematics.", 40.0, 4.6));
        books.add(createBook("Discrete Mathematical Structures with Application to Computer Science", "J. P. Tremblay & R. Manohar", "Mathematics", "A book on discrete mathematical structures with applications to computer science.", 42.5, 4.5));
        books.add(createBook("Discrete Mathematics", "Seymour Lipschutz, Marc Lars Lipson", "Mathematics", "An outline of discrete mathematics.", 38.99, 4.4));
        books.add(createBook("Digital Design: With an Introduction to the Verilog HDL, VHDL, and System Verilog", "M. Morris Mano", "Digital Design", "An introduction to digital design with Verilog HDL, VHDL, and System Verilog.", 55.0, 4.8));
        books.add(createBook("Digital Fundamentals", "Thomas L. Floyd", "Digital Design", "A book on digital fundamentals.", 52.0, 4.7));
        books.add(createBook("The 8051 Microcontroller and Embedded systems", "Mazidi M.A", "Embedded Systems", "A book on the 8051 microcontroller and embedded systems.", 60.0, 4.9));
        books.add(createBook("The 8051 Microcontroller", "Kenneth Ayala", "Embedded Systems", "A book on the 8051 microcontroller.", 58.0, 4.8));
        books.add(createBook("Embedded Systems: Architecture, Programming and Design", "Rajkamal", "Embedded Systems", "A book on the architecture, programming, and design of embedded systems.", 65.0, 4.9));
        books.add(createBook("Embedded Systems Design", "Steve Heath", "Embedded Systems", "A book on embedded systems design.", 62.0, 4.7));
        books.add(createBook("Embedded Software Primer", "David Simon", "Embedded Systems", "A primer on embedded software.", 55.0, 4.6));
        books.add(createBook("Cortex-M4 Devices Generic User Guide", "ARM", "Embedded Systems", "A generic user guide for Cortex-M4 devices.", 70.0, 4.9));
        books.add(createBook("Embedded System: Real-Time Interfacing to ARM Cortex-M Microcontrollers", "Jonathan W. Valvano", "Embedded Systems", "A book on real-time interfacing to ARM Cortex-M microcontrollers.", 75.0, 4.9));
        books.add(createBook("ARM System Developers guide", "Andrew N SLOSS, Dominic SYMES, Chris WRIGHT", "Embedded Systems", "A guide for ARM system developers.", 80.0, 4.9));
        books.add(createBook("Human Resource Management", "Garry Dessler & Varkkey", "Management", "A book on human resource management.", 40.0, 4.5));
        books.add(createBook("Human Resource Management", "Alan Price", "Management", "A book on human resource management.", 38.0, 4.4));
        books.add(createBook("Human Resource Mangement", "Pravin Durai", "Management", "A book on human resource management.", 35.0, 4.3));
        books.add(createBook("Human Resources Management", "Snell, Bohlander & Vohra", "Management", "A book on human resources management.", 42.0, 4.6));
        books.add(createBook("Personnel Management And Human Resources", "Venkata Ratnam C. S. & Srivatsava B. K.", "Management", "A book on personnel management and human resources.", 39.0, 4.5));
        books.add(createBook("Human Resource Mangement", "Aswathappa", "Management", "A book on human resource management.", 36.0, 4.4));
        books.add(createBook("Digital Education and Learning", "Chris Bailey", "Technology", "A book on digital education and learning.", 25.0, 4.2));
        books.add(createBook("The Online Classroom: Resources for Effective Middle Level Virtual Education", "Brooke B. Eisenbach, Paula Greathouse", "Technology", "Resources for effective middle level virtual education.", 28.0, 4.3));
        books.add(createBook("Creativity: The Psychology of Discovery and Invention", "Mihaly Csikszentmihalyi", "Psychology", "A book on the psychology of discovery and invention.", 30.0, 4.7));
        books.add(createBook("Lifelong Creativity, An Unending Quest", "Pradip N Khandwalla", "Business", "A book on lifelong creativity.", 32.0, 4.6));
        books.add(createBook("Innovation Management", "Vinnie Jauhari, Sudanshu Bhushan", "Business", "A book on innovation management.", 34.0, 4.5));
        books.add(createBook("Creativity", "A.DaleTimpe", "Business", "A book on creativity.", 29.0, 4.4));
        books.add(createBook("Creativity", "Brian Clegg, Paul Birch", "Business", "A book on creativity.", 28.0, 4.3));
        books.add(createBook("Steal Like an Artist: 10 Things Nobody Told You About Being Creative", "Austin Kleon", "Art", "10 things nobody told you about being creative.", 15.0, 4.8));
        books.add(createBook("Managing Creativity for Corporate Excellence", "P. N. Rastogi", "Business", "A book on managing creativity for corporate excellence.", 33.0, 4.5));
        books.add(createBook("Innovation Management", "C. S. G. Krishnamacharyulu, R. Lalitha", "Business", "A book on innovation management.", 31.0, 4.4));
        books.add(createBook("The Innovator's Dilemma: When New Technologies Cause Great Firms to Fail", "Clayton M. Christensen", "Business", "A book on when new technologies cause great firms to fail.", 36.0, 4.8));
        books.add(createBook("Accounting Basics", "L. Hatfield", "Accounting", "A book on the basics of accounting.", 18.0, 4.1));
        books.add(createBook("Introduction to Financial Accounting", "C. T. Horngren, et al.", "Accounting", "An introduction to financial accounting.", 22.0, 4.3));
        books.add(createBook("Book Keeping & Accountancy", "S. A. Siddiqui", "Accounting", "A book on book keeping and accountancy.", 20.0, 4.2));
        books.add(createBook("Financial Accounting", "D. Sehgal", "Accounting", "A book on financial accounting.", 24.0, 4.4));
        books.add(createBook("Financial Accounting", "P. C. Tulsian", "Accounting", "A book on financial accounting.", 26.0, 4.5));
        books.add(createBook("Financial Accounting", "A. Mukharji, & M. Hanif", "Accounting", "A book on financial accounting.", 25.0, 4.4));
        books.add(createBook("Financial Accounting", "S. N. Maheshwari, et al.", "Accounting", "A book on financial accounting.", 28.0, 4.6));
        books.add(createBook("Financial Accounting", "S. Mukherjee, & A. K. Mukherjee", "Accounting", "A book on financial accounting.", 27.0, 4.5));
        books.add(createBook("Financial Accounting", "S. P. Jain, & K. L. Narang", "Accounting", "A book on financial accounting.", 23.0, 4.3));
        books.add(createBook("Financial Accounting", "R. L. Gupta, & M. Radhaswamy", "Accounting", "A book on financial accounting.", 21.0, 4.2));
        books.add(createBook("Financial Accounting Text & Problems", "J. Lal, & S. Srivastava", "Accounting", "A book of financial accounting text and problems.", 19.0, 4.1));
        books.add(createBook("Financial Accounting: Concepts and Applications", "J. R. Monga", "Accounting", "A book on financial accounting concepts and applications.", 29.0, 4.7));
        books.add(createBook("Financial Accounting", "B. K. Goyal, & H. N. Tiwari", "Accounting", "A book on financial accounting.", 30.0, 4.8));
        books.add(createBook("Effective Business Communication", "Asha Kaul", "Communication", "A book on effective business communication.", 35.0, 4.6));
        books.add(createBook("Communication Skills: Second Edition", "Sanjay Kumar PushpLata", "Communication", "A book on communication skills.", 32.0, 4.5));
        books.add(createBook("Effective Technical Communication", "Rizvi Ashraf", "Communication", "A book on effective technical communication.", 38.0, 4.7));
        books.add(createBook("Soft Skills for Everyone", "Jeff Butterfield", "Self-Help", "A book on soft skills for everyone.", 25.0, 4.4));
        books.add(createBook("Business Communication", "Chaturvedi and Chaturvedi", "Communication", "A book on business communication.", 33.0, 4.5));
        books.add(createBook("Personal Development for Life and Work", "Masters Wallace", "Self-Help", "A book on personal development for life and work.", 28.0, 4.3));
        books.add(createBook("Business Ethics-Concepts & Cases", "Manuel G. Velasquez", "Business", "A book on business ethics concepts and cases.", 40.0, 4.8));
        books.add(createBook("Environmental Studies", "Benny Joseph", "Environment", "A book on environmental studies.", 22.0, 4.2));
        books.add(createBook("Environmental Studies", "R.Rajagopalan", "Environment", "A book on environmental studies.", 24.0, 4.3));
        books.add(createBook("Environmental Studies", "AnanditaBasak", "Environment", "A book on environmental studies.", 23.0, 4.2));
        books.add(createBook("Essentials of Environmental Studies", "Kurian Joseph & Nagendran", "Environment", "A book on the essentials of environmental studies.", 26.0, 4.4));
        books.add(createBook("Fundamentals of Environmental Studies", "Varadbal G. Mhatre", "Environment", "A book on the fundamentals of environmental studies.", 20.0, 4.1));
        books.add(createBook("Perspective of Environmental Studies", "Kaushik and Kaushik", "Environment", "A book on the perspective of environmental studies.", 21.0, 4.2));
        books.add(createBook("Renewable Energy", "Godfrey Boyle", "Energy", "A book on renewable energy.", 30.0, 4.6));
        books.add(createBook("Textbook of Environmental Studies", "Dave and Katewa", "Environment", "A textbook of environmental studies.", 27.0, 4.5));
        books.add(createBook("Textbook of Environmental studies", "ErachBharucha", "Environment", "A textbook of environmental studies.", 29.0, 4.7));
        books.add(createBook("Environmental pollution control engineering", "C.S. Rao", "Engineering", "A book on environmental pollution control engineering.", 45.0, 4.8));
        books.add(createBook("Web Development and Design Foundations with HTML5", "Terry Felke-Morris", "Web Development", "A book on web development and design foundations with HTML5.", 35.0, 4.6));
        books.add(createBook("Eloquent JavaScript", "Marijn Haverbeke", "Programming", "An eloquent guide to JavaScript.", 40.0, 4.8));
        books.add(createBook("Full-Stack Web Development with React and Node", "Shama Hoque", "Web Development", "A book on full-stack web development with React and Node.", 45.0, 4.7));
        books.add(createBook("Pro MERN Stack: Full Stack Web App Development with Mongo, Express, React, and Node", "Vasan Subramanian", "Web Development", "A book on full stack web app development with Mongo, Express, React, and Node.", 50.0, 4.9));
        books.add(createBook("Python Projects", "Laura Cassell, Alan Gauld", "Programming", "A book of Python projects.", 30.0, 4.5));
        books.add(createBook("You Don't Know JS", "Kyle Simpson", "Programming", "A series of books on JavaScript.", 0.0, 4.9));
        books.add(createBook("Learning React: Modern Patterns for Developing React Apps", "Alex Banks & Eve Porcello", "Web Development", "A book on modern patterns for developing React apps.", 42.0, 4.7));
        books.add(createBook("Node.js Design Patterns", "Mario Casciaro & Luciano Mammino", "Programming", "A book on scalable backend development using Node.js and Express.js.", 48.0, 4.8));
        books.add(createBook("Modern Web Development on the JAMstack", "Mathias Biilmann & Phil Hawksworth", "Web Development", "A book on modern web development on the JAMstack.", 55.0, 4.9));
        books.add(createBook("Computer Networking: A Top Down Approach", "James F. Kurose & K W Ross", "Networking", "A top-down approach to computer networking.", 60.0, 4.9));
        books.add(createBook("Data Communications and Networking", "B.A. Forouzan", "Networking", "A book on data communications and networking.", 58.0, 4.8));
        books.add(createBook("Computer Networks", "A.S. Tanenbaum", "Networking", "A book on computer networks.", 62.0, 4.9));
        books.add(createBook("Computer Network & Internet", "Douglas E. Comer", "Networking", "A book on computer networks and the internet.", 55.0, 4.7));
        books.add(createBook("Data Structures using C", "Reema Thareja", "Data Structures", "A book on data structures using C.", 40.0, 4.6));
        books.add(createBook("Data Structures Using C", "Aaron M Tenenbaum, et al.", "Data Structures", "A book on data structures using C.", 45.0, 4.7));
        books.add(createBook("Data Structures and Program Design", "Kruse et. al.", "Data Structures", "A book on data structures and program design.", 42.0, 4.5));
        books.add(createBook("Data Structure Using C", "Balagurusamy", "Data Structures", "A book on data structures using C.", 38.0, 4.4));
        books.add(createBook("Data Structures: A Pseudocode Approach with C", "Richard F. Gilberg and Behrouz A. Forouzan", "Data Structures", "A pseudocode approach to data structures with C.", 48.0, 4.8));
        books.add(createBook("Introduction to Data Structure and Its Applications", "Jean Paul Tremblay, P. G. Sorenson", "Data Structures", "An introduction to data structures and its applications.", 50.0, 4.9));
        books.add(createBook("Introduction to Automata Theory, Languages and Computation", "Hopcroft, Motwani, and Ullman", "Computer Science", "An introduction to automata theory, languages, and computation.", 65.0, 4.9));
        books.add(createBook("Introduction to Formal Language and Computation", "P. Linz", "Computer Science", "An introduction to formal language and computation.", 60.0, 4.8));
        books.add(createBook("Natural Language Understanding", "Lames Allen", "Computer Science", "A book on natural language understanding.", 55.0, 4.7));
        books.add(createBook("Automata and Computability", "Dexter C. Kozen", "Computer Science", "A book on automata and computability.", 70.0, 4.9));
        books.add(createBook("Theory of computer science: Automata language and computation", "Mishra & Chandrasekharan", "Computer Science", "A book on the theory of computer science: automata language and computation.", 68.0, 4.8));
        books.add(createBook("IoT Fundamentals: Networking Technologies, Protocols, and Use Cases for the Internet of Things", "David Hanes, et al.", "IoT", "A book on IoT fundamentals: networking technologies, protocols, and use cases for the Internet of Things.", 75.0, 4.9));
        books.add(createBook("Internet of Things - A hands-on approach", "Arshdeep Bahga, Vijay Madisetti", "IoT", "A hands-on approach to the Internet of Things.", 72.0, 4.8));
        books.add(createBook("Building the Internet of Things with IPv6 and MIPv6: The Evolving World of M2M Communications", "Daniel Minoli", "IoT", "A book on building the Internet of Things with IPv6 and MIPv6.", 80.0, 4.9));
        books.add(createBook("Architecting the Internet of Things", "Bernd Scholz-Reiter, Florian Michahelles", "IoT", "A book on architecting the Internet of Things.", 78.0, 4.8));
        books.add(createBook("Project Management: A managerial approach", "Jack Meredith & Samuel Mantel", "Project Management", "A managerial approach to project management.", 50.0, 4.7));
        books.add(createBook("Project Management", "Dennis Lock", "Project Management", "A book on project management.", 48.0, 4.6));
        books.add(createBook("Project Management: A Systems Approach to Planning, Scheduling, and Controlling", "Harold Kerzner", "Project Management", "A systems approach to planning, scheduling, and controlling projects.", 55.0, 4.8));
        books.add(createBook("A Guide to the Project Management Body of Knowledge (PMBOK® Guide)", "Project Management Institute", "Project Management", "A guide to the project management body of knowledge.", 0.0, 4.9));
        books.add(createBook("Strategic Project Management Made Simple: Practical Tools for Leaders and Teams", "Terry Schmid", "Project Management", "Practical tools for leaders and teams in strategic project management.", 45.0, 4.5));
        books.add(createBook("Making Things Happen: Mastering Project Management", "Scott Berkun", "Project Management", "A book on mastering project management.", 42.0, 4.4));
        books.add(createBook("E-Commerce And Digital Marketing", "Sushil Bhardwaj", "Marketing", "A book on e-commerce and digital marketing.", 35.0, 4.3));
        books.add(createBook("Digital Marketing: The Science and Magic of Digital Marketing Can Help You Become a Successful Marketing Professional", "Rajan Gupta, Supriya Madan", "Marketing", "A book on the science and magic of digital marketing.", 38.0, 4.4));
        books.add(createBook("Digital Marketing", "Dave Chaffey, Fiona Ellis-Chadwick", "Marketing", "A book on digital marketing.", 40.0, 4.5));
        books.add(createBook("Digital Marketing All-In-One For Dummies", "Stephanie Diamond", "Marketing", "An all-in-one guide for dummies on digital marketing.", 30.0, 4.2));
        books.add(createBook("Design Thinking: Integrating Innovation, Customer Experience, and Brand Value", "Lockwood, Thomas", "Design", "A book on integrating innovation, customer experience, and brand value through design thinking.", 50.0, 4.7));
        books.add(createBook("Change by Design, Revised and Updated: How Design Thinking Transforms Organizations and Inspires Innovation", "Brown, Tim", "Design", "A book on how design thinking transforms organizations and inspires innovation.", 55.0, 4.8));
        books.add(createBook("Design Thinking: Understand - Improve - Apply", "Springer Berlin Heidelberg", "Design", "A book to understand, improve, and apply design thinking.", 45.0, 4.6));
        books.add(createBook("Design Thinking: New Product Development Essentials from the PDMA", "Wiley", "Design", "New product development essentials from the PDMA.", 48.0, 4.7));
        books.add(createBook("Creativity, Design Thinking and Interdisciplinary", "Springer Nature Singapore", "Design", "A book on creativity, design thinking, and interdisciplinary.", 52.0, 4.8));
        books.add(createBook("Design Thinking Research: Making Design Thinking Foundational", "Springer International Publishing", "Design", "A book on making design thinking foundational.", 58.0, 4.9));
        books.add(createBook("Principles of Microeconomics", "Mankiw, N. Gregory", "Economics", "A book on the principles of microeconomics.", 60.0, 4.9));
        books.add(createBook("Microeconomics", "Bernheim, B., Whinston, M.", "Economics", "A book on microeconomics.", 58.0, 4.8));
        books.add(createBook("Microeconomics", "Pindyck, Robert S., and Daniel L. Rubinfeld", "Economics", "A book on microeconomics.", 62.0, 4.9));
        books.add(createBook("Intermediate Microeconomics: A Modern Approach", "Varian, Hal R.", "Economics", "A modern approach to intermediate microeconomics.", 65.0, 4.9));
        books.add(createBook("Principles of Microeconomics", "Case, Karl E., Fair, Ray C., and Oster, Sharon E.", "Economics", "A book on the principles of microeconomics.", 55.0, 4.7));
        books.add(createBook("Financial Management Theory & Practice", "Prasanna Chandra", "Finance", "A book on the theory and practice of financial management.", 70.0, 4.9));
        books.add(createBook("Fundamentals of Financial Management", "Eugene F. Brigham and Joel F. Houston", "Finance", "A book on the fundamentals of financial management.", 75.0, 4.9));
        books.add(createBook("Fundamentals of Financial Management", "Van Horne", "Finance", "A book on the fundamentals of financial management.", 72.0, 4.8));
        books.add(createBook("Financial Management", "I. M. Pandey", "Finance", "A book on financial management.", 68.0, 4.7));
        books.add(createBook("Let us Python: Python is Future, Embrace it fastl", "Yashavant Kanetkar", "Programming", "A book on Python.", 30.0, 4.5));
        books.add(createBook("Beginning Python: Using Python 2.6 and Python 3.1", "James Payne", "Programming", "A book on beginning Python using Python 2.6 and Python 3.1.", 35.0, 4.6));
        books.add(createBook("Introduction to computing and problem-solving using python", "E Balagurusamy", "Programming", "An introduction to computing and problem-solving using python.", 32.0, 4.4));
        books.add(createBook("Python and Tkinter Programming", "John Grayson", "Programming", "A book on Python and Tkinter programming.", 40.0, 4.7));
        books.add(createBook("Core Python Programming", "Dr. R. Nageswara Rao", "Programming", "A book on core Python programming.", 42.0, 4.8));
        books.add(createBook("Python Crash Course A hands-on, Project Based Introduction to programming", "Eric Matthes", "Programming", "A hands-on, project-based introduction to programming with Python.", 45.0, 4.9));
        books.add(createBook("Head First Python", "Paul Barry", "Programming", "A head first guide to Python.", 38.0, 4.6));
        books.add(createBook("Introduction to Machine Learning with Python", "Andreas C. Mueller", "Machine Learning", "An introduction to machine learning with Python.", 50.0, 4.9));
        books.add(createBook("Indian Polity", "Laxmikanth", "Politics", "A book on Indian polity.", 25.0, 4.3));
        books.add(createBook("Introduction to the Constitution of India", "Durga Das Basu", "Politics", "An introduction to the Constitution of India.", 30.0, 4.4));
        books.add(createBook("Indian Constitution", "Subash Kashyap", "Politics", "A book on the Indian Constitution.", 28.0, 4.2));
        books.add(createBook("Dynamics of Indian Government & Politics", "D.C. Gupta", "Politics", "A book on the dynamics of Indian government and politics.", 32.0, 4.5));
        books.add(createBook("Constitutional Law of India", "H.M.Sreevai", "Politics", "A 3-volume book on the constitutional law of India.", 40.0, 4.7));
        books.add(createBook("Indian Administration", "Subhash Kashyap", "Politics", "A book on Indian administration.", 26.0, 4.1));
        books.add(createBook("Indian Administration", "Avasthi and Maheshwari", "Politics", "A book on Indian administration.", 27.0, 4.2));
        
        bookRepository.saveAll(books);
    }

    private Book createBook(String title, String author, String genre, String synopsis, double price, double rating) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
        book.setSynopsis(synopsis);
        book.setPrice(price);
        book.setRating(rating);
        book.setAvailable(true); // All books are available initially
        return book;
    }
}