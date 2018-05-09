package com.rs.fer.service;

import java.util.List;

import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public interface FERService {

	boolean login(String username, String password);

	boolean registration(User user);
	// boolean AddUser(User user);

	boolean addExpense(Expense expense);

	boolean deleteExpense(int id);

	boolean editExpense(Expense expense);

	Expense getExpense(int expenseid);

	List<Expense> getExpenseReport(String expensetype, String fromdate, String todate);

	List<Expense> getExpenses();

	boolean resetPassword(String username, String oldPassword, String newPassword);

	PersonalInfo getPersonalInfo(String username);

	boolean updatePersonalInfo(User user, Address address);
	
	boolean isUsernameAvailable(String username);
}