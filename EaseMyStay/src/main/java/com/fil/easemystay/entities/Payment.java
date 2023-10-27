package com.fil.easemystay.entities;

import jakarta.persistence.Entity;

@Entity
public class Payment {
	int payment_id;
	int amount;
	int book_id;
	String date;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Payment() {
		super();
	}
	public Payment(int payment_id, int amount, int book_id, String date) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.book_id = book_id;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Payment [payment_id=" + payment_id + ", amount=" + amount + ", book_id=" + book_id + ", date=" + date
				+ "]";
	}
}
