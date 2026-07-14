package com.ayyub.PersonalExpenseTracker.converter;

import java.time.YearMonth;

import jakarta.persistence.AttributeConverter;

public class YearMonthAttributeConverter implements AttributeConverter<YearMonth, String>{

	
	@Override
	public String convertToDatabaseColumn(YearMonth yearMonth) {
		return yearMonth == null ? null : yearMonth.toString();
	}
	
	
	@Override
	public YearMonth convertToEntityAttribute(String dbData) {
		
		return dbData == null ? null : YearMonth.parse(dbData);
	}
}
