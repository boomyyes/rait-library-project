package com.rait.library_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BorrowingController {

    @Autowired
    private BorrowingService borrowingService;

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return borrowingService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return borrowingService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/books/{id}/borrow")
    public ResponseEntity<?> borrowBook(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {
        try {
            return ResponseEntity.ok(borrowingService.borrowBook(id, userId));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/records/{id}/return")
    public ResponseEntity<?> returnBook(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {
        try {
            return ResponseEntity.ok(borrowingService.returnBook(id, userId));
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/users/me/records")
    public ResponseEntity<List<BorrowingRecord>> getUserRecords(@RequestHeader("X-User-Id") String userId) {
        return ResponseEntity.ok(borrowingService.getUserRecords(userId));
    }

    @PostMapping("/records/{id}/mark-paid")
    public ResponseEntity<?> markFineAsPaid(@PathVariable Long id, @RequestHeader("X-User-Id") String userId) {
        try {
            borrowingService.markFineAsPaid(id, userId);
            return ResponseEntity.ok().body("{\"message\": \"Fine marked as paid.\"}");
        } catch (IllegalStateException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}