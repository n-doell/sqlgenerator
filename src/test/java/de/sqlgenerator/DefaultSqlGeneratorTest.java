package de.sqlgenerator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.sqlgenerator.where.LogicalOperator;
import mockup.EqualsMockup;
import mockup.SelectValueMockup;
import mockup.TableMockup;

class DefaultSqlGeneratorTest {
	
	private TableMockup tableMock = new TableMockup();
	private SelectValueMockup selectValueMock = new SelectValueMockup();
	private EqualsMockup equalsMock = new EqualsMockup();
	
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	@DisplayName("Generate a minimal select statement")
	void generate_withRootTable() {
		DefaultSqlGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User());
		assertEquals("SELECT * FROM User", generator.generate());
	}
	
	@Test
	@DisplayName("Generate a minimal select statement with table alias")
	void generate_withRootTableAlias() {
		DefaultSqlGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User_usr());
		assertEquals("SELECT * FROM User usr", generator.generate());
	}

	@Test
	@DisplayName("Generate with select values")
	void generate_withSelectValues() {
		DefaultSqlGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User());
		generator.addSelectValue(selectValueMock.getSelectValue_firstname());
		generator.addSelectValue(selectValueMock.getSelectValue_lastname_nachnameAlias());
		assertEquals("SELECT firstname, lastname AS nachname FROM User", generator.generate());
	}
	
	@Test
	@DisplayName("generate with where clauses")
	void generate_withWhereClause() {
		DefaultSqlGenerator generator = new DefaultSqlGenerator(tableMock.getTable_User());
		assertEquals("SELECT * FROM User", generator.generate());
		generator.addWhereClause(equalsMock.getEquals_AgeEquals10(), LogicalOperator.AND);
		assertEquals("SELECT * FROM User WHERE age = 10", generator.generate());
	}
}
