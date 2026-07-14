package com.ayyub.PersonalExpenseTracker.entity;

import java.time.YearMonth;

import com.ayyub.PersonalExpenseTracker.converter.YearMonthAttributeConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "budgets")
public class Budget {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Double amount;
	
	@Column(nullable = false)
	@Convert(converter = YearMonthAttributeConverter.class)
	private YearMonth month;
	
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
}
