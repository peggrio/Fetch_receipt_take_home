package com.fetch.receipt.repository;

import com.fetch.receipt.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReceiptRepository extends JpaRepository<Receipt, String> {

     Optional<Receipt> findByReceiptId(String id);
}
