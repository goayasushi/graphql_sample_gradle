package com.example.graphql_sample_gradle;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

	private final BookService bookService;
	private final AuthorService authorService;
	
	public BookController(BookService bookService, AuthorService authorService) {
		this.bookService = bookService;
		this.authorService = authorService;
	}

	@QueryMapping
	public Book bookById(@Argument Integer id) {
		return bookService.getById(id);
	}

	@QueryMapping
	public List<Book> bookAll() {
		return bookService.findAll();
	}
//
//	// N+1問題
	@SchemaMapping
	public Author author(Book book) {
		return authorService.getById(book.getAuthorId());
	}
}
