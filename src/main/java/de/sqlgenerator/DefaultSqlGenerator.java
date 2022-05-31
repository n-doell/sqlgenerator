package de.sqlgenerator;

import java.util.StringJoiner;

import de.sqlgenerator.select.SelectListBuilder;
import de.sqlgenerator.select.SelectValue;
import de.sqlgenerator.where.ConditionBuilder;
import de.sqlgenerator.where.LogicalOperator;
import de.sqlgenerator.where.WhereClause;

public class DefaultSqlGenerator {

	private Table rootTable;
	private SelectListBuilder selectList = new SelectListBuilder();
	private ConditionBuilder where = new ConditionBuilder();
	
	public DefaultSqlGenerator(Table rootTable) {
		this.rootTable = rootTable;
	}
	
	public void addSelectValue(SelectValue value) {
		selectList.addSelectValue(value);
	}
	
	public void addWhereClause(WhereClause clause, LogicalOperator operator) {
		where.addCondition(clause, operator);
	}
	
	public String generate() {
		StringJoiner statement = new StringJoiner(" ");
		statement.add(selectList.toSQL());
		statement.add(generateFrom());
		statement.add(where.toSQL());
		
		return statement.toString().trim();
	}
	
	private String generateFrom() {
		return SqlConst.FROM + " " + rootTable.toSQL();
	}
}
