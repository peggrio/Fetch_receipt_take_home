package com.fetch.receipt.mapper;

import com.fetch.receipt.dto.ReceiptDto;
import com.fetch.receipt.entity.Receipt;

public class ReceiptsMapper {

    public static ReceiptDto mapToReceiptDto(Receipt receipt, ReceiptDto receiptDto) {
        receiptDto.setItems(receipt.getItems());
        return receiptDto;
    }

    public static Receipt mapToReceipt(ReceiptDto receiptDto, Receipt receipt) {
        receipt.setRetailer(receiptDto.getRetailer());
        receipt.setPurchaseDate(receiptDto.getPurchaseDate());
        receipt.setPurchaseTime(receiptDto.getPurchaseTime());
        receipt.setTotal(receiptDto.getTotal());
        receipt.setItems(receiptDto.getItems());
        return receipt;
    }
}
