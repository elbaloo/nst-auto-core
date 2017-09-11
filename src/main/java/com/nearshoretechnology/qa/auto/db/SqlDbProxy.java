package com.nearshoretechnology.qa.auto.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * <p>Provides 'low level' methods to interact with a sql database using java's sql native library. 
 * This class is not intended to be used by client code, but by a wrapper such as an {@link IDbProxy} implementation.</p>
 * <p>Implements {@link AutoCloseable} so it can be used within {@code try(){ //... }} blocks.</p>
 * @author Victor Castillo (victor.castillo@nearshoretechnology.com)
 */
public class SqlDbProxy implements AutoCloseable {

	private Connection connection;
	private Statement statement;

	/**
	 * Initializes a new instance of the {@link SqlDbProxy} class.
	 * @param connectionString the connection string to use to establish the connection.
	 * @throws SQLException
	 */
	public SqlDbProxy(String connectionString) throws SQLException {
		this.statement = null;
		this.connection = DriverManager.getConnection(connectionString);
	}

	/**
	 * Closes the connection used by this proxy.
	 * @throws SQLException
	 */
	public void closeConnection() throws SQLException {
		if(!connection.isClosed())
			connection.close();
	}

	/**
	 * Executes the query statement provided and returns its corresponding {@link ResultSet}.
	 * @param query the query statement to be executed.
	 * @return a {@link ResultSet} holding data produced by the given query.
	 * @throws SQLException
	 */
	public ResultSet executeQuery(String query) throws SQLException {
		statement = connection.createStatement();
		return statement.executeQuery(query);
	}

	@Override
	public void close() throws SQLException {
		closeConnection();
	}

}
