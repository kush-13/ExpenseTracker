package com.expense.tracker.Exceptions;

public class NoSuchUserException extends Exception{
	
	private static String errorMessage;

	public NoSuchUserException(String errorMessage) {
		super(errorMessage);
	}

}
