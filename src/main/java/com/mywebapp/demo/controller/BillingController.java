package com.mywebapp.demo.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mywebapp.demo.model.Billing;
import com.mywebapp.demo.model.BorrowBook;
import com.mywebapp.demo.service.BillingService;

@RestController
public class BillingController {
	
	@Autowired
	BillingService service;
	
	@GetMapping(path="/billing/getbill/{id}")
	public Billing getBillById(@PathVariable("id") int id) {
		return service.getBillById(id);
	}
	
	@PostMapping(path="/billing/{borrowbookid}")
	public Billing generateBill(@RequestBody Billing bill, @PathVariable("borrowbookid") int bbId) {
		return service.generateBill(bill, bbId);
	}

}
