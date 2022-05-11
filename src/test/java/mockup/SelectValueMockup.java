package mockup;

import de.sqlgenerator.select.SelectValue;
import de.sqlgenerator.select.SelectValueFunction;

public class SelectValueMockup {

	private SelectValue createSelectValue(String columnName) {
		return new SelectValue(columnName);
	}
	
	private SelectValue createSelectValue(String columnName, String alias, SelectValueFunction function) {
		SelectValue value = new SelectValue(columnName);
		value.setAlias(alias);
		value.setFunction(function);
		return value;
	}
	
	public SelectValue getSelectValue_firstname() {
		return createSelectValue("firstname");
	}
	
	public SelectValue getSelectValue_lastname() {
		return createSelectValue("lastname");
	}
	
	public SelectValue getSelectValue_lastname_nachnameAlias() {
		return createSelectValue("lastname", "nachname", null); 
	}
	
	public SelectValue getSelectValue_lastname_countFunction() {
		return createSelectValue("lastname", null, SelectValueFunction.COUNT);
	}
	
	public SelectValue getSelectValue_age_avgFunction() {
		return createSelectValue("age", null, SelectValueFunction.AVG);
	}
}
