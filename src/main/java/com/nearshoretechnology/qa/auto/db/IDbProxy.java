package com.nearshoretechnology.qa.auto.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDbProxy {

	void establishConnection(DbConnInfo dbConnInfo) throws SQLException;
	void closeConnection() throws SQLException;
	ResultSet executeQuery(String query) throws SQLException;

}
