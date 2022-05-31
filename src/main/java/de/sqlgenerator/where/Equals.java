package de.sqlgenerator.where;

import de.sqlgenerator.SqlObject;

public class Equals extends WhereClause {
	
	public Equals(SqlObject leftSide, SqlObject rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.operator = ComparisonOperator.EQUALS;
	}
	
}
