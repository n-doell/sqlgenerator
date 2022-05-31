package de.sqlgenerator.where;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.EqualsMockup;

public class ConditionBuilderTest {
	
	private EqualsMockup equalsMock = new EqualsMockup();
	
	@Test
	@DisplayName("Testing empty builder")
	void emptyBuilder() {
		ConditionBuilder builder = new ConditionBuilder();
		assertEquals("", builder.toSQL());
	}
	
	@Test
	@DisplayName("Test single condition")
	void singleCondition() {
		ConditionBuilder builder = new ConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		assertEquals("WHERE age = 10", builder.toSQL());
	}
	
	@Test
	@DisplayName("Test multiple conditions")
	void multipleConditions() {
		ConditionBuilder builder = new ConditionBuilder();
		builder.addCondition(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		builder.addCondition(equalsMock.getEquals_AgeEquals15(), LogicalOperator.OR);
		builder.addCondition(equalsMock.getEquals_AgeEquals20(), LogicalOperator.AND);
		assertEquals("WHERE age = 10 OR age = 15 AND age = 20", builder.toSQL());
	}
}
