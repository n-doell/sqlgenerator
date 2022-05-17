package mockup;

import de.sqlgenerator.where.ConditionValue;

public class ConditionValueMockup {

	private ConditionValue createConditionValue(String column) {
		return new ConditionValue(column);
	}
	
	public ConditionValue getConditionValue_firstname() {
		return createConditionValue("firstname");
	}
	
	public ConditionValue getConditionValue_lastname() {
		return createConditionValue("lastname");
	}
	
	public ConditionValue getConditionValue_age() {
		return createConditionValue("age");
	}
}
