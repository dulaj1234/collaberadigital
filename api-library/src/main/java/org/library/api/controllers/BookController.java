package org.library.api.controllers;

import org.library.api.dtos.BookDTO;
import org.library.api.dtos.BorrowReturnDTO;
import org.library.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;

	@PostMapping("/register-book")
	public ResponseEntity<?> registerBook(@RequestBody BookDTO bookDTO) {
		return bookService.registerBook(bookDTO);
	}

	@GetMapping("/list-all-book")
	public ResponseEntity<?> listAllBook() {
		return bookService.listAllBook();
	}

	@PutMapping("/borrow")
	private ResponseEntity<?> borrowBook(@RequestBody BorrowReturnDTO borrowReturnDTO) {
		return bookService.borrowBook(borrowReturnDTO);
	}

	@PutMapping("/return")
	private ResponseEntity<?> returnBook(@RequestBody BorrowReturnDTO borrowReturnDTO) {
		return bookService.returnBook(borrowReturnDTO);
	}

}
