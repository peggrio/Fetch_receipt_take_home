package com.fetch.receipt.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Data
@Schema(
        name = "Receipt",
        description = "Schema to hold Receipt details"
)
public class ReceiptDto {
    @NotEmpty(message = "Retailer can not be null or empty")
    @Pattern(regexp = "^[\\w\\s\\-&]+$")
    @Schema(
        description = "The name of the retailer or store the receipt is from.",
        example = "M&M Corner Market"
    )
    private String retailer;

    @NotEmpty(message = "Purchase date can not be null or empty")
    @Pattern(regexp = "^\\d{4}-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$",
            message = "Purchase date must be in YYYY-MM-DD format")
    @Schema(
            description = "The date of the purchase printed on the receipt.",
            example = "2022-01-01"
    )
    private String purchaseDate;

    @NotEmpty(message = "Purchase time can not be null or empty")
    @Pattern(regexp = "^(?:[01]\\d|2[0-3]):[0-5]\\d$",
            message = "Purchase time must be in 24-hour HH:mm format")
    @Schema(
            description = "The time of the purchase printed on the receipt. 24-hour time expected.",
            example = "13:01"
    )
    private String purchaseTime;

    @NotEmpty(message = "items can not be null or empty")
    @Size(min = 1, message = "Must have at least one item")
    private List<ItemDto> items;

    @NotEmpty(message = "Total can not be null or empty")
    @Pattern(regexp = "^\\d+\\.\\d{2}$", message = "Total must be in format 0.00")
    @Schema(
            description = "The total amount paid on the receipt.",
            example = "6.49"
    )
    private String total;

}
