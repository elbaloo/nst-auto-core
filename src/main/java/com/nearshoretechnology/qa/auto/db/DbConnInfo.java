package com.nearshoretechnology.qa.auto.db;

public class DbConnInfo {

	//jdbc:jtds:sqlserver://DB-01.nearshoretechnology.com:1433/DbName;instance=InstanceName
	private final String csSSOTemplate = "jdbc:jtds:sqlserver://%s:%s/%s;instance=%s";
	private final String csNonSSOTemplate = "jdbc:jtds:sqlserver://%s:%s/%s;instance=%s;user=%s;password=%s";
	public String Host;
	public String Port;
	public String Database;
	public String Instance;
	public String Username;
	public String Password;

	public DbConnInfo(String host, String port, String database, String instance) {
		Host = host;
		Port = port;
		Database = database;
		Instance = instance;
	}

	@Override
	public String toString() {
		String s;

		if(Username != null && Password != null)
			s = String.format(csNonSSOTemplate, Host, Port, Database, Instance, Username, Password);
		else
			s = String.format(csSSOTemplate, Host, Port, Database, Instance);

		return s;
	}

}
