package com.fetch.receipt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fetch.receipt.exception.BadRequestException;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fetch.receipt.dto.ItemDto;
import java.util.List;

@Converter
public class ItemsConverter implements AttributeConverter<List<ItemDto>, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(List<ItemDto> items) {
        try {
            return objectMapper.writeValueAsString(items);
        } catch (JsonProcessingException e) {
            throw new BadRequestException("The receipt is invalid. Please verify input");
        }
    }

    @Override
    public List<ItemDto> convertToEntityAttribute(String json) {
        try {
            if (json == null) {
                return null;
            }
            return objectMapper.readValue(json, new TypeReference<List<ItemDto>>() {});
        } catch (JsonProcessingException e) {
            throw new BadRequestException("The receipt is invalid. Please verify input");
        }
    }
}