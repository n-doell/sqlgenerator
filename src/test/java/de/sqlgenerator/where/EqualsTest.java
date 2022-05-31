package de.sqlgenerator.where;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import mockup.ConditionValueMockup;

public class EqualsTest {

	private ConditionValueMockup mock = new ConditionValueMockup();
	
	@Test
	@DisplayName("Equals between two columns")
	void toSql_twoColumns() {
		WhereClause equals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.EQUALS , mock.getConditionValue_lastname());
		assertEquals("firstname = lastname", equals.toSQL());
	}
	
	@Test
	@DisplayName("Equals between column and string")
	void toSql_columnAndString() {
		WhereClause equals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.EQUALS ,new StringSqlObject("peter"));
		assertEquals("firstname = 'peter'", equals.toSQL());
	}
	
	@Test
	@DisplayName("Equals between column and integer")
	void toSql_columnAndInteger() {
		WhereClause equals = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.EQUALS , new NumberSqlObejct(20));
		assertEquals("age = 20", equals.toSQL());
	}
}
