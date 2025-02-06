package com.fetch.receipt.controller;

import com.fetch.receipt.constants.ReceiptsConstants;
import com.fetch.receipt.dto.ReceiptDto;
import com.fetch.receipt.dto.ResponseDto;
import com.fetch.receipt.service.IReceiptsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Tag(
//        name = "CRUD REST APIs for receipts",
//        description = "CRUD REST APIs to POST receipts and GET points"
//)

@RestController
@RequestMapping(path="/receipts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class ReceiptsController {

    private IReceiptsService iReceiptsService;
    @PostMapping("/process")
    public ResponseEntity<ResponseDto> processReceipt(@RequestBody ReceiptDto receiptDto) {
        String id = iReceiptsService.createReceipt(receiptDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(ReceiptsConstants.STATUS_201, id));
    }
}
