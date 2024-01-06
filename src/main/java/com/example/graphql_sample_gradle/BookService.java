package com.example.graphql_sample_gradle;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class BookService {
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public Book getById(Integer id) {
	    return bookRepository.findById(id).orElse(new Book());
	  }
	

	public List<Book> findAll() {
		return bookRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
	}
}
