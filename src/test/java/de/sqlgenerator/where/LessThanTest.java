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
		WhereClause less = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.LESS_THAN, mock.getConditionValue_firstname());
		assertEquals("age < firstname", less.toSQL());
	}
	
	@Test
	@DisplayName("Less than between column and string")
	void toSql_columnAndString() {
		WhereClause less = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.LESS_THAN, new StringSqlObject("peter"));
		assertEquals("firstname < 'peter'", less.toSQL());
	}
	
	@Test
	@DisplayName("Less than between column and integer")
	void toSql_columnAndInteger() {
		WhereClause less = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.LESS_THAN, new NumberSqlObejct(10));
		assertEquals("age < 10", less.toSQL());
	}
}
