package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;
import com.rs.fer.bean.Address;
import com.rs.fer.bean.User;
import com.rs.fer.service.FERService;
import com.rs.fer.service.FERServiceImpl;

public class UpdatePersonalInfoMain {

	public static void main(String[] args) {

		User user = new User();
		user.setFirstname("robert");
		user.setMiddlename("dwayne");
		user.setLastname("junior");
		user.setEmailid("rj@gmail.com");
		user.setUsername("rbt");
		user.setPassword("ironman123");
		user.setMobile("7870");
		user.setId(11);

		Address address = new Address();
		address.setStreetname("niomi");
		address.setTown("miami");
		address.setCity("malibu");
		address.setState("up");
		address.setZip(787878);
		address.setCountry("oman");

		address.setUserid(" " + user.getId());
		address.setId(10);

	
		FERService ferService=new FERServiceImpl();
		boolean personalInfoFlag=ferService.updatePersonalInfo(user, address);

				if(personalInfoFlag){
					System.out.println("personal info updated successfully");
				}
				else{
					System.out.println("unable to update");
				}
	/*	try {
			connection = DBUtil.getConnection();
			connection.setAutoCommit(false);
			boolean isUpdateed = false;
			p = connection
					.prepareStatement("update user set firstname=?,middlename=?,lastname=?,emailid=?,username=?,password=?,mobile=? where id=?");
			p.setString(1, user.getFirstname());
			p.setString(2, user.getMiddlename());
			p.setString(3, user.getLastname());
			p.setString(4, user.getEmailid());
			p.setString(5, user.getUsername());
			p.setString(6, user.getPassword());
			p.setString(7, user.getMobile());
			p.setInt(8, user.getId());

			int i = p.executeUpdate();
			if (i > 0) {
				int editAddress = 0;
				if (address.getId() == 0)
					;
				{
					p = connection
							.prepareStatement("insert into address (streetname,town,city,state,zip,country,userid) values(?,?,?,?,?,?,?)");
					p.setString(1, address.getStreetname());
					p.setString(2, address.getTown());
					p.setString(3, address.getCity());
					p.setString(4, address.getState());
					p.setInt(5, address.getZip());
					p.setString(6, address.getCountry());
					p.setInt(7, address.getUserid());
					editAddress = p.executeUpdate();
					System.out.println("Update Item=" + editAddress);

				}
			} else {
				p = connection
						.prepareStatement("update address set streetname=?,town=?,city=?,state=?,zip=?,country=? where id=?");
				p.setString(1, address.getStreetname());
				p.setString(2, address.getTown());
				p.setString(3, address.getCity());
				p.setString(4, address.getState());
				p.setInt(5, address.getZip());
				p.setString(6, address.getCountry());

				p.setInt(7, address.getId());

				i = p.executeUpdate();
				System.out.println(i);
			}
			if (i > 0) {
				isUpdateed = true;
			}
			if (isUpdateed) {
				connection.commit();
			} else {
				connection.rollback();
			}
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);
		}
*/
	}}


