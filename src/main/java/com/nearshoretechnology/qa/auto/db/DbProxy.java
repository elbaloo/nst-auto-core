package com.nearshoretechnology.qa.auto.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DbProxy implements IDbProxy, AutoCloseable {

	protected DbConnInfo dbConnInfo;
	protected SqlDbProxy sqlDbProxy;

	@Override
	public void establishConnection(DbConnInfo dbConnInfo) throws SQLException {
		this.dbConnInfo = dbConnInfo;
		sqlDbProxy = new SqlDbProxy(dbConnInfo.toString());
	}

	@Override
	public void closeConnection() throws SQLException {
		sqlDbProxy.close();
	}

	@Override
	public ResultSet executeQuery(String query) throws SQLException {
		return sqlDbProxy.executeQuery(query);
	}

	@Override
	public void close() throws SQLException {
		closeConnection();
	}

}
