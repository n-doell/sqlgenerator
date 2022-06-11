package de.sqlgenerator.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.Column;
import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class OrderBy implements SqlObject {

	private List<Column> values = new ArrayList<Column>();
	private OrderType type;
	
	public OrderBy(Column column, OrderType type) {
		this.type = type;
		values.add(column);
	}
	
	public void addColumn(Column column) {
		values.add(column);
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(SqlConst.ORDER_BY);
		joiner.add(getValuesAsSql());
		joiner.add(type.getTypeAsSql());
		return joiner.toString();
	}

	private String getValuesAsSql() {
		StringJoiner joiner = new StringJoiner(", ");
		values.forEach(value -> {
			joiner.add(value.toSQL());
		});
		return joiner.toString();
	}
}
