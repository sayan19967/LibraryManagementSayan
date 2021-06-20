package com.mywebapp.demo.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class User {
	
	@Id
	private int userid;
	private String userName;
	private String emailId;
	
	//@Autowired
	@OneToMany(targetEntity= BorrowBook.class)
	private List<BorrowBook> myBookings;
	
	//@Autowired
	@OneToMany(targetEntity = Billing.class)
	private List<Billing> myBills;
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public List<BorrowBook> getMyBookings() {
		return myBookings;
	}
	public void setMyBookings(List<BorrowBook> myBookings) {
		this.myBookings = myBookings;
	}
	
	public List<Billing> getMyBills() {
		return myBills;
	}
	public void setMyBills(List<Billing> myBills) {
		this.myBills = myBills;
	}
	public User(int userid, String userName, String emailId, List<BorrowBook> myBookings) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.emailId = emailId;
		this.myBookings = myBookings;
	}
	public User(int userid, String userName, String emailId) {
		super();
		this.userid = userid;
		this.userName = userName;
		this.emailId = emailId;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", userName=" + userName + ", emailId=" + emailId + ", myBookings="
				+ myBookings + ", myBills=" + myBills + "]";
	}
	
	

}
