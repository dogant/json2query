package com.dogant.request;

import com.dogant.criteria.Criteria;
import com.dogant.selection.Selection;

public class Request {

	public Criteria criteria;
	public Selection selection;

	public Criteria getCriteria() {
		return criteria;
	}

	public void setCriteria(Criteria criteria) {
		this.criteria = criteria;
	}

	public Selection getSelection() {
		return selection;
	}

	public void setSelection(Selection selection) {
		this.selection = selection;
	}

}
