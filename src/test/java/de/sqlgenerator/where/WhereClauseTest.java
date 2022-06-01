package de.sqlgenerator.where;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.sqlgenerator.SqlObject;
import mockup.ConditionValueMockup;

public class WhereClauseTest {

	private ConditionValueMockup mock = new ConditionValueMockup();
	
	@Test
	@DisplayName("equals where clause")
	void equals() {
		WhereClause equals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.EQUALS , mock.getConditionValue_lastname());
		assertEquals("firstname = lastname", equals.toSQL());
		
		equals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.EQUALS ,new StringSqlObject("peter"));
		assertEquals("firstname = 'peter'", equals.toSQL());
		
		equals = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.EQUALS , new NumberSqlObejct(20));
		assertEquals("age = 20", equals.toSQL());
	}
	
	@Test
	@DisplayName("less than where clause")
	void lessThan() {
		WhereClause less = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.LESS_THAN, mock.getConditionValue_firstname());
		assertEquals("age < firstname", less.toSQL());
		
		less = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.LESS_THAN, new StringSqlObject("peter"));
		assertEquals("firstname < 'peter'", less.toSQL());
		
		less = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.LESS_THAN, new NumberSqlObejct(10));
		assertEquals("age < 10", less.toSQL());
	}
	
	@Test
	@DisplayName("less or equal where clause")
	void lessOrEqual() {
		WhereClause lessOrEqual = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.LESS_OR_EQUAL, new NumberSqlObejct(10));
		assertEquals("age <= 10", lessOrEqual.toSQL());
		
		lessOrEqual = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.LESS_OR_EQUAL, mock.getConditionValue_lastname());
		assertEquals("firstname <= lastname", lessOrEqual.toSQL());
		
		lessOrEqual = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.LESS_OR_EQUAL, new StringSqlObject("peter"));
		assertEquals("firstname <= 'peter'", lessOrEqual.toSQL());
	}
	
	@Test
	@DisplayName("greater than where clause")
	void greaterThan() {
		WhereClause greaterThan = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.GREATER_THAN, new NumberSqlObejct(10));
		assertEquals("age > 10", greaterThan.toSQL());
		
		greaterThan = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.GREATER_THAN, new StringSqlObject("peter"));
		assertEquals("firstname > 'peter'", greaterThan.toSQL());
		
		greaterThan = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.GREATER_THAN, mock.getConditionValue_lastname());
		assertEquals("firstname > lastname", greaterThan.toSQL());
	}
	
	@Test
	@DisplayName("greater or equals where clause")
	void greaterOrEquals() {
		WhereClause greaterOrEquals = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.GREATER_OR_EQUAL, new NumberSqlObejct(10));
		assertEquals("age >= 10", greaterOrEquals.toSQL());
		
		greaterOrEquals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.GREATER_OR_EQUAL, mock.getConditionValue_lastname());
		assertEquals("firstname >= lastname", greaterOrEquals.toSQL());
		
		greaterOrEquals = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.GREATER_OR_EQUAL, new StringSqlObject("peter"));
		assertEquals("firstname >= 'peter'", greaterOrEquals.toSQL());
	}
	
	@Test
	@DisplayName("Not Equal where clause")
	void notEqual() {
		WhereClause notEqual = new WhereClause(mock.getConditionValue_age(), ComparisonOperator.NOT_EQUAL, new NumberSqlObejct(10));
		assertEquals("age <> 10", notEqual.toSQL());
		
		notEqual = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.NOT_EQUAL, mock.getConditionValue_lastname());
		assertEquals("firstname <> lastname", notEqual.toSQL());
		
		notEqual = new WhereClause(mock.getConditionValue_firstname(), ComparisonOperator.NOT_EQUAL, new StringSqlObject("peter"));
		assertEquals("firstname <> 'peter'", notEqual.toSQL());		
	}
	
	@Test
	@DisplayName("Like where clause")
	void like() {
		WhereClause like = new Like(mock.getConditionValue_age(), new NumberSqlObejct(10));
		assertEquals("age LIKE '10'", like.toSQL());
		
		like = new Like(mock.getConditionValue_firstname(), mock.getConditionValue_lastname());
		assertEquals("firstname LIKE lastname", like.toSQL());
		
		like = new Like(mock.getConditionValue_firstname(), new StringSqlObject("%peter%"));
		assertEquals("firstname LIKE '%peter%'", like.toSQL());
	}
	
	@Test
	@DisplayName("IN where clause")
	void in() {
		List<SqlObject> numberList = Arrays.asList(new NumberSqlObejct(10), new NumberSqlObejct(10.5F), new NumberSqlObejct(1L));
		WhereClause in = new In(mock.getConditionValue_age(), numberList);
		assertEquals("age IN (10,10.5,1)", in.toSQL());
		
		List<SqlObject> stringList = Arrays.asList(new StringSqlObject("abc"), new StringSqlObject("def"), new StringSqlObject("xyz"));
		in = new In(mock.getConditionValue_firstname(), stringList);
		assertEquals("firstname IN ('abc','def','xyz')", in.toSQL());
	}
}
