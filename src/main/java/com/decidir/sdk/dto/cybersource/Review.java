package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Review implements Serializable {

	private Date date;
	private String reviewer;
	private List<ReviewComments> comments;
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public List<ReviewComments> getComments() {
		return comments;
	}
	public void setComments(List<ReviewComments> comments) {
		this.comments = comments;
	}
}
