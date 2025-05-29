package me.khs.controller;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import me.khs.dto.ReceiptDto;
import me.khs.service.ReceiptService;

@RestController
@RequestMapping("receipt")
public class ReceiptController {

	private final ReceiptService receiptService;
	
	public ReceiptController (ReceiptService receiptService) {
		
		this.receiptService = receiptService;
		
	}
	
	@PostMapping("/createReceipt")
	public ReceiptDto createReceipt (@RequestParam String shop, @RequestParam Long userId, @RequestParam LocalDate date, @RequestParam Long keywordId) {
		
		ReceiptDto receiptDto = new ReceiptDto(shop, userId, date, keywordId);
		receiptService.createReceipt(receiptDto);
		return receiptDto;
		
	}
	
}
