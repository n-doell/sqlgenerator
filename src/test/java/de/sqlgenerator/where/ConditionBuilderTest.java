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
	
	// TODO: Check where-condition gets nested having condition (and the other way around)
	// TODO: factory methods should take first condition on construction --> Avoids empty element or LogicalOperator for first condition (otherwise confusing)
	
	@Test
	@DisplayName("Test single nested condition for where clause")
	void singleNestedConditionWhere() {
		ConditionBuilder nestedCondition = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		
		ConditionBuilder where = ConditionBuilder.createWhereClauseConditionBuilder();
		where.addNestedConditions(nestedCondition, LogicalOperator.AND);
		assertEquals("WHERE (User.age = 10)", where.toSQL());
	}
	
	@Test
	@DisplayName("Test multiple nested conditions on same level for where clause")
	void multipleNestedConditions() {
		ConditionBuilder nestedCondition = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		
		ConditionBuilder nestedCondition2 = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition2.addCondition(equalsMock.getEquals_AgeEquals20(), LogicalOperator.AND);
		
		ConditionBuilder where = ConditionBuilder.createWhereClauseConditionBuilder();
		where.addNestedConditions(nestedCondition, LogicalOperator.AND);
		where.addNestedConditions(nestedCondition2, LogicalOperator.OR);
		assertEquals("WHERE (User.age = 10) OR (User.age = 20)", where.toSQL());
	}
	
	@Test
	@DisplayName("Test nested condition inside nested condition for where clause")
	void nestedConditionInsideNestedCondition() {
		ConditionBuilder nestedCondition = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		
		ConditionBuilder nestedCondition2 = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition2.addCondition(equalsMock.getEquals_AgeEquals20(), LogicalOperator.AND);
		
		ConditionBuilder nestedCondition3 = ConditionBuilder.createWhereClauseConditionBuilder();
		nestedCondition3.addCondition(equalsMock.getEquals_AgeEquals15(), LogicalOperator.AND);
		
		nestedCondition.addNestedConditions(nestedCondition2, LogicalOperator.OR);
		nestedCondition2.addNestedConditions(nestedCondition3, LogicalOperator.OR);
		
		ConditionBuilder where = ConditionBuilder.createWhereClauseConditionBuilder();
		where.addNestedConditions(nestedCondition, LogicalOperator.AND);
		
		assertEquals("WHERE (User.age = 10 OR (User.age = 20 OR (User.age = 15)))", where.toSQL());
	}
	
}
