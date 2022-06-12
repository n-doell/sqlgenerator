package mockup;

import de.sqlgenerator.ComparisonOperator;
import de.sqlgenerator.SqlObject;
import de.sqlgenerator.where.NumberSqlObejct;
import de.sqlgenerator.where.Condition;

public class EqualsMockup {

	private ColumnMockup columnMock = new ColumnMockup();
	
	private Condition createEquals(SqlObject leftSide, SqlObject rightSide) {
		return new Condition(leftSide, ComparisonOperator.EQUALS, rightSide);
	}
	
	public Condition getEquals_AgeEquals10() {
		return createEquals(columnMock.getColumn_User_age(), new NumberSqlObejct(10));
	}
	
	public Condition getEquals_AgeEquals15() {
		return createEquals(columnMock.getColumn_User_age(), new NumberSqlObejct(15));
	}
	
	public Condition getEquals_AgeEquals20() {
		return createEquals(columnMock.getColumn_User_age(), new NumberSqlObejct(20));
	}
}
