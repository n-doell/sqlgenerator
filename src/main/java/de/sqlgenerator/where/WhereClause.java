package de.sqlgenerator.where;

import java.util.StringJoiner;

import de.sqlgenerator.SqlObject;

public class WhereClause implements SqlObject {

	protected SqlObject leftSide;
	protected SqlObject rightSide;
	protected ComparisonOperator operator;
	
	public WhereClause(SqlObject leftSide, ComparisonOperator operator, SqlObject rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.operator = operator;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(operator.getOperator());
		joiner.add(rightSide.toSQL());
		return joiner.toString();
	}
}
