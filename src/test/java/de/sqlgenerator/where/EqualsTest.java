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
		Equals equals = new Equals(mock.getConditionValue_firstname(), mock.getConditionValue_lastname());
		assertEquals("firstname = lastname", equals.toSQL());
	}
	
	@Test
	@DisplayName("Equals between column and string")
	void toSql_columnAndString() {
		Equals equals = new Equals(mock.getConditionValue_firstname(), new StringSqlObject("peter"));
		assertEquals("firstname = 'peter'", equals.toSQL());
	}
	
	@Test
	@DisplayName("Equals between column and integer")
	void toSql_columnAndInteger() {
		Equals equals = new Equals(mock.getConditionValue_age(), new NumberSqlObejct(20));
		assertEquals("age = 20", equals.toSQL());
	}
}
