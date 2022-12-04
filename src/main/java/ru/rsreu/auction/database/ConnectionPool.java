package ru.rsreu.auction.database;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
	private static final String DATASOURCE_NAME = "java:/comp/env/jdbc/auction";
	private static Connection connection;


	private ConnectionPool() {
	}

	public static Connection getConnection() {
		synchronized (ConnectionPool.class) {
			if (connection == null) {
				try {
					Context initContext = new InitialContext();
					DataSource dataSource = (DataSource) initContext.lookup(DATASOURCE_NAME);
					connection = dataSource.getConnection();
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}
		}

		return connection;
	}
}
