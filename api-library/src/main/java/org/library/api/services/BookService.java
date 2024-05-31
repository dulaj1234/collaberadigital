package org.library.api.services;

import org.library.api.dtos.BookDTO;
import org.library.api.dtos.BorrowReturnDTO;
import org.springframework.http.ResponseEntity;

public interface BookService {

	public ResponseEntity<?> registerBook(BookDTO bookDTO);
	
	public ResponseEntity<?> listAllBook();

	public ResponseEntity<?> borrowBook(BorrowReturnDTO borrowReturnDTO);

	public ResponseEntity<?> returnBook(BorrowReturnDTO borrowReturnDTO);
}
