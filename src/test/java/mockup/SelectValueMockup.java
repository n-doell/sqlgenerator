package mockup;

import de.sqlgenerator.SelectValue;

public class SelectValueMockup {

	private SelectValue createSelectValue(String columnName) {
		return new SelectValue(columnName);
	}
	
	private SelectValue createSelectValue(String columnName, String alias) {
		return new SelectValue(columnName, alias);
	}
	
	public SelectValue getSelectValue_firstname() {
		return createSelectValue("firstname");
	}
	
	public SelectValue getSelectValue_lastname() {
		return createSelectValue("lastname");
	}
	
	public SelectValue getSelectValue_lastname_nachname() {
		return createSelectValue("lastname", "nachname"); 
	}
}
