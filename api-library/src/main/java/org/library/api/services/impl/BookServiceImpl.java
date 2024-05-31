package org.library.api.services.impl;

import java.util.List;
import java.util.Optional;

import org.library.api.dtos.BookDTO;
import org.library.api.dtos.BorrowReturnDTO;
import org.library.api.entities.Book;
import org.library.api.entities.Borrower;
import org.library.api.enums.BorrowStatus;
import org.library.api.repositories.BookRepository;
import org.library.api.repositories.BorrowerRepository;
import org.library.api.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	public ResponseEntity<?> registerBook(BookDTO bookDTO) {
		try {
			Book book = new Book();

			book.setISBN(bookDTO.getISBN());
			book.setTitle(bookDTO.getTitle());
			book.setAuthor(bookDTO.getAuthor());
			book.setStatus(BorrowStatus.AVAILABLE);

			book = bookRepository.save(book);

			return new ResponseEntity<>(book, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>("Error occured when registering the book:" + bookDTO.getTitle(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

	@Override
	public ResponseEntity<?> listAllBook() {
		return new ResponseEntity<>(bookRepository.findAll(), HttpStatus.ACCEPTED);
	}

	@Override
	public ResponseEntity<?> borrowBook(BorrowReturnDTO borrowReturnDTO) {

		Book book;
		Optional<Book> optionalBook = bookRepository.findById(borrowReturnDTO.getBookID());

		if (optionalBook.isPresent()) {
			book = optionalBook.get();
		} else {
			return new ResponseEntity<>("Book with ID:" + borrowReturnDTO.getBookID() + " not found!",
					HttpStatus.NOT_FOUND);
		}

		if (book.getStatus().equals(BorrowStatus.BORROWED)) {
			return new ResponseEntity<>("Book with ID:" + borrowReturnDTO.getBookID() + " not available for borrow!",
					HttpStatus.BAD_REQUEST);
		} else {
			Borrower borrower;
			Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowReturnDTO.getBorrowerID());

			if (optionalBorrower.isPresent()) {
				borrower = optionalBorrower.get();
			} else {
				return new ResponseEntity<>("Borrower with ID:" + borrowReturnDTO.getBookID() + " not found!",
						HttpStatus.NOT_FOUND);
			}

			book.setStatus(BorrowStatus.BORROWED);
			book.setBorrower(borrower);

			book = bookRepository.save(book);

			return new ResponseEntity<>(book.getTitle() + " book sucessfully borrowed by " + borrower.getName(),
					HttpStatus.ACCEPTED);
		}

	}

	@Override
	public ResponseEntity<?> returnBook(BorrowReturnDTO borrowReturnDTO) {
		Book book;
		Optional<Book> optionalBook = bookRepository.findById(borrowReturnDTO.getBookID());

		if (optionalBook.isPresent()) {
			book = optionalBook.get();
		} else {
			return new ResponseEntity<>("Book with ID:" + borrowReturnDTO.getBookID() + " not found!",
					HttpStatus.NOT_FOUND);
		}

		Borrower borrower;
		Optional<Borrower> optionalBorrower = borrowerRepository.findById(borrowReturnDTO.getBorrowerID());

		if (optionalBorrower.isPresent()) {
			borrower = optionalBorrower.get();
		} else {
			return new ResponseEntity<>("Borrower with ID:" + borrowReturnDTO.getBookID() + " not found!",
					HttpStatus.NOT_FOUND);
		}

		book.setStatus(BorrowStatus.AVAILABLE);
		book.setBorrower(null);

		book = bookRepository.save(book);

		return new ResponseEntity<>(book.getTitle() + " book sucessfully return by " + borrower.getName(),
				HttpStatus.ACCEPTED);
	}

}
