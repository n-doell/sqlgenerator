package de.sqlgenerator.where;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.sqlgenerator.ComparisonOperator;
import de.sqlgenerator.SqlObject;
import mockup.ColumnMockup;

public class WhereClauseTest {

	private ColumnMockup columnMock = new ColumnMockup();
	
	@Test
	@DisplayName("equals where clause")
	void equals() {
		Condition equals = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.EQUALS , columnMock.getColumn_User_lastname());
		assertEquals("User.firstname = User.lastname", equals.toSQL());
		
		equals = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.EQUALS ,new StringSqlObject("peter"));
		assertEquals("User.firstname = 'peter'", equals.toSQL());
		
		equals = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.EQUALS , new NumberSqlObejct(20));
		assertEquals("User.age = 20", equals.toSQL());
	}
	
	@Test
	@DisplayName("less than where clause")
	void lessThan() {
		Condition less = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.LESS_THAN, columnMock.getColumn_User_firstname());
		assertEquals("User.age < User.firstname", less.toSQL());
		
		less = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.LESS_THAN, new StringSqlObject("peter"));
		assertEquals("User.firstname < 'peter'", less.toSQL());
		
		less = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.LESS_THAN, new NumberSqlObejct(10));
		assertEquals("User.age < 10", less.toSQL());
	}
	
	@Test
	@DisplayName("less or equal where clause")
	void lessOrEqual() {
		Condition lessOrEqual = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.LESS_OR_EQUAL, new NumberSqlObejct(10));
		assertEquals("User.age <= 10", lessOrEqual.toSQL());
		
		lessOrEqual = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.LESS_OR_EQUAL, columnMock.getColumn_User_lastname());
		assertEquals("User.firstname <= User.lastname", lessOrEqual.toSQL());
		
		lessOrEqual = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.LESS_OR_EQUAL, new StringSqlObject("peter"));
		assertEquals("User.firstname <= 'peter'", lessOrEqual.toSQL());
	}
	
	@Test
	@DisplayName("greater than where clause")
	void greaterThan() {
		Condition greaterThan = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.GREATER_THAN, new NumberSqlObejct(10));
		assertEquals("User.age > 10", greaterThan.toSQL());
		
		greaterThan = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.GREATER_THAN, new StringSqlObject("peter"));
		assertEquals("User.firstname > 'peter'", greaterThan.toSQL());
		
		greaterThan = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.GREATER_THAN, columnMock.getColumn_User_lastname());
		assertEquals("User.firstname > User.lastname", greaterThan.toSQL());
	}
	
	@Test
	@DisplayName("greater or equals where clause")
	void greaterOrEquals() {
		Condition greaterOrEquals = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.GREATER_OR_EQUAL, new NumberSqlObejct(10));
		assertEquals("User.age >= 10", greaterOrEquals.toSQL());
		
		greaterOrEquals = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.GREATER_OR_EQUAL, columnMock.getColumn_User_lastname());
		assertEquals("User.firstname >= User.lastname", greaterOrEquals.toSQL());
		
		greaterOrEquals = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.GREATER_OR_EQUAL, new StringSqlObject("peter"));
		assertEquals("User.firstname >= 'peter'", greaterOrEquals.toSQL());
	}
	
	@Test
	@DisplayName("Not Equal where clause")
	void notEqual() {
		Condition notEqual = new Condition(columnMock.getColumn_User_age(), ComparisonOperator.NOT_EQUAL, new NumberSqlObejct(10));
		assertEquals("User.age <> 10", notEqual.toSQL());
		
		notEqual = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.NOT_EQUAL, columnMock.getColumn_User_lastname());
		assertEquals("User.firstname <> User.lastname", notEqual.toSQL());
		
		notEqual = new Condition(columnMock.getColumn_User_firstname(), ComparisonOperator.NOT_EQUAL, new StringSqlObject("peter"));
		assertEquals("User.firstname <> 'peter'", notEqual.toSQL());		
	}
	
	@Test
	@DisplayName("Like where clause")
	void like() {
		Condition like = new Like(columnMock.getColumn_User_age(), new NumberSqlObejct(10));
		assertEquals("User.age LIKE '10'", like.toSQL());
		
		like = new Like(columnMock.getColumn_User_firstname(), columnMock.getColumn_User_lastname());
		assertEquals("User.firstname LIKE User.lastname", like.toSQL());
		
		like = new Like(columnMock.getColumn_User_firstname(), new StringSqlObject("%peter%"));
		assertEquals("User.firstname LIKE '%peter%'", like.toSQL());
	}
	
	@Test
	@DisplayName("IN where clause")
	void in() {
		List<SqlObject> numberList = Arrays.asList(new NumberSqlObejct(10), new NumberSqlObejct(10.5F), new NumberSqlObejct(1L));
		Condition inNumber = new In(columnMock.getColumn_User_age(), numberList);
		assertEquals("User.age IN (10,10.5,1)", inNumber.toSQL());
		
		List<SqlObject> stringList = Arrays.asList(new StringSqlObject("abc"), new StringSqlObject("def"), new StringSqlObject("xyz"));
		Condition inString = new In(columnMock.getColumn_User_firstname(), stringList);
		assertEquals("User.firstname IN ('abc','def','xyz')", inString.toSQL());
		
		List<SqlObject> singleItemList = Arrays.asList(new NumberSqlObejct(10));
		Condition inSingleItem = new In(columnMock.getColumn_User_age(), singleItemList);
		assertEquals("User.age IN (10)", inSingleItem.toSQL());
		
		List<SqlObject> emptyList = new ArrayList<SqlObject>();
		Condition inEmptyList = new In(columnMock.getColumn_User_age(), emptyList);
		assertEquals("User.age IN ()", inEmptyList.toSQL());
	}
	
	@Test
	@DisplayName("BETWEEN where clause")
	void between() {
		Condition betweenInteger = new Between(columnMock.getColumn_User_age(), new NumberSqlObejct(0), new NumberSqlObejct(18));
		assertEquals("User.age BETWEEN 0 AND 18", betweenInteger.toSQL());
		
		Condition betweenString = new Between(columnMock.getColumn_User_firstname(), new StringSqlObject("Andy"), new StringSqlObject("Zoro"));
		assertEquals("User.firstname BETWEEN 'Andy' AND 'Zoro'", betweenString.toSQL());
	}
	
	@Test
	@DisplayName("IS NULL where clause")
	void isNull() {
		Condition isNull = new NullCondition(columnMock.getColumn_User_age());
		assertEquals("User.age IS NULL", isNull.toSQL());
	}
	
	@Test
	@DisplayName("IS NOT NULL where clause")
	void isNotNull() {
		Condition isNotNull = new NotNullCondition(columnMock.getColumn_User_age());
		assertEquals("User.age IS NOT NULL", isNotNull.toSQL());
	}
}
