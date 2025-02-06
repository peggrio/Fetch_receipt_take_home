package com.fetch.receipt.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
public class ReceiptDto {
    private String retailer;
    private LocalDate purchaseDate;
    private LocalTime purchaseTime;
    private List<ItemDto> items;  // Changed from String to List<Item>
    private Double total;
}
