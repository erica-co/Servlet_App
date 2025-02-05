package com.winter.app.tests.connection;

import java.sql.Connection;

import com.winter.app.utils.DBConnection;

public class DBConnectionTest {

	public static void main(String[] args) {
		try {
			Connection con = DBConnection.getConnection();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
