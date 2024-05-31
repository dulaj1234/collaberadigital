package org.library.api.dtos;

import org.library.api.enums.BorrowStatus;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class BookDTO {

	private long id;

	@NotEmpty
	private String title;

	@NotEmpty
	private String author;

	@NotEmpty
	private String ISBN;

	@NotNull
	private BorrowStatus status;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public BorrowStatus getStatus() {
		return status;
	}

	public void setStatus(BorrowStatus status) {
		this.status = status;
	}

}
