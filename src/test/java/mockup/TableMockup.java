package mockup;

import de.sqlgenerator.Table;

public class TableMockup {

	private Table createTable(String tableName) {
		return new Table(tableName);
	}
	
	public Table getTable_User() {
		return createTable("User");
	}
}
