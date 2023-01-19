package com.organization.mvcproject.GameTask.model;

public class Review {
	
	/**
	 * TODO 1.0 java object member variable naming convention, 
	 * one member declared here is not object oriented refactor it
	 */
	private String body;
	private String author;
	private Integer rating;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getReviewBody() {
		return body;
	}

	public void setBody(String reviewBody) {
		this.body = reviewBody;
	}
}
