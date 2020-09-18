package com.thoughtworks.basic;

@SuppressWarnings("serial")
public class SchemaException  extends RuntimeException {  
	 public SchemaException() {
	        super();
	    }
	    public SchemaException(String message) {
	        super(message);
	    }
}
