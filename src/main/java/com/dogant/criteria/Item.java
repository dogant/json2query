package com.dogant.criteria;

import java.util.ArrayList;
import java.util.List;

import com.dogant.util.StringUtil;

public class Item implements ICriteria {

	private final String kGREATER = ">=";
	private final String kLESSER = ">=";
	private final String kEQUAL = "=";
	private final String kSEPARATOR = ",";

	private String name;
	private Range range;
	private List<String> tagList = new ArrayList<String>();

	/*
	 * Basically expecting an item to have an either Range or List clause
	 */
	@Override
	public String getWhereClause() {
		return hasRange() ? getRangeClause() : getListClause();
	}

	public String getRangeClause() {
		if (!this.hasRange()) {
			return "";
		}

		StringBuilder clause = new StringBuilder();

		if (range.hasMin() && range.hasMax()) {

			clause.append(name + kGREATER + range.getMin() + " and " + name + kLESSER + range.getMax());

		} else if (range.hasMin()) {
			clause.append(name + kGREATER + range.getMin());
		} else if (getRange().hasMax()) {
			clause.append(name + kLESSER + range.getMax());
		}

		return clause.toString();

	}

	public String getListClause() {

		if (!this.hasTagList()) {
			return "";
		}

		StringBuilder clause = new StringBuilder();

		if (tagList.size() > 1) {

			clause.append(name + " in (");
			for (int i = 0; i < tagList.size(); ++i) {
				clause.append(StringUtil.singleQuote(tagList.get(i)));
				if (i < tagList.size() - 1)
					clause.append(kSEPARATOR);
			}
			clause.append(")");

		} else {
			clause.append(name + kEQUAL + StringUtil.singleQuote(tagList.get(0)));
		}

		return clause.toString();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Range getRange() {
		return range;
	}

	public void setRange(Range range) {
		this.range = range;
	}

	public Boolean hasRange() {
		return range != null && (range.hasMax() || range.hasMin());
	}

	public List<String> getTagList() {
		return tagList;
	}

	public void setTagList(List<String> tagList) {
		this.tagList = tagList;
	}

	public Boolean hasTagList() {
		return tagList != null && !tagList.isEmpty();
	}

}
