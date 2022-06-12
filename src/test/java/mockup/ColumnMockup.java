package mockup;

import de.sqlgenerator.Column;
import de.sqlgenerator.SqlFunction;

public class ColumnMockup {

	private TableMockup tableMock = new TableMockup();
		
	public Column getColumn_User_firstname() {
		return new Column("firstname", tableMock.getTable_User());
	}
	
	public Column getColumn_User_lastname() {
		return new Column("lastname", tableMock.getTable_User());
	}
	
	public Column getColumn_User_as_usr_lastname() {
		return new Column("lastname", tableMock.getTable_User_usr());
	}
	
	public Column getColumn_User_age() {
		return new Column("age", tableMock.getTable_User());
	}
	
	public Column getColumn_User_age_count() {
		return new Column("age", tableMock.getTable_User(), SqlFunction.COUNT);
	}
	
	public Column getColumn_User_age_avg() {
		return new Column("age", tableMock.getTable_User(), SqlFunction.AVERAGE);
	}
	
	public Column getColumn_User_age_sum() {
		return new Column("age", tableMock.getTable_User(), SqlFunction.SUM);
	}
	
	public Column getColumn_User_age_min() {
		return new Column("age", tableMock.getTable_User(), SqlFunction.MIN);
	}
	
	public Column getColumn_User_age_max() {
		return new Column("age", tableMock.getTable_User(), SqlFunction.MAX);
	}
	
	public Column getColumn_User_id() {
		return new Column("id", tableMock.getTable_User());
	}
	
	public Column getColumn_User_as_usr_id() {
		return new Column("id", tableMock.getTable_User_usr());
	}
	
	public Column getColumn_Address_user() {
		return new Column("user", tableMock.getTable_Address());
	}
	
	public Column getColumn_Address_as_addr_user() {
		return new Column("user", tableMock.getTable_Address_addr());
	}
	
	public Column getColumn_Order_user() {
		return new Column("user", tableMock.getTable_Order());
	}
}
