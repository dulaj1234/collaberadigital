package org.library.api.services;

import org.library.api.dtos.BorrowerDTO;
import org.springframework.http.ResponseEntity;

public interface BorrowerService {
	
	public ResponseEntity<?> registerBorrower(BorrowerDTO borrowerDTO);
	
	
}
