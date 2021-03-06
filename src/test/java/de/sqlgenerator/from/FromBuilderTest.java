package de.sqlgenerator.from;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import mockup.JoinMockup;
import mockup.TableMockup;

public class FromBuilderTest {

	private TableMockup tableMock = new TableMockup();
	private JoinMockup joinMock = new JoinMockup();
	
	@Test
	@DisplayName("From with a single table")
	void singleTable() {
		FromBuilder from = new FromBuilder(tableMock.getTable_User());
		assertEquals("FROM User", from.toSQL());
		from =  new FromBuilder(tableMock.getTable_User_usr());
		assertEquals("FROM User AS usr", from.toSQL());
	}
	
	@Test
	@DisplayName("From with multiple tables but no specific join")
	void multipleTables_noJoin() {
		FromBuilder from = new FromBuilder(tableMock.getTable_User());
		from.addTable(tableMock.getTable_Address_addr());
		assertEquals("FROM User, Address AS addr", from.toSQL());
	}
	
	@Test
	@DisplayName("From with joins")
	void fromWithJoins() {
		FromBuilder from = new FromBuilder(tableMock.getTable_User());
		from.addJoin(joinMock.getLeftJoin_address_user_equals_user_id());
		from.addJoin(joinMock.getRightJoin_order_user_equals_user_id());
		assertEquals("FROM User LEFT JOIN Address ON Address.user = User.id RIGHT JOIN order ON order.user = User.id", from.toSQL());
	}
}
