package com.example.demo.service.Impl;

public class InsufficientInventoryException extends RuntimeException {
	public InsufficientInventoryException(String message) {
        super(message);
    }
}
