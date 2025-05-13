package com.nicoletti.hrpayroll.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nicoletti.hrpayroll.dto.WorkerDTO;
import com.nicoletti.hrpayroll.entities.Payment;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentService {

	@Value("${hr-worker.host}")
	private String workerHost;

	private final RestTemplate restTemplate;

	public Payment getPayment(long workerId, int days) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("id", String.valueOf(workerId));

		String url = workerHost.concat("/workers/{id}");

		WorkerDTO worker = restTemplate.getForObject(url, WorkerDTO.class, uriVariables);

		return new Payment(worker.name(), worker.dailyIncome(), days);
	}

}
