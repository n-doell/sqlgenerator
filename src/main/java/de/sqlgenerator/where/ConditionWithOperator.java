package de.sqlgenerator.where;

import de.sqlgenerator.LogicalOperator;

interface ConditionWithOperator {

	public LogicalOperator getOperator();
	
	public String getConditionAsSQLString();
}
