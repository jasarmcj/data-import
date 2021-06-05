package com.data.imprt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.data.imprt.entity.Book;

/**
 * 
 * @author jasar
 *
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
