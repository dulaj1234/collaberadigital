package org.library.api.controllers;

import org.library.api.dtos.BorrowerDTO;
import org.library.api.services.BorrowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BorrowerController {

	@Autowired
	private BorrowerService borrowerService;

	@PostMapping("/register-borrower")
	public ResponseEntity<?> registerBorrower(@RequestBody BorrowerDTO borrowerDTO) {
		return borrowerService.registerBorrower(borrowerDTO);
	}

}
