package de.sqlgenerator.groupby;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Month;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import mockup.ColumnMockup;

public class OrderByTest {

	private ColumnMockup columnMock = new ColumnMockup();
	
	@Test
	@DisplayName("Test order by with single and multiple columns")
	void orderBy_columns() {
		OrderBy orderBy = new OrderBy(columnMock.getColumn_User_age(), OrderType.ASC);
		assertEquals("ORDER BY User.age ASC", orderBy.toSQL());
	}
	
	@Test
	@DisplayName("Test order by types")
	void orderBy_types() {
		OrderBy orderBy = new OrderBy(columnMock.getColumn_User_age(), OrderType.ASC);
		assertEquals("ORDER BY User.age ASC", orderBy.toSQL());
		orderBy = new OrderBy(columnMock.getColumn_User_age(), OrderType.DESC);
		assertEquals("ORDER BY User.age DESC", orderBy.toSQL());
	}
}
