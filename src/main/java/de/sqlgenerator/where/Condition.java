package de.sqlgenerator.where;

import java.util.StringJoiner;

import de.sqlgenerator.ComparisonOperator;
import de.sqlgenerator.SqlObject;

public class Condition implements SqlObject {

	protected SqlObject leftSide;
	protected SqlObject rightSide;
	protected ComparisonOperator operator;
	
	public Condition(SqlObject leftSide, ComparisonOperator operator, SqlObject rightSide) {
		this.leftSide = leftSide;
		this.rightSide = rightSide;
		this.operator = operator;
	}
	
	/**
	 * If you use this constructor you need to override toSQL or set 
	 * {@link Condition#leftSide}, {@link Condition#rightSide} and {@link Condition#operator}
	 * manually.
	 */
	protected Condition() {
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
