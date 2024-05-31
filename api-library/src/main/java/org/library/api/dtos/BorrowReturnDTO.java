package org.library.api.dtos;

import jakarta.validation.constraints.NotNull;

public class BorrowReturnDTO {

	@NotNull
	private long borrowerID;

	@NotNull
	private long bookID;

	public long getBorrowerID() {
		return borrowerID;
	}

	public void setBorrowerID(long borrowerID) {
		this.borrowerID = borrowerID;
	}

	public long getBookID() {
		return bookID;
	}

	public void setBookID(long bookID) {
		this.bookID = bookID;
	}

}
