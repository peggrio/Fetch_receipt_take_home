package com.fetch.receipt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class ItemDto {
    @NotEmpty(message = "Retailer can not be null or empty")
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    @Schema(
            description = "The Short Product Description for the item.",
            example = "Mountain Dew 12PK"
    )
    private String shortDescription;

    @NotEmpty(message = "Total can not be null or empty")
    @Pattern(regexp = "^\\d+\\.\\d{2}$")
    @Schema(
            description = "The total price payed for this item.",
            example = "6.49"
    )
    private String price;
}