package com.data.imprt.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.data.imprt.entity.Book;
import com.data.imprt.repository.BookRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author jasar
 *
 */
@Slf4j
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void importBooks(List<Book> books) {
		
		log.info("Saving {} records to database", books.size());
		bookRepository.saveAll(books);
	}
	
	
}
