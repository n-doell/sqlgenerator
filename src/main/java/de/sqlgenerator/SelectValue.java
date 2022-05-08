package de.sqlgenerator;

public class SelectValue implements SqlObject {

	private final String columnName;
	
	public SelectValue(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String toSQL() {
		return this.columnName;
	}
	
	
}
