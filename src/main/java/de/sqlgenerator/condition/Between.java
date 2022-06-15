package de.sqlgenerator.condition;

import java.util.StringJoiner;

import de.sqlgenerator.Column;
import de.sqlgenerator.LogicalOperator;
import de.sqlgenerator.SqlObject;

public class Between extends Condition {

	private Column conditionColumn; 
	private SqlObject leftSide; 
	private SqlObject rightSide;
	
	public Between(Column conditionColumn, SqlObject leftSide, SqlObject rightSide) {
		super();
		this.conditionColumn = conditionColumn;
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(conditionColumn.toSQL());
		joiner.add(LogicalOperator.BETWEEN.getValue());
		joiner.add(leftSide.toSQL());
		joiner.add(LogicalOperator.AND.getValue());
		joiner.add(rightSide.toSQL());
		return joiner.toString();
	}
}
