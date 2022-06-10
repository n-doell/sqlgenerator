package de.sqlgenerator.from;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;
import de.sqlgenerator.Table;

public class FromBuilder implements SqlObject {

	private List<Table> tables = new ArrayList<Table>();
	private List<Join> joins = new ArrayList<Join>();
	
	public FromBuilder(Table table) {
		tables.add(table);
	}
	
	public void addTable(Table table) {
		tables.add(table);
	}
	
	public void addJoin(Join join) {
		joins.add(join);
	}

	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(SqlConst.FROM);
		joiner.add(getTablesAsSql());
		if (!joins.isEmpty()) {
			joiner.add(getJoinsAsSql());	
		}
		return joiner.toString();
	}

	private String getTablesAsSql() {
		StringJoiner tableJoiner = new StringJoiner(", ");
		tables.forEach(table -> {
			tableJoiner.add(table.toSQL());
		});
		return tableJoiner.toString();
	}
	
	private String getJoinsAsSql() {
		StringJoiner joinJoiner = new StringJoiner(" ");
		joins.forEach(join -> {
			joinJoiner.add(join.toSQL());
		});
		return joinJoiner.toString();
	}
}
