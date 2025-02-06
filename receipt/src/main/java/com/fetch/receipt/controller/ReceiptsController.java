package com.fetch.receipt.controller;

import com.fetch.receipt.dto.PointsResponseDto;
import com.fetch.receipt.dto.ReceiptDto;
import com.fetch.receipt.dto.ResponseDto;
import com.fetch.receipt.service.IReceiptsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "CRUD REST APIs for receipts",
        description = "CRUD REST APIs to POST receipts and GET points"
)

@RestController
@RequestMapping(path="/receipts", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class ReceiptsController {

    private IReceiptsService iReceiptsService;
    @Operation(
            summary = "Submits a receipt for processing.",
            description = "Submits a receipt for processing."
    )
    @ApiResponse(
            responseCode = "200",
            description = "Returns the ID assigned to the receipt."
    )
    @ApiResponse(
            responseCode = "400",
            description = "HTTP Status BAD REQUEST"
    )
    @PostMapping("/process")
    public ResponseEntity<ResponseDto> processReceipt(@Valid @RequestBody ReceiptDto receiptDto) {
        String id = iReceiptsService.createReceipt(receiptDto);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(id));
    }

    @Operation(
            summary = "Returns the points awarded for the receipt.",
            description = "Returns the points awarded for the receipt."
    )
    @ApiResponse(
            responseCode = "200",
            description = "The number of points awarded."
    )
    @ApiResponse(
            responseCode = "400",
            description = "HTTP Status BAD REQUEST"
    )
    @GetMapping("/{id}/points")
    public ResponseEntity<PointsResponseDto> getReceiptPoints(@PathVariable String id){
        double points = iReceiptsService.getPoints(id);
        return ResponseEntity.status(HttpStatus.OK).body(new PointsResponseDto(points));
    }
}
