package org.library.api.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class BorrowerDTO {

	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	@Email
	private String email;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
