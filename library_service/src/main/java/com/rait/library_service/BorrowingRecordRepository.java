package com.rait.library_service;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long> {
    List<BorrowingRecord> findByUserId(String userId);
    Optional<BorrowingRecord> findByIdAndUserId(Long id, String userId);
}