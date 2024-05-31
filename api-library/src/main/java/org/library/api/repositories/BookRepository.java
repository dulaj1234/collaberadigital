package org.library.api.repositories;

import java.util.List;

import org.library.api.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

	public List<Book> findByISBN(String ISBN);
}
