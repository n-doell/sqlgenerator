package mockup;

import de.sqlgenerator.Column;
import de.sqlgenerator.Table;

public class ColumnMockup {

	private TableMockup tableMock = new TableMockup();
	
	private Column createColumn(Table table, String columnName) {
		return new Column(columnName, table);
	}
	
	public Column getColumn_User_firstname() {
		return createColumn(tableMock.getTable_User(), "firstname");
	}
	
	public Column getColumn_User_lastname() {
		return createColumn(tableMock.getTable_User(), "lastname");
	}
	
	public Column getColumn_User_as_usr_lastname() {
		return createColumn(tableMock.getTable_User_usr(), "lastname");
	}
	
	public Column getColumn_User_age() {
		return createColumn(tableMock.getTable_User(), "age");
	}
	
	public Column getColumn_User_id() {
		return createColumn(tableMock.getTable_User(), "id");
	}
	
	public Column getColumn_User_as_usr_id() {
		return createColumn(tableMock.getTable_User_usr(), "id");
	}
	
	public Column getColumn_Address_user() {
		return createColumn(tableMock.getTable_address(), "user");
	}
	
	public Column getColumn_Address_as_addr_user() {
		return createColumn(tableMock.getTable_address_addr(), "user");
	}
}
