package de.sqlgenerator;

public class Column implements SqlObject {

	private String columnName; 
	private Table table;
	
	public Column(String columnName, Table table) {
		super();
		this.columnName = columnName;
		this.table = table;
	}

	@Override
	public String toSQL() {
		String tableName = table.getTableName();
		if (table.getAlias() != null) {
			tableName = table.getAlias();
		}
		return tableName + "." + columnName;
	} 

	
}
