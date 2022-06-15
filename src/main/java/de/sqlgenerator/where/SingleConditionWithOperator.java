package de.sqlgenerator.where;

import de.sqlgenerator.LogicalOperator;
import de.sqlgenerator.condition.Condition;

class SingleConditionWithOperator implements ConditionWithOperator {

	private Condition clause;
	private LogicalOperator operator;
	
	public SingleConditionWithOperator(Condition clause, LogicalOperator operator) {
		this.clause = clause;
		this.operator = operator;
	}

	@Override
	public LogicalOperator getOperator() {
		return operator;
	}

	@Override
	public String getConditionAsSQLString() {
		return clause.toSQL();
	}
	
	

}
