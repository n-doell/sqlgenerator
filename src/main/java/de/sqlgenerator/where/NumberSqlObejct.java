package de.sqlgenerator.where;

import de.sqlgenerator.SqlObject;

public class NumberSqlObejct implements SqlObject {

	private String value;
	
	public NumberSqlObejct(Long value) {
		this.value = value.toString();
	}
	
	public NumberSqlObejct(Integer value) {
		this.value = value.toString();
	}
	
	public NumberSqlObejct(Double value) {
		this.value = value.toString();
	}
	
	public NumberSqlObejct(Float value) {
		this.value = value.toString();
	}

	@Override
	public String toSQL() {
		return value;
	}
	
}
