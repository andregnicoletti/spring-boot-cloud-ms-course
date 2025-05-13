package com.nicoletti.hrpayroll.services;

import org.springframework.stereotype.Service;

import com.nicoletti.hrpayroll.dto.WorkerDTO;
import com.nicoletti.hrpayroll.entities.Payment;
import com.nicoletti.hrpayroll.feignclients.WorkerFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {
	
	private final WorkerFeignClient workerFeignClient;

	public Payment getPayment(long workerId, int days) {
		WorkerDTO worker = workerFeignClient.findById(workerId).getBody();
		return new Payment(worker.name(), worker.dailyIncome(), days);
	}

}
