package com.example.spring.TodoApplication.Todo;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Size;


public class Todo {

	private long id;
	private String username;
	@Size(min=10, message="Enter at least 10 characters")
	private String description;
	
	@DateTimeFormat(pattern="yyyy/MM/dd")
	private LocalDate targetdate;
	private boolean isdone;

	public Todo(long id, String username, String description, LocalDate targetdate, boolean isdone) { 
		super();
		this.id = id;
		this.username = username;
		this.description = description;
		this.targetdate = targetdate;
		this.isdone = isdone;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getTargetdate() {
		return targetdate;
	}

	public void setTargetdate(LocalDate targetdate) {
		this.targetdate = targetdate;
	}

	public boolean isIsdone() {
		return isdone;
	}

	public void setIsdone(boolean isdone) {
		this.isdone = isdone;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", description=" + description + ", targetdate="
				+ targetdate + ", isdone=" + isdone + "]";
	}

}
