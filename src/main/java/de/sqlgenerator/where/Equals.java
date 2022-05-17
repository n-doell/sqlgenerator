package de.sqlgenerator.where;

import java.util.StringJoiner;

import de.sqlgenerator.SqlObject;

public class Equals implements WhereClause {

	private static final ComparisonOperator OPERATOR = ComparisonOperator.EQUALS;
	
	private SqlObject leftSide; 
	private SqlObject rightSide;
	
	public Equals(SqlObject leftSide, SqlObject rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(OPERATOR.getOperator());
		joiner.add(rightSide.toSQL());
		return joiner.toString();
	}

	
}
