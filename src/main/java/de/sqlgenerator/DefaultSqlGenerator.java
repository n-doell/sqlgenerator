package de.sqlgenerator;

import java.util.StringJoiner;

public class DefaultSqlGenerator {

	private static final String DEFAULT_SELECT_LIST = "*";
	private Table rootTable;
	private SelectListBuilder selectList = new SelectListBuilder();
	
	public DefaultSqlGenerator(Table rootTable) {
		this.rootTable = rootTable;
	}
	
	public void addSelectValue(SelectValue value) {
		selectList.addSelectValue(value);
	}
	
	public String generate() {
		StringJoiner statement = new StringJoiner(" ");
		statement.add(selectList.toSQL());
		statement.add(generateFrom());
		return statement.toString();
	}

	private String generateSelectList() {
		return "SELECT " + DEFAULT_SELECT_LIST;
	}
	
	private String generateFrom() {
		return "FROM " + rootTable.toSQL();
	}
}
