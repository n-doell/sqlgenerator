package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.SelectValueMockup;

public class SelectListBuilderTest {

	private static final SelectValueMockup selectValueMock = new SelectValueMockup();
	
	@Test
	@DisplayName("Returns '*' when no select value set")
	void toSql_noSelectValue() {
		SelectListBuilder builder = new SelectListBuilder();
		assertEquals("SELECT *", builder.toSQL());
	}
	
	@Test
	@DisplayName("Return single SelectValue")
	void toSql_singleSelectValue() {
		SelectListBuilder builder = new SelectListBuilder();
		SelectValue value = selectValueMock.getSelectValue_firstname();
		builder.addSelectValue(value);
		assertEquals("SELECT firstname", builder.toSQL());
	}
	
	@Test
	@DisplayName("Return multipleSelectValues")
	void toSql_multipleSelectValues() {
		SelectListBuilder builder = new SelectListBuilder();
		SelectValue firstname = selectValueMock.getSelectValue_firstname();
		builder.addSelectValue(firstname);
		SelectValue lastname = selectValueMock.getSelectValue_lastname();
		builder.addSelectValue(lastname);
		assertEquals("SELECT firstname, lastname", builder.toSQL());
	}
}
