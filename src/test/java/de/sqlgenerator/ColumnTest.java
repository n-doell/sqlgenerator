package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.ColumnMockup;

public class ColumnTest {

	ColumnMockup columnMock = new ColumnMockup();
	
	@Test
	@DisplayName("Column to SQL: Table has no alias") 
	void tableWithoutAlias() {
		Column column = columnMock.getColumn_User_firstname();
		assertEquals("User.firstname", column.toSQL());
	}
	
	@Test
	@DisplayName("Column to SQL: Table with alias")
	void tableWithAlias() {
		Column column = columnMock.getColumn_User_as_usr_lastname();
		assertEquals("usr.lastname", column.toSQL());
	}
}
