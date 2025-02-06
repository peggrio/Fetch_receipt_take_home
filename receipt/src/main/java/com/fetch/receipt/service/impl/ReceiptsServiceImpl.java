package com.fetch.receipt.service.impl;

import com.fetch.receipt.dto.ItemDto;
import com.fetch.receipt.dto.ReceiptDto;
import com.fetch.receipt.entity.Receipt;
import com.fetch.receipt.exception.ReceiptAlreadyExistsException;
import com.fetch.receipt.mapper.ReceiptsMapper;
import com.fetch.receipt.repository.ReceiptRepository;
import com.fetch.receipt.service.IReceiptsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class ReceiptsServiceImpl implements IReceiptsService {

    private ReceiptRepository receiptRepository;
    /**
     * @param receiptDto - the receipt to be created
     */
    @Override
    public String createReceipt(ReceiptDto receiptDto) {

        Receipt receipt = ReceiptsMapper.mapToReceipt(receiptDto, new Receipt());

        //generate an UUID
        String newId = UUID.randomUUID().toString();
        receipt.setReceiptId(newId);

        //get the points
        Double points = calculatePoints(receiptDto);
        receipt.setPoints(points);

//        //check if the receipt already exists by looking up the content
//        receiptRepository.findByContent(receiptDto.getContent()).ifPresent(receipt1 -> {
//            throw new ReceiptAlreadyExistsException("Receipt already exists");
//        });

        Receipt savedReceipt = receiptRepository.save(receipt);

        return savedReceipt.getReceiptId();
    }

    public double calculatePoints(ReceiptDto receiptDto){

        String retailer = receiptDto.getRetailer();
        double total = receiptDto.getTotal();
        List<ItemDto> items_list= receiptDto.getItems();
        double points = 0;


        // Rule 1: One point for every alphanumeric character in the retailer name
        points += retailer.replaceAll("[^A-Za-z0-9]", "").length();

        // Rule 2: 50 points if the total is a round dollar amount
        BigDecimal total_round = new BigDecimal(total);
        if (total_round.remainder(BigDecimal.ONE).compareTo(BigDecimal.ZERO) == 0) {
            points += 50;
        }

        // Rule 3: 25 points if the total is a multiple of 0.25
        BigDecimal quarterValue = new BigDecimal("0.25");
        if (total_round.remainder(quarterValue).compareTo(BigDecimal.ZERO) == 0) {
            points += 25;
        }
        for(int i = 0;i < items_list.size(); i++){
            System.out.println("description: " + items_list.get(i).getShortDescription());
            System.out.println("price: "+ items_list.get(i).getPrice());
        }


//        // Rule 4: 5 points for every two items
//        points += (receipt.getItems().size() / 2) * 5;

        return points;
    }


}
