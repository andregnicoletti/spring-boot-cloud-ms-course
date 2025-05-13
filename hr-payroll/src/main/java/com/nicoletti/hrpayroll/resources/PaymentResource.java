package com.nicoletti.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nicoletti.hrpayroll.entities.Payment;
import com.nicoletti.hrpayroll.services.PaymentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/payments")
public class PaymentResource {
	
	private final PaymentService paymentService;

	@GetMapping("/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable Long workerId,
											  @PathVariable Integer days){
		Payment payment = paymentService.getPayment(workerId, days);
		return ResponseEntity.ok(payment);
	}
	
}
