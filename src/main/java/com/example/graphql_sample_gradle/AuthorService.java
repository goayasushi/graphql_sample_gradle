package com.example.graphql_sample_gradle;

import org.springframework.stereotype.Service;

@Service
public class AuthorService {
	private final AuthorRepository authorRepository;

	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}
	
	public Author getById(Integer id) {
	    return authorRepository.findById(id).orElse(new Author());
	  }
}
