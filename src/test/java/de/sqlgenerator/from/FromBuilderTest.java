package de.sqlgenerator.from;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.TableMockup;

public class FromBuilderTest {

	private TableMockup tableMock = new TableMockup();
	
	@Test
	@DisplayName("From with a single table")
	void singleTable() {
		FromBuilder from = new FromBuilder(tableMock.getTable_User());
		assertEquals("FROM User", from.toSQL());
		from =  new FromBuilder(tableMock.getTable_User_usr());
		assertEquals("FROM User usr", from.toSQL());
	}
	
	@Test
	@DisplayName("From with multiple tables but no specific join")
	void multipleTables_noJoin() {
		FromBuilder from = new FromBuilder(tableMock.getTable_User());
		from.addTable(tableMock.getTable_address_addr());
		assertEquals("FROM User, Address addr", from.toSQL());
	}
}
