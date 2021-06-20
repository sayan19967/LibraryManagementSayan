package com.mywebapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywebapp.demo.model.Billing;
import com.mywebapp.demo.model.BorrowBook;

@Repository
public interface BorrowBookRepository extends JpaRepository<BorrowBook, Integer> {

}
