package de.sqlgenerator.select;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.SelectValueMockup;

public class SelectValueTest {

	private SelectValueMockup selectValueMock = new SelectValueMockup();
	
	@Test
	@DisplayName("Select value with only a column name")
	void toSql_onlyColumnName() {
		SelectValue value = new SelectValue("firstname");
		assertEquals("firstname", value.toSQL());
	}
	
	@Test
	@DisplayName("Select value with column name and alias")
	void toSql_withAlias() {
		SelectValue value = new SelectValue("firstname");
		value.setAlias("vorname");
		assertEquals("firstname AS vorname", value.toSQL());
	}

	@Test
	@DisplayName("Count select value")
	void toSql_withCountFunction() {
		SelectValue value = selectValueMock.getSelectValue_lastname_countFunction();
		assertEquals("COUNT(lastname)", value.toSQL());
		value.setAlias("nachname");
		assertEquals("COUNT(lastname) AS nachname", value.toSQL());
	}
	
	@Test
	@DisplayName("Average select value")
	void toSql_withAverageFunction() {
		SelectValue value = selectValueMock.getSelectValue_age_avgFunction();
		assertEquals("AVG(age)", value.toSQL());
		value.setAlias("avg-age");
		assertEquals("AVG(age) AS avg-age", value.toSQL());
	}
	
	@Test
	@DisplayName("Sum select value")
	void toSql_withSumFunction() {
		SelectValue value = selectValueMock.getSelectValue_debt_sumFunction();
		assertEquals("SUM(debt)", value.toSQL());
		value.setAlias("DEBT");
		assertEquals("SUM(debt) AS DEBT", value.toSQL());
	}
	
	@Test
	@DisplayName("Min select value")
	void toSql_withMinFunction() {
		SelectValue value = selectValueMock.getSelectValue_age_minFunction();
		assertEquals("MIN(age)", value.toSQL());
		value.setAlias("lowest");
		assertEquals("MIN(age) AS lowest", value.toSQL());
	}
	
	@Test
	@DisplayName("Max select value")
	void toSql_withMaxFunction() {
		SelectValue value = selectValueMock.getSelectValue_age_maxFunction();
		assertEquals("MAX(age)", value.toSQL());
		value.setAlias("highest");
		assertEquals("MAX(age) AS highest", value.toSQL());
	}
}
