package com.email;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TaskMessage{
	
	private String emailId;

	@JsonCreator
	public TaskMessage(@JsonProperty("emailId") String emailId) {
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

}
