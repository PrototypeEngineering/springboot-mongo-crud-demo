package com.pe.mongo.engine.exception;

public class MongoDataNotFoundException extends Exception {
  
	private static final long serialVersionUID = 1L;

	public MongoDataNotFoundException(String message) {
        super(message);
    }
}
