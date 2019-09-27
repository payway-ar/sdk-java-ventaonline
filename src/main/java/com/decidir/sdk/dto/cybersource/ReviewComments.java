package com.decidir.sdk.dto.cybersource;

import java.io.Serializable;
import java.util.Date;

public class ReviewComments implements Serializable {

	private Date date;
	private String reviewer;
	private String comment;
	
	
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
}
