package com.TheVeggieCart.Exception;

public class FeedbackNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
	public FeedbackNotFoundException(String message) {
        super(message);
    }
}

