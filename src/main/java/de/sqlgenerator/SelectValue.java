package de.sqlgenerator;

public class SelectValue implements SqlObject {

	private static final String AS = "AS";
	
	private final String columnName;
	private String alias;
	
	public SelectValue(String columnName) {
		this.columnName = columnName;
	}
	
	public SelectValue(String columnName, String alias) {
		this.columnName = columnName;
		this.alias = alias;
	}

	@Override
	public String toSQL() {
		if (alias == null) {
			return columnName;	
		}
		return columnName + " " + AS + " " + alias;
	}
	
	
}
