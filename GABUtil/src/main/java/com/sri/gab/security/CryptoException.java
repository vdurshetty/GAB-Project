package com.sri.gab.security;

public class CryptoException extends Exception {
	 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String errorMsg;
	
	public CryptoException(String msg) {
		super(msg);
		this.errorMsg = msg;
    }
 
    public CryptoException(String message, Throwable throwable) {
        super(message, throwable);
    }
    
    public String getMessage() {
    	return this.errorMsg;
    }
}