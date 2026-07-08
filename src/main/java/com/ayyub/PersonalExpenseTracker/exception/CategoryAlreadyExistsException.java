package com.ayyub.PersonalExpenseTracker.exception;

public class CategoryAlreadyExistsException extends RuntimeException{
	
	public CategoryAlreadyExistsException(String message) {
		super(message);
	}
}
