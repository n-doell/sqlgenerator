package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.TableMockup;

class DefaultSqlGeneratorTest {
	
	private TableMockup tableMock = new TableMockup();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Generate a minimal select statement")
	void generate_withRootTable() {
		SelectGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User());
		assertEquals("SELECT * FROM User", generator.generate());
	}
	
	@Test
	@DisplayName("Generate a minimal select statement with table alias")
	void generate_withRootTableAlias() {
		SelectGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User_usr());
		assertEquals("SELECT * FROM User usr", generator.generate());
	}
}
