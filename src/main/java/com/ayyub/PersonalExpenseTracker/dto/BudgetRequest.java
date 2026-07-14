package com.ayyub.PersonalExpenseTracker.dto;

import java.time.YearMonth;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Builder
public class BudgetRequest {

	@NotNull(message = "Budget amount is required")
    @DecimalMin(value = "0.0", inclusive = false,
            message = "Budget amount must be greater than 0")
	private Double amount;
	
	@NotNull(message = "Month is required")
    private YearMonth month;
}
