package de.sqlgenerator;

public class Table implements SqlObject {

	private final String tableName;
	private String alias;
	
	public Table(String tableName) {
		this.tableName = tableName;
	}
	
	public Table(String tableName, String alias) {
		this.tableName = tableName;
		this.alias = alias;
	}

	@Override
	public String toSQL() {
		if (this.alias == null) {
			return tableName;
		} 
		return tableName + " " + alias;
	}
	
	
}
