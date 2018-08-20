package com.capgemini.exceptions;

public class ObjectNotExistException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 254238332882651504L;

	public ObjectNotExistException() {
		super("Object not exist in database!");
	}

	public ObjectNotExistException(String message) {
		super("Object not exist in database! " + message);
	}
}
