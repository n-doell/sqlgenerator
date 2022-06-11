package de.sqlgenerator.groupby;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.sqlgenerator.Column;
import de.sqlgenerator.SqlConst;
import de.sqlgenerator.SqlObject;

public class GroupBy implements SqlObject {

	private List<Column> groups = new ArrayList<Column>();
	
	public GroupBy(Column column) {
		groups.add(column);
	}
	
	public void addColumn(Column column) {
		groups.add(column);
	}
	
	@Override
	public String toSQL() {
		StringJoiner joiner = new StringJoiner(" ");
		joiner.add(SqlConst.GROUP_BY);
		joiner.add(getGroupsAsSql());
		return joiner.toString();
	}
	
	private String getGroupsAsSql() {
		StringJoiner joiner = new StringJoiner(", ");
		groups.forEach(group -> {
			joiner.add(group.toSQL());
		});
		return joiner.toString();
	}
	
}
