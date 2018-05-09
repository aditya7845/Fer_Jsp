package com.rs.fer.bean;
public class Expense {

	private String expensetype;
	private String date;
	private int price;
	private int numberofitems;
	private int total;
	private String bywhom;
	private int id;
	private String remarks;

	public String getExpensetype() {
		return expensetype;
	}

	public void setExpensetype(String expensetype) {
		this.expensetype = expensetype;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public String getBywhom() {
		return bywhom;
	}

	public void setBywhom(String bywhom) {
		this.bywhom = bywhom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
