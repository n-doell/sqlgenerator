package de.sqlgenerator.where;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.sqlgenerator.LogicalOperator;
import mockup.EqualsMockup;

public class ConditionBuilderTest {
	
	private EqualsMockup equalsMock = new EqualsMockup();
	
	@Test
	@DisplayName("Test empty builder for where clause")
	void emptyWhereBuilder() {
		ConditionBuilder where = ConditionBuilder.createWhereClauseConditionBuilder();
		assertEquals("", where.toSQL());
	}
	
	@Test
	@DisplayName("Test single condition for where clause")
	void singleWhereCondition() {
		ConditionBuilder builder = ConditionBuilder.createWhereClauseConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		assertEquals("WHERE User.age = 10", builder.toSQL());
	}
	
	@Test
	@DisplayName("Test where condition multiple conditions")
	void multipleWhereConditions() {
		ConditionBuilder builder = ConditionBuilder.createWhereClauseConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		builder.addCondition(equalsMock.getEquals_AgeEquals15(), LogicalOperator.OR);
		builder.addCondition(equalsMock.getEquals_AgeEquals20(), LogicalOperator.AND);
		assertEquals("WHERE User.age = 10 OR User.age = 15 AND User.age = 20", builder.toSQL());
	}

	@Test
	@DisplayName("Test empty builder for having")
	void emptyHavingBuilder() {
		ConditionBuilder having = ConditionBuilder.createHavingConditionBuilder();
		assertEquals("", having.toSQL());
	}
	
	@Test
	@DisplayName("Test single condition for having")
	void singleHavingCondition() {
		ConditionBuilder builder = ConditionBuilder.createHavingConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		assertEquals("HAVING User.age = 10", builder.toSQL());
	}
	
	@Test
	@DisplayName("Test multiple conditions for where clause")
	void multipleHavingConditions() {
		ConditionBuilder builder = ConditionBuilder.createHavingConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		builder.addCondition(equalsMock.getEquals_AgeEquals15(), LogicalOperator.OR);
		builder.addCondition(equalsMock.getEquals_AgeEquals20(), LogicalOperator.AND);
		assertEquals("HAVING User.age = 10 OR User.age = 15 AND User.age = 20", builder.toSQL());
	}
}
