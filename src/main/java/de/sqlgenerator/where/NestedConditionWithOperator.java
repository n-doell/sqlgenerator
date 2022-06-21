package de.sqlgenerator.where;

import de.sqlgenerator.LogicalOperator;

class NestedConditionWithOperator implements ConditionWithOperator {

	private LogicalOperator operator;
	private ConditionBuilder nestedCondition;
	
	public NestedConditionWithOperator(ConditionBuilder nestedCondition, LogicalOperator operator) {
		this.nestedCondition = nestedCondition;
		this.operator = operator;
	}
	
	@Override
	public LogicalOperator getOperator() {
		return operator;
	}

	@Override
	public String getConditionAsSQLString() {
		return "(" + nestedCondition.toSQL() + ")";
	}

	
}
