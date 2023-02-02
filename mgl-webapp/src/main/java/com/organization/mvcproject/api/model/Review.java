package com.organization.mvcproject.api.model;

public interface Review {
	
	void setAuthor(String author);
	
	String getAuthor();
	
	void setBody(String body);
	
	String getBody();
	
	void setRating(Integer rating);
	
	Integer getRating();

}
