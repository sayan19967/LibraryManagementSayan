package com.mywebapp.demo.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebapp.demo.model.Book;
import com.mywebapp.demo.model.User;
import com.mywebapp.demo.service.BookService;

@RestController
public class BookController {
	
	@Autowired
	BookService service;
	
	@GetMapping(path="/books/day/{date}")
	public List<Book> getBooksByDate(@PathVariable("date") String dateStr){
		return service.getBookByDateAvailability(dateStr);
	}
	
	@GetMapping(path="/books/{id}")
	public Book getBookById(@PathVariable("id") int id){
		return service.getBookById(id);
	}
	
	@GetMapping(path="/books")
	public List<Book> getAllBooks(){
		return service.getAllBooks();
	}
	
	@PostMapping(path="/books")
	public Book addBook(@RequestBody Book book){
		return service.addBook(book);
	}
	
	@DeleteMapping(path="/books/{id}")
	public void deleteBook(@PathVariable("id") int id){
		Book book = service.getBookById(id);
		boolean status = service.deleteBook(book);
		if(status) {
			System.out.println("User deleted");
		} else {
			System.out.println("User not found");
		}
		//return obj;
	}

}
