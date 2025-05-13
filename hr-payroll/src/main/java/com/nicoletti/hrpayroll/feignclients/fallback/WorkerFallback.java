package com.nicoletti.hrpayroll.feignclients.fallback;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.nicoletti.hrpayroll.dto.WorkerDTO;
import com.nicoletti.hrpayroll.feignclients.WorkerFeignClient;

@Component
public class WorkerFallback implements WorkerFeignClient {

	@Override
	public ResponseEntity<WorkerDTO> findById(Long id) {
		WorkerDTO dto = new WorkerDTO(id, "Fallback worker", 0.0);
		return ResponseEntity.status(HttpStatus.SC_REQUEST_TIMEOUT).body(dto);
	}

}
