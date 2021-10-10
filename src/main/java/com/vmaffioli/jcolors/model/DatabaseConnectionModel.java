package com.vmaffioli.jcolors.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnectionModel {

	public Connection databaseLink;

	public Connection getConnection() {
		String databaseName = "lhr4na88umyds6kt";
		String databaseUser = "";
		String databasePassword = "";
		String url = "jdbc:mysql://grp6m5lz95d9exiz.cbetxkdyhwsb.us-east-1.rds.amazonaws.com/" + databaseName;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			databaseLink = DriverManager.getConnection(url, databaseUser, databasePassword);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return databaseLink;
	}
}