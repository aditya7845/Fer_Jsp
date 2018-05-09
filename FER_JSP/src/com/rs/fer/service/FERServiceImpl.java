package com.rs.fer.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.bean.Address;
import com.rs.fer.bean.Expense;
import com.rs.fer.bean.PersonalInfo;
import com.rs.fer.bean.User;

public class FERServiceImpl implements FERService {

	@Override
	public boolean login(String usernamre, String password) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean loginFlag = false;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("select*from user where username=? and password=?");

			preparedStatement.setString(1, usernamre);
			preparedStatement.setString(2, password);

			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				loginFlag = true;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return loginFlag;

	}

	@Override
	public boolean registration(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean registrationFlag = false;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement(
					"insert into user (firstname, middlename, lastname, emailid, username, password, mobile) values(?,?,?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstname());
			preparedStatement.setString(2, user.getMiddlename());
			preparedStatement.setString(3, user.getLastname());
			preparedStatement.setString(4, user.getEmailid());
			preparedStatement.setString(5, user.getUsername());
			preparedStatement.setString(6, user.getPassword());
			preparedStatement.setString(7, user.getMobile());

			int noOfInsertedItem = preparedStatement.executeUpdate();
			System.out.println(noOfInsertedItem);
			registrationFlag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return registrationFlag;
	}

	@Override
	public boolean addExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean addExpenseFlag = false;

		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement(
					"insert into expense(expensetype, date, price, numberofitems, total, bywhom ) values(?,?,?,?,?,?)");
			p.setString(1, expense.getExpensetype());
			p.setString(2, expense.getDate());
			p.setInt(3, expense.getPrice());
			p.setInt(4, expense.getNumberofitems());
			p.setInt(5, expense.getTotal());
			p.setString(6, expense.getBywhom());
			// p.setString(7, expense.getRemarks());

			int noOfUpdatedItems = p.executeUpdate();
			System.out.println(noOfUpdatedItems);
			addExpenseFlag = noOfUpdatedItems > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return addExpenseFlag;
	}

	@Override
	public boolean deleteExpense(int id) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean deleteExpenseFlag = false;

		try {
			connection = DBUtil.getConnection();

			p = connection.prepareStatement("delete from expense where id=?");

			p.setInt(1, id);
			int deletedId =p.executeUpdate();

			System.out.println(deletedId);
			deleteExpenseFlag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return deleteExpenseFlag;
	}

	@Override
	public boolean editExpense(Expense expense) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean editExpenseFlag = false;

		try {
			connection = DBUtil.getConnection();

			p = connection.prepareStatement(
					"update expense set expensetype=?, date=?, price=?, numberofitems=?, total=?, bywhom=? where id=?");

			p.setString(1, expense.getExpensetype());
			p.setString(2, expense.getDate());
			p.setInt(3, expense.getPrice());
			p.setInt(4, expense.getNumberofitems());
			p.setInt(5, expense.getTotal());
			p.setString(6, expense.getBywhom());
			p.setInt(7, expense.getId());

			int updateditemss = p.executeUpdate();
			System.out.println(updateditemss);

			editExpenseFlag = true;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return editExpenseFlag;
	}

	@Override
	public Expense getExpense(int expenseid) {
		Connection connection = null;
		PreparedStatement p = null;
		Expense expensseObject = null;
		ResultSet resultset = null;

		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement("select * from expense where id=?");

			p.setInt(1, expenseid);
			resultset = p.executeQuery();

			while (resultset.next()) {
				expensseObject = new Expense();
				expensseObject.setId(resultset.getInt("id"));
				expensseObject.setExpensetype(resultset.getString("expenseType"));
				expensseObject.setPrice(resultset.getInt("price"));
				expensseObject.setNumberofitems(resultset.getInt("numberofitems"));
				expensseObject.setTotal(resultset.getInt("total"));
				expensseObject.setBywhom(resultset.getString("bywhom"));
				expensseObject.setDate(resultset.getString("date"));

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

		return expensseObject;
	}

	@Override
	public List<Expense> getExpenseReport(String expensetype, String fromdate, String todate) {
		Connection connection = null;
		PreparedStatement p = null;
		List<Expense> expenses = new ArrayList<Expense>();
		ResultSet resultset = null;

		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement("select * from expense where expensetype=? and date between ? and ? ");
			p.setString(1, expensetype);
			p.setString(2, fromdate);
			p.setString(3, todate);

			resultset = p.executeQuery();

			Expense expense = null;

			while (resultset.next()) {
				expense = new Expense();

				expense.setExpensetype(resultset.getString("expensetype"));
				expense.setDate(resultset.getString("date"));
				expense.setPrice(resultset.getInt("price"));
				expense.setNumberofitems(resultset.getInt("numberofitems"));
				expense.setTotal(resultset.getInt("total"));
				expense.setBywhom(resultset.getString("bywhom"));
				// expense.setRemarks(resultset.getString("remarks"));
				expense.setId(resultset.getInt("id"));

				expenses.add(expense);
				System.out.println(expense.getBywhom());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public List<Expense> getExpenses() {
		Connection connection = null;
		PreparedStatement p = null;
		List<Expense> expenses = new ArrayList<Expense>();
		ResultSet resultset = null;
		Expense expense = null;
		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement("select * from expense");
			resultset = p.executeQuery();

			while (resultset.next()) {

				expense = new Expense();
				expense.setExpensetype(resultset.getString("expensetype"));
				expense.setDate(resultset.getString("date"));
				expense.setPrice(resultset.getInt("price"));
				expense.setNumberofitems(resultset.getInt("numberofitems"));
				expense.setTotal(resultset.getInt("total"));
				expense.setBywhom(resultset.getString("bywhom"));
				expense.setId(resultset.getInt("id"));
				// expense.setRemarks(resultset.getString("remarks"));

				System.out.println(
						expense.getExpensetype() + expense.getDate() + expense.getPrice() + expense.getNumberofitems()
								+ expense.getTotal() + expense.getBywhom() + expense.getId() + expense.getRemarks());

				expenses.add(expense);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return expenses;
	}

	@Override
	public boolean resetPassword(String username, String oldPassword, String newPassword) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean resetPasswordFlag = false;

		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement("update user set password=? where username=? and password=?");

			p.setString(1, newPassword);
			p.setString(2, username);
			p.setString(3, oldPassword);

			int resetPassword = p.executeUpdate();
			System.out.println(resetPassword);
			resetPasswordFlag = resetPassword > 0;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}

		return resetPasswordFlag;
	}

	@Override
	public PersonalInfo getPersonalInfo(String username) {
		Connection connection = null;
		PreparedStatement p = null;
		ResultSet resultset = null;
		PersonalInfo info = new PersonalInfo();

		try {
			connection = DBUtil.getConnection();
			p = connection.prepareStatement(
					"select u.*, a.* from user u left join address a on u.id=a.userid where u.username='" + username
							+ "'");
			resultset = p.executeQuery();

			while (resultset.next()) {

				User user = new User();
				user.setId(resultset.getInt(1));
				user.setFirstname(resultset.getString(2));
				user.setMiddlename(resultset.getString(3));
				user.setLastname(resultset.getString(4));
				user.setEmailid(resultset.getString(5));
				user.setUsername(resultset.getString(6));
				user.setPassword(resultset.getString(7));
				user.setMobile(resultset.getString(8));
				// user.setUserid(resultset.getInt(9));

				Address address = new Address();

				address.setId(resultset.getInt(9));
				address.setStreetname(resultset.getString("streetname"));
				address.setTown(resultset.getString("town"));
				address.setCity(resultset.getString("city"));
				address.setState(resultset.getString("state"));
				address.setZip(resultset.getInt("zip"));
				address.setCountry(resultset.getString("country"));
				address.setUserid(resultset.getInt(16));

				info.setAddress(address);
				info.setUser(user);
				if (username.equals(user.getUsername())) {
					return info;
				}

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
		return null;
	}

	@Override
	public boolean updatePersonalInfo(User user, Address address) {
		Connection connection = null;
		PreparedStatement p = null;
		boolean updatePersonalFlag = false;
		boolean isUpdated = false;

		try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			p = connection.prepareStatement(
					"Update user set firstname=?, middlename=?, lastname=?, emailid=?, mobile=? where id=?");

			p.setString(1, user.getFirstname());
			p.setString(2, user.getMiddlename());
			p.setString(3, user.getLastname());
			p.setString(4, user.getEmailid());
			p.setString(5, user.getMobile());
			p.setInt(6, user.getId());

			int updatePersonal = p.executeUpdate();
			System.out.println(updatePersonal);

			if (updatePersonal > 0) {
				int noOfAddOrEditAddress = 0;
				if (address.getId() != 0) {
					p = connection.prepareStatement(
							"update address set streetname=?,town=?,city=?,state=?,zip=?,country=? where id=?");
					p.setString(1, address.getStreetname());
					p.setString(2, address.getTown());
					p.setString(3, address.getCity());
					p.setString(4, address.getState());
					p.setInt(5, address.getZip());
					p.setString(6, address.getCountry());
					p.setInt(7, address.getId());

				} else {
					p = connection.prepareStatement(
							"insert into address (streetname,town,city,state,zip,country) values(?,?,?,?,?,?)");

					p.setString(1, address.getStreetname());
					p.setString(2, address.getTown());
					p.setString(3, address.getCity());
					p.setString(4, address.getState());
					p.setInt(5, address.getZip());
					p.setString(6, address.getCountry());

				}
				noOfAddOrEditAddress = p.executeUpdate();
				System.out.println("updated item= " + noOfAddOrEditAddress);
				if (noOfAddOrEditAddress > 0) {
					isUpdated = true;
				}
				if (isUpdated) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return isUpdated;
	}

	@Override
	public boolean isUsernameAvailable(String username) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		boolean isUsernameAvailabe = true;
		try {
			connection = DBUtil.getConnection();

			preparedStatement = connection.prepareStatement("select * from user where username=?");

			preparedStatement.setString(1, username);

			ResultSet resultset = preparedStatement.executeQuery();
			while (resultset.next()) {
				isUsernameAvailabe = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isUsernameAvailabe;
	}
}
