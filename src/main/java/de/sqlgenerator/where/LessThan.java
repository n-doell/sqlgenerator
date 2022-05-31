package de.sqlgenerator.where;

import de.sqlgenerator.SqlObject;

public class LessThan extends WhereClause {

	public LessThan(SqlObject leftSide, SqlObject rightSide) {
		super();
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.operator = ComparisonOperator.LESS_THAN;
	}

	
}
