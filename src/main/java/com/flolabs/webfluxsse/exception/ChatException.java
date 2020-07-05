package com.flolabs.webfluxsse.exception;

public class ChatException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	private String message;

	public ChatException(String message) {
		super(message);

	}
}
