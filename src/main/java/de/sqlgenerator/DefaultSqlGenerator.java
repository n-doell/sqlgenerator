package de.sqlgenerator;

import java.util.StringJoiner;

public class DefaultSqlGenerator implements SelectGenerator {

	private static final String DEFAULT_SELECT_LIST = "*";
	private Table rootTable;
	
	public DefaultSqlGenerator(Table rootTable) {
		this.rootTable = rootTable;
	}
	
	public String generate() {
		StringJoiner statement = new StringJoiner(" ");
		statement.add(generateSelectList());
		statement.add(generateFrom());
		return statement.toString();
	}

	private String generateSelectList() {
		return "SELECT " + DEFAULT_SELECT_LIST;
	}
	
	private String generateFrom() {
		return "FROM " + rootTable.tableName;
	}
}
