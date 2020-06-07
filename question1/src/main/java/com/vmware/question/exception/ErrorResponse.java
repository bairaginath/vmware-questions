package com.vmware.question.exception;

import java.io.Serializable;
import java.util.List;

public class ErrorResponse implements Serializable
{
    
	private static final long serialVersionUID = 1L;

	public ErrorResponse(String message, List<String> details) {
        super();
        this.message = message;
        this.details = details;
    }
 
    private String message;
 
    private List<String> details;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}
 
    
}