package com.nicoletti.hrpayroll.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Payment {
	
	private String name;
	private Double dailyIncome;
	private Integer days;
	
	public double getTotal() {
		return days * dailyIncome;
	}

}
