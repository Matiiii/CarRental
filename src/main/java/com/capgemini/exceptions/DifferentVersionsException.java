package com.capgemini.exceptions;

public class DifferentVersionsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3063201558070221295L;

	public DifferentVersionsException() {
		super("Versions number are not same, probably you try update old version!");
	}

	public DifferentVersionsException(String message) {
		super("Versions number are not same, probably you try update old version! " + message);
	}
}