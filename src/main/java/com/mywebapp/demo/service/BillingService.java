package com.mywebapp.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mywebapp.demo.model.Billing;
import com.mywebapp.demo.model.Book;
import com.mywebapp.demo.model.BorrowBook;
import com.mywebapp.demo.model.User;
import com.mywebapp.demo.repository.BillingRepository;
import com.mywebapp.demo.repository.BookRepository;
import com.mywebapp.demo.repository.BorrowBookRepository;
import com.mywebapp.demo.repository.UserRepository;

@Service
public class BillingService {
	
	@Autowired
	BillingRepository billRepo;
	
	@Autowired
	BorrowBookRepository bbRepo;
	
	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	BillingService billingService;
	
	public Billing getBillById(int id) {
		return billRepo.findById(id).orElse(new Billing());
	}
	
	public Billing generateBill(Billing bill, int borrowBookId) {
		BorrowBook bb = bbRepo.findById(borrowBookId).orElse(new BorrowBook());
		bill.setBorrowBook(bb);
		Double billAmount = billingService.getBill(bill, bb);
		bill.setBillAmount(billAmount);
		
		//Increasing book availability count and also changing book availability status if needed
		int bookId = bb.getBook().getId();
		Book book = bookRepo.findById(bookId).orElse(new Book());
		int no_of_available_books = book.getAvailableBooks();
		if(no_of_available_books < 1) {
			book.setAvailableBooks(++no_of_available_books);
			book.setStatus("available");
		} else {
			book.setAvailableBooks(++no_of_available_books);
		}
		//updating user with billing
		User user = userRepo.findById(bb.getUserid()).orElse(new User());
		System.out.println(user);
		user.getMyBills().add(bill);
		System.out.println(user.getMyBills());
		//userRepo.save(user);
		
		return billRepo.save(bill);
	}
	
	public Double getBill(Billing bill, BorrowBook bb) {
		int no_of_days = bb.getNo_Of_Days();
		long diff_in_milli_secs = bill.getReturnDate().getTime() - bb.getBookingDate().getTime();
		int difference_In_Days = (int) (diff_in_milli_secs / (1000 * 60 * 60 * 24)) % 365;
		int late_no_of_days = difference_In_Days - no_of_days;
		Double billAmount = no_of_days * bb.getChargePerDay() + (late_no_of_days + 1) * bill.getFinePerDay();
		System.out.println( "noOfDays:" + no_of_days + ", late_no_of_days: " + late_no_of_days  + ", difference_In_Days: " + difference_In_Days);
		System.out.println("bill amount: " + billAmount);
		
		return billAmount;
	}

}
