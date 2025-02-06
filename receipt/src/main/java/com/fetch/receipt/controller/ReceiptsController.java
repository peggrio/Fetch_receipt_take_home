package com.fetch.receipt.controller;

import com.fetch.receipt.dto.PointsResponseDto;
import com.fetch.receipt.dto.ReceiptDto;
import com.fetch.receipt.dto.ResponseDto;
import com.fetch.receipt.exception.ResourceNotFoundException;
import com.fetch.receipt.service.IReceiptsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for receipts",
        description = "CRUD REST APIs to POST receipts and GET points"
)

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
                .body(new ResponseDto(id));
    }

    @GetMapping("/{id}/points")
    public ResponseEntity<PointsResponseDto> getReceiptPoints(@PathVariable String id){
        double points = iReceiptsService.getPoints(id);
        return ResponseEntity.status(HttpStatus.OK).body(new PointsResponseDto(points));
    }
}
