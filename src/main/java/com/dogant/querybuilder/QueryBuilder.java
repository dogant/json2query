package com.dogant.querybuilder;

import com.dogant.criteria.Criteria;
import com.dogant.criteria.Item;
import com.dogant.selection.Selection;

public class QueryBuilder {

	public String getSQL(Selection s, Criteria c) {

		SelectBuilder sql = new SelectBuilder();

		if (s.hasX()) {
			sql.column(s.getX().getColumn(), true);
		}

		if (s.hasY()) {
			sql.column(s.getY().getColumn(), true);
		}

		if (s.hasZ()) {
			sql.column(s.getZ().getColumn(), true);
		}

		for (Item item : c.getItems()) {

			if (!item.getWhereClause().isEmpty()) {
				sql.where(item.getWhereClause());
			}

		}

		return sql.toString();

	}

}
