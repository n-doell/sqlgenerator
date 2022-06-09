package de.sqlgenerator.from;

import java.util.StringJoiner;

import de.sqlgenerator.Column;
import de.sqlgenerator.ComparisonOperator;
import de.sqlgenerator.SqlConst;
import de.sqlgenerator.Table;

public class Join extends FromValue {

	private Column leftSide; 
	private Column rightSide;
	private Table tableExpression;
	private JoinEnum type;
	
	// TODO: prevent combination: alias in tableExpression but not in matching column
	// TOOD: check column and table match
	// TODO: self join is extra
	
	/**
	 * Creates a left join statement with an equals-boolean-condition between the columns.
	 * Other conditions are currently not supported
	 * @param type the join-type
	 * @param leftSide the column on the left side of the join
	 * @param rightSide the column on the right side of the join
	 * @param toJoin table to join. Needs to match table from one of the {@link Column} parameters  
	 */
	public Join(JoinEnum type, Table toJoin, Column leftSide, Column rightSide) {
		this.type = type;
		this.tableExpression = toJoin; 
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(type.toSQL());
		joiner.add(tableExpression.toSQL());
		joiner.add(SqlConst.ON);
		joiner.add(leftSide.toSQL());
		joiner.add(ComparisonOperator.EQUALS.getOperator());
		joiner.add(rightSide.toSQL());
		return joiner.toString();
	}

}
