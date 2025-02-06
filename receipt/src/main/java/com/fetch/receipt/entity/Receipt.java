package com.fetch.receipt.entity;

import com.fetch.receipt.dto.ItemDto;
import com.fetch.receipt.utils.ItemsConverter;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "receipt")
@Getter @Setter @ToString @AllArgsConstructor @NoArgsConstructor
public class Receipt {

    @Id
    @Column(name = "receipt_id")
    private String receiptId;
    private String retailer;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "purchase_time")
    private LocalTime purchaseTime;

    private Double total;

    @Lob //large object
    @Convert(converter = ItemsConverter.class)
    private List<ItemDto> items;

    private Double points;
}
