package com.rs.fer.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.rs.fer.DBUtil.DBUtil;

public class AddAddressMain {

	public static void main(String[] args) {
		Connection connection = null;
		PreparedStatement p = null;

		try {

			connection = DBUtil.getConnection();

			p = (PreparedStatement) connection
					.prepareStatement("insert into address values(?,?,?,?,?,?,?,?)");

			p.setInt(1, 10);
			p.setString(2, "haripur");
			p.setString(3, "bonthchhak");
			p.setString(4, "bhadrak");
			p.setString(5, "odisha");
			p.setInt(6, 756116);
			p.setString(7, "india");
			p.setInt(8, 9048);
			int i = p.executeUpdate();
			if (i > 0)
				;

			{
				System.out.println("add address successfully");
			}

			System.out.println(i);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConnection(connection);

		}

	}

}
