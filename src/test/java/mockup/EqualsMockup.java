package mockup;

import de.sqlgenerator.SqlObject;
import de.sqlgenerator.where.Equals;
import de.sqlgenerator.where.NumberSqlObejct;

public class EqualsMockup {

	private ConditionValueMockup conditionMock = new ConditionValueMockup();
	
	private Equals createEquals(SqlObject leftSide, SqlObject rightSide) {
		return new Equals(leftSide, rightSide);
	}
	
	public Equals getEquals_AgeEquals10() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(10));
	}
	
	public Equals getEquals_AgeEquals15() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(15));
	}
	
	public Equals getEquals_AgeEquals20() {
		return createEquals(conditionMock.getConditionValue_age(), new NumberSqlObejct(20));
	}
}
