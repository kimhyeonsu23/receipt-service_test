package me.khs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.khs.dto.ReceiptDto;
import me.khs.entity.ReceiptEntity;
import me.khs.repository.ReceiptRepository;

@Service
public class ReceiptService {

	@Autowired
	private ReceiptRepository receiptRepository;
	
	public ReceiptService(ReceiptRepository receiptRepository) {
		
		this.receiptRepository = receiptRepository;
		
	}
	
	public void createReceipt (ReceiptDto receiptDto) {
		
		System.out.println("keywordID!!!!!!!!!!!!! : " + receiptDto.getKeywordId());
		
		ReceiptEntity receipt = ReceiptEntity.builder()
				.shop(receiptDto.getShop())
				.userId(receiptDto.getUserId())
				.date(receiptDto.getDate())
				.keywordId(receiptDto.getKeywordId())
				.totalPrice(receiptDto.getTotalPrice())
				.build();
		
		receiptRepository.save(receipt);
		
	}
	
}
