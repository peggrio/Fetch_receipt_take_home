package com.fetch.receipt.service;

import com.fetch.receipt.dto.ReceiptDto;

public interface IReceiptsService {
    /**
     * @param receiptDto - the receipt to be created
     */
    String createReceipt(ReceiptDto receiptDto);

    /**
     *
     * @param id
     * @return
     */
    double getPoints(String id);
}
