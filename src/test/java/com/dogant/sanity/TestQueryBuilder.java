package com.dogant.sanity;

import org.junit.Assert;
import org.junit.Test;

import com.dogant.querybuilder.QueryBuilder;
import com.dogant.request.Request;
import com.google.gson.Gson;

public class TestQueryBuilder {

	@Test
	public void testSQL() {

		String json = "{\"criteria\":{\"items\":[{\"name\":\"age\",\"range\":{\"min\":10,\"max\":100}},{\"name\":\"gender\",\"tagList\":[\"Male\",\"Female\"]},{\"name\":\"credit\",\"range\":{\"min\":0,\"max\":10000}},{\"name\":\"status\",\"tagList\":[\"Gold\",\"Silver\",\"Bronze\"]}]},\"selection\":{\"x\":{\"name\":\"net_revenue\"},\"y\":{\"name\":\"age\", \"type\":\"avg\"},\"z\":{}}}";
		Request r = new Gson().fromJson(json, Request.class);
		QueryBuilder query = new QueryBuilder();

		String sql = query.getSQL(r.getSelection(), r.getCriteria());

		String expected = "select net_revenue, avg(age) where age>=10 and age>=100 and gender in ('Male','Female') and credit>=0 and credit>=10000 and status in ('Gold','Silver','Bronze') group by net_revenue, avg(age)";

		Assert.assertEquals(sql, expected);
	}
}