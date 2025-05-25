package me.khs.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.khs.dto.ReceiptDto;
import me.khs.service.ReceiptService;

@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
@RestController
@RequestMapping("receipt")
public class ReceiptController {

	private final ReceiptService receiptService;
	
	public ReceiptController (ReceiptService receiptService) {
		
		this.receiptService = receiptService;
		
	}
	
	@PostMapping("/createReceipt")
	public ReceiptDto createReceipt (@RequestBody ReceiptDto receiptDto) {
		
		System.out.println("keywordID!!!!!!!!!!!!! : " + receiptDto.getKeywordId());
		//ReceiptDto receiptDto = new ReceiptDto(shop, userId, date, keywordId, totalPrice);
		receiptService.createReceipt(receiptDto);
		return receiptDto;
		
	}
	
}
