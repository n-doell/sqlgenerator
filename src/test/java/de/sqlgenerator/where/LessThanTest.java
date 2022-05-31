package de.sqlgenerator.where;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.ConditionValueMockup;

public class LessThanTest {

private ConditionValueMockup mock = new ConditionValueMockup();
	
	@Test
	@DisplayName("Less than between two columns")
	void toSql_twoColumns() {
		LessThan less = new LessThan(mock.getConditionValue_age(), mock.getConditionValue_firstname());
		assertEquals("age < firstname", less.toSQL());
	}
	
	@Test
	@DisplayName("Less than between column and string")
	void toSql_columnAndString() {
		LessThan less = new LessThan(mock.getConditionValue_firstname(), new StringSqlObject("peter"));
		assertEquals("firstname < 'peter'", less.toSQL());
	}
	
	@Test
	@DisplayName("Less than between column and integer")
	void toSql_columnAndInteger() {
		LessThan less = new LessThan(mock.getConditionValue_age(), new NumberSqlObejct(10));
		assertEquals("age < 10", less.toSQL());
	}
}
