package de.sqlgenerator.select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AsteriskSelectValueTest {

	@Test
	@DisplayName("Test default select value (*)")
	void toSql_defaultSelectValue() {
		SelectValue value = new AsteriskSelectValue();
		assertEquals("*", value.toSQL());
		value.setFunction(SelectValueFunction.COUNT);
		assertEquals("COUNT(*)", value.toSQL());
		
		
	}
	
	@Test
	@DisplayName("Alias is unsupported for asterisk")
	void setAlias() {
		SelectValue value = new AsteriskSelectValue();
		assertThrows(UnsupportedOperationException.class, () -> {
			value.setAlias("test");
		});
	}
}
