package de.sqlgenerator;

import java.util.StringJoiner;

import de.sqlgenerator.condition.Condition;
import de.sqlgenerator.select.SelectListBuilder;
import de.sqlgenerator.select.SelectValue;
import de.sqlgenerator.where.ConditionBuilder;

public class DefaultSqlGenerator {

	private Table rootTable;
	private SelectListBuilder selectList = new SelectListBuilder();
	private ConditionBuilder where;
	
	public DefaultSqlGenerator(Table rootTable) {
		this.rootTable = rootTable;
	}
	
	public void addSelectValue(SelectValue value) {
		selectList.addSelectValue(value);
	}
	
	public void addWhereClause(Condition clause, LogicalOperator operator) {
		if (where == null) {
			where = ConditionBuilder.createWhereClauseConditionBuilder(clause);
		} else {
			where.addCondition(clause, operator);	
		}
	}
	
	public String generate() {
		StringJoiner statement = new StringJoiner(" ");
		statement.add(selectList.toSQL());
		statement.add(generateFrom());
		if (where != null) {
			statement.add(where.toSQL());	
		}
		
		return statement.toString().trim();
	}
	
	private String generateFrom() {
		return SqlConst.FROM + " " + rootTable.toSQL();
	}
}
