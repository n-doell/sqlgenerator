package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
	void generate_withRootTable() {
		SelectGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User());
		assertEquals("SELECT * FROM User", generator.generate());
	}

}
