package mockup;

import de.sqlgenerator.Column;
import de.sqlgenerator.Table;
import de.sqlgenerator.from.Join;
import de.sqlgenerator.from.JoinType;

public class JoinMockup {

	private TableMockup tableMock = new TableMockup();
	private ColumnMockup columnMock = new ColumnMockup();
	
	private Join createJoin(JoinType type, Table tableExpression, Column leftSide, Column rightSide) {
		return new Join(type, tableExpression, leftSide, rightSide);
	}
	
	public Join getLeftJoin_address_user_equals_user_id() {
		return createJoin(JoinType.LEFT_JOIN, tableMock.getTable_Address(), columnMock.getColumn_Address_user(), columnMock.getColumn_User_id());
	}
	
	public Join getRightJoin_address_user_equals_user_id() {
		return createJoin(JoinType.RIGHT_JOIN, tableMock.getTable_Address(), columnMock.getColumn_Address_user(), columnMock.getColumn_User_id());
	}
	
	public Join getInnerJoin_address_user_equals_user_id() {
		return createJoin(JoinType.INNER_JOIN, tableMock.getTable_Address(), columnMock.getColumn_Address_user(), columnMock.getColumn_User_id());
	}
	
	public Join getFullJoin_address_user_equals_user_id() {
		return createJoin(JoinType.FULL_JOIN, tableMock.getTable_Address(), columnMock.getColumn_Address_user(), columnMock.getColumn_User_id());
	}
	
	public Join getRightJoin_order_user_equals_user_id() {
		return createJoin(JoinType.RIGHT_JOIN, tableMock.getTable_Order(), columnMock.getColumn_Order_user(), columnMock.getColumn_User_id());
	}
}
