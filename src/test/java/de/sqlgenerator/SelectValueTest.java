package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelectValueTest {

	@Test
	@DisplayName("Select value with only a column name")
	void toSql_onlyColumnName() {
		SelectValue value = new SelectValue("firstname");
		assertEquals("firstname", value.toSQL());
	}
	
	@Test
	@DisplayName("Select value with column name and alias")
	void toSql_withAlias() {
		SelectValue value = new SelectValue("firstname", "vorname");
		assertEquals("firstname AS vorname", value.toSQL());
	}
}
