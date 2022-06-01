package de.sqlgenerator.where;

import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class NotNullCondition extends WhereClause {

	public NotNullCondition(SqlObject expectedNotToBeNull) {
		super();
		this.leftSide = expectedNotToBeNull;
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(leftSide.toSQL());
		joiner.add(SqlConst.IS);
		joiner.add(SqlConst.NOT);
		joiner.add(SqlConst.NULL);
		return joiner.toString();
	}
}
