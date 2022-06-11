package de.sqlgenerator.groupby;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.ColumnMockup;

public class GroupByTest {

	private ColumnMockup columnMock = new ColumnMockup();
	
	@Test
	@DisplayName("Testing group by")
	void groupBy() {
		GroupBy groupBy = new GroupBy(columnMock.getColumn_User_age());
		assertEquals("GROUP BY User.age", groupBy.toSQL());
		groupBy.addColumn(columnMock.getColumn_User_firstname());
		assertEquals("GROUP BY User.age, User.firstname", groupBy.toSQL());
		groupBy.addColumn(columnMock.getColumn_User_as_usr_lastname());
		assertEquals("GROUP BY User.age, User.firstname, usr.lastname", groupBy.toSQL());
	}

}
