package com.mywebapp.demo.controller;


import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mywebapp.demo.model.BorrowBook;
import com.mywebapp.demo.service.BorrowBookService;

@RestController
public class BorrowBookController {
	
	@Autowired
	BorrowBookService service;
	
	@GetMapping(path="/borrowbook")
	public List<BorrowBook> getAllBorrowBooks(){
		return service.getAllBorrowBooks();
	}
	
	@GetMapping(path="/borrowbook/{id}")
	public BorrowBook getAllBorrowBooks(@PathVariable("id") int id){
		return service.getBorrowBookById(id);
	}
	
	@PostMapping(path="/borrowbook/{bookId}")
	public BorrowBook getBorrowBookById(@RequestBody BorrowBook borrowBook, @PathVariable("bookId") int bookId) { 
		return service.addBorrowBook(borrowBook, bookId);
	}

}
