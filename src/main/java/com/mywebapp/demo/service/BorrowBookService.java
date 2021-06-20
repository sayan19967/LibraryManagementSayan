package com.mywebapp.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebapp.demo.model.Book;
import com.mywebapp.demo.model.BorrowBook;
import com.mywebapp.demo.model.User;
import com.mywebapp.demo.repository.BookRepository;
import com.mywebapp.demo.repository.BorrowBookRepository;
import com.mywebapp.demo.repository.UserRepository;

@Service
public class BorrowBookService {
	
	@Autowired
	BorrowBookRepository bbRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<BorrowBook> getAllBorrowBooks(){
		return bbRepo.findAll();
	}
	
	public BorrowBook getBorrowBookById(int id){
		return bbRepo.findById(id).orElse(new BorrowBook());
	}
	
	public BorrowBook addBorrowBook(BorrowBook bb, int bookId){
		Book book = bookRepo.findById(bookId).orElse(new Book());
		int availableBooks = book.getAvailableBooks();
		if(availableBooks > 0) {
			book.setAvailableBooks(--availableBooks);
			if(availableBooks < 1) {
				book.setStatus("unavailable");
			}
			bb.setBook(book);
			bb = bbRepo.save(bb);
			
			//updating user with borrow book
			User user = userRepo.findById(bb.getUserid()).orElse(new User());
			System.out.println(user);
			//user.getMyBookings().add(bb);
			List<BorrowBook> bb1 = user.getMyBookings();
			System.out.println("before: " + bb1);
			bb1.add(bb);
			System.out.println("after adding: " + bb1);
			user.setMyBookings( bb1 );
			userRepo.save(user);
			
		}
		return bb;
	}

}
