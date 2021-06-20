package com.mywebapp.demo.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebapp.demo.model.Book;
import com.mywebapp.demo.model.User;
import com.mywebapp.demo.repository.BookRepository;
import com.mywebapp.demo.repository.BorrowBookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	@Autowired
	BorrowBookRepository bbRepo;

	public List<Book> getBookByDateAvailability(String dateStr) {
		List<Book> listOfAvailableBooks = new ArrayList<Book>();
		List<Book> listOfAllBooks = bookRepo.findAll();
		for(Book book: listOfAllBooks) {
			if(book.getAvailableBooks() >= 1) {
				listOfAvailableBooks.add(book);
			}
		}
		return listOfAvailableBooks;
	}
	
	public Book getBookById(int id) {
		return bookRepo.findById(id).orElse(new Book());
	}
	
	public List<Book> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public Book addBook(Book book) {
		return bookRepo.save(book);
	}
	
	public boolean deleteBook(Book book) {
		boolean isDeleted = false;
		try {
			if(bookRepo.existsById(book.getId())) {
				bookRepo.delete(book);
				isDeleted = true;
			} 
			
		} catch(Exception e) {
			e.getStackTrace();
		}
		
		return isDeleted;
	}
	
}
