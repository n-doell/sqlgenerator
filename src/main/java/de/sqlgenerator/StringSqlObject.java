package de.sqlgenerator;

public class StringSqlObject implements SqlObject {

	private String value;
	
	public StringSqlObject(String value) {
		this.value = value;
	}
	
	@Override
	public String toSQL() {
		return "'" + value + "'";
	}

	
}
