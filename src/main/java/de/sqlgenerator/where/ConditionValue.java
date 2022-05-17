package de.sqlgenerator.where;

import de.sqlgenerator.SqlObject;

public class ConditionValue implements SqlObject {

	private String column;
	
	public ConditionValue(String column) {
		this.column = column;
	}

	@Override
	public String toSQL() {
		return column;
	}
	
	
}
