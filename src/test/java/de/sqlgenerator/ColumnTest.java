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
	
	@Test
	@DisplayName("Column to SQL: SQL-Functions")
	void columnWithSqlFunction() {
		Column countColumn = columnMock.getColumn_User_age_count();
		assertEquals("COUNT(User.age)", countColumn.toSQL());
		
		Column avgColumn = columnMock.getColumn_User_age_avg();
		assertEquals("AVG(User.age)", avgColumn.toSQL());
		
		Column sumColumn = columnMock.getColumn_User_age_sum();
		assertEquals("SUM(User.age)", sumColumn.toSQL());
	}
}
