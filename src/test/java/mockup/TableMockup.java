package mockup;

import de.sqlgenerator.Table;

public class TableMockup {

	private Table createTable(String tableName) {
		return new Table(tableName);
	}
	
	private Table createTable(String tableName, String alias) {
		return new Table(tableName, alias);
	}
	
	public Table getTable_User() {
		return createTable("User");
	}

	public Table getTable_User_usr() {
		return createTable("User", "usr");
	}
}
