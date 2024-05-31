package org.library.api.services.impl;

import org.library.api.dtos.BorrowerDTO;
import org.library.api.entities.Borrower;
import org.library.api.repositories.BorrowerRepository;
import org.library.api.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class BorrowerServiceImpl implements BorrowerService {

	@Autowired
	private BorrowerRepository borrowerRepository;

	@Override
	public ResponseEntity<?> registerBorrower(BorrowerDTO borrowerDTO) {
		try {
			Borrower borrower = new Borrower();
			borrower.setName(borrowerDTO.getName());
			borrower.setEmail(borrowerDTO.getEmail());

			borrower = borrowerRepository.save(borrower);

			return new ResponseEntity<>(borrower, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>("Error occured when registering the borrower:" + borrowerDTO.getName(),
					HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}

}
