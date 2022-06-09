package de.sqlgenerator.from;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;
import de.sqlgenerator.Table;

public class FromBuilder implements SqlObject {

	private List<FromValue> values = new ArrayList<FromValue>();
	
	public FromBuilder(Table table) {
		values.add(new FromValue(table));
	}
	
	public void addTable(Table table) {
		values.add(new FromValue(table));
	}

	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(", ");
		values.forEach(value -> {
			joiner.add(value.toSQL());
		});
		return SqlConst.FROM + " " + joiner.toString();
	}

}
