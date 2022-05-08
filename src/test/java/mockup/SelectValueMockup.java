package mockup;

import de.sqlgenerator.SelectValue;

public class SelectValueMockup {

	private SelectValue createSelectValue(String columnName) {
		return new SelectValue(columnName);
	}
	
	public SelectValue getSelectValue_firstname() {
		return createSelectValue("firstname");
	}
	
	public SelectValue getSelectValue_lastname() {
		return createSelectValue("lastname");
	}
}
