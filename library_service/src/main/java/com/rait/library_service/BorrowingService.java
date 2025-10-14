package com.rait.library_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BorrowingService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    public Page<Book> getAllBooks(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookRepository.findAll(pageable);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    public List<BorrowingRecord> getUserRecords(String userId) {
        return borrowingRecordRepository.findByUserId(userId);
    }

    public BorrowingRecord borrowBook(Long bookId, String userId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new IllegalStateException("Book not found."));
        if (!book.isAvailable()) {
            throw new IllegalStateException("Book is not available for borrowing.");
        }
        book.setAvailable(false);
        bookRepository.save(book);

        BorrowingRecord record = new BorrowingRecord();
        record.setUserId(userId);
        record.setBook(book);
        record.setStatus(BorrowingRecord.Status.BORROWED);

        record.setBorrowDate(LocalDate.now());
        record.setDueDate(LocalDate.now().plusDays(-1)); //change to -1 to test fine, 10 for normal functionality

        return borrowingRecordRepository.save(record);
    }

    public BorrowingRecord returnBook(Long recordId, String userId) {
        BorrowingRecord record = borrowingRecordRepository.findByIdAndUserId(recordId, userId)
                .orElseThrow(() -> new IllegalStateException("Borrowing record not found."));
        record.setReturnDate(LocalDate.now());

        if (record.getReturnDate().isAfter(record.getDueDate())) {
            long overdueDays = ChronoUnit.DAYS.between(record.getDueDate(), record.getReturnDate());
            record.setFine(overdueDays * 10.0);
            record.setStatus(BorrowingRecord.Status.RETURNED_LATE);
        } else {
            record.setStatus(BorrowingRecord.Status.RETURNED);
        }
        Book book = record.getBook();
        book.setAvailable(true);
        bookRepository.save(book);
        return borrowingRecordRepository.save(record);
    }

    public BorrowingRecord markFineAsPaid(Long recordId, String userId) {
        BorrowingRecord record = borrowingRecordRepository.findByIdAndUserId(recordId, userId)
                .orElseThrow(() -> new IllegalStateException("Borrowing record not found."));
        if (record.getStatus() != BorrowingRecord.Status.RETURNED_LATE) {
            throw new IllegalStateException("This record has no fine to be paid.");
        }
        record.setFine(0.0);
        record.setStatus(BorrowingRecord.Status.PAID);
        return borrowingRecordRepository.save(record);
    }
}