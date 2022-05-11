package de.sqlgenerator;

import java.util.StringJoiner;

import de.sqlgenerator.select.SelectValue;
import de.sqlgenerator.select.SelectListBuilder;

public class DefaultSqlGenerator {

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
	
	private String generateFrom() {
		return SqlConst.FROM + " " + rootTable.toSQL();
	}
}
