package mockup;

import de.sqlgenerator.SqlObject;
import de.sqlgenerator.where.ComparisonOperator;
import de.sqlgenerator.where.NumberSqlObejct;
import de.sqlgenerator.where.WhereClause;

public class EqualsMockup {

	private ConditionValueMockup conditionMock = new ConditionValueMockup();
	
	private WhereClause createEquals(SqlObject leftSide, SqlObject rightSide) {
		return new WhereClause(leftSide, ComparisonOperator.EQUALS, rightSide);
	}
	
	public WhereClause getEquals_AgeEquals10() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(10));
	}
	
	public WhereClause getEquals_AgeEquals15() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(15));
	}
	
	public WhereClause getEquals_AgeEquals20() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(20));
	}
}
