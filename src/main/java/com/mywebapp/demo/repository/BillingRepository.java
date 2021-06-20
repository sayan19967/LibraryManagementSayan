package com.mywebapp.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mywebapp.demo.model.Billing;


@Repository
public interface BillingRepository extends JpaRepository<Billing, Integer> {

}
