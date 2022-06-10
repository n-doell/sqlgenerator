package de.sqlgenerator.from;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.ColumnMockup;
import mockup.TableMockup;

public class JoinTest {

	private TableMockup tableMock = new TableMockup();
	private ColumnMockup columnMock = new ColumnMockup();
	
	@Test
	@DisplayName("Join without aliases")
	void joinWithoutAliases() {
		Join join = new Join(JoinType.LEFT_JOIN, tableMock.getTable_Address(), columnMock.getColumn_User_id(), columnMock.getColumn_Address_user());
		assertEquals("LEFT JOIN Address ON User.id = Address.user", join.toSQL());
	}
	
	@Test
	@DisplayName("Join with aliases")
	void joinWithAliases() {
		Join join = new Join(JoinType.LEFT_JOIN, tableMock.getTable_Address_addr(), columnMock.getColumn_User_as_usr_id(), columnMock.getColumn_Address_as_addr_user());
		assertEquals("LEFT JOIN Address AS addr ON usr.id = addr.user", join.toSQL());
	}
	
	@Test
	@DisplayName("Test different joins")
	void joins() {
		Join leftJoin = new Join(JoinType.LEFT_JOIN, tableMock.getTable_Address(), columnMock.getColumn_User_id(), columnMock.getColumn_Address_user());
		assertEquals("LEFT JOIN Address ON User.id = Address.user", leftJoin.toSQL());
		Join rightJoin = new Join(JoinType.RIGHT_JOIN, tableMock.getTable_Address(), columnMock.getColumn_User_id(), columnMock.getColumn_Address_user());
		assertEquals("RIGHT JOIN Address ON User.id = Address.user", rightJoin.toSQL());
		Join innerJoin = new Join(JoinType.INNER_JOIN, tableMock.getTable_Address(), columnMock.getColumn_User_id(), columnMock.getColumn_Address_user());
		assertEquals("INNER JOIN Address ON User.id = Address.user", innerJoin.toSQL());
		Join fullJoin = new Join(JoinType.FULL_JOIN, tableMock.getTable_Address(), columnMock.getColumn_User_id(), columnMock.getColumn_Address_user());
		assertEquals("FULL JOIN Address ON User.id = Address.user", fullJoin.toSQL());
	}
}
