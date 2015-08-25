package com.dogant.unit;

import org.junit.Assert;
import org.junit.Test;

import com.dogant.querybuilder.QueryBuilder;
import com.dogant.request.Request;
import com.google.gson.Gson;

public class TestQueryBuilder {

	@Test
	public void testSQL() {

		String json = "{\"criteria\":{\"items\":[{\"name\":\"age\",\"range\":{\"min\":10,\"max\":100}},{\"name\":\"gender\",\"tagList\":[\"Male\",\"Female\"]},{\"name\":\"credit\",\"range\":{\"min\":0,\"max\":10000}},{\"name\":\"status\",\"tagList\":[\"Gold\",\"Silver\",\"Bronze\"]}]},\"selection\":{\"axes\":[{\"name\":\"net_revenue\"},{\"name\":\"age\", \"type\":\"avg\"}]}}";

		Request r = new Gson().fromJson(json, Request.class);
		QueryBuilder query = new QueryBuilder(r);

		String sql = query.getSQL();

		String expected = "select net_revenue, avg(age) from members where age>=10 and age>=100 and gender in ('Male','Female') and credit>=0 and credit>=10000 and status in ('Gold','Silver','Bronze') group by net_revenue, avg(age)";
		Assert.assertEquals(sql, expected);
	}

	@Test
	public void testNoCriteria() {

		String json = "{\"selection\":{\"axes\":[{\"name\":\"net_revenue\"},{\"name\":\"age\", \"type\":\"avg\"}]}}";
		Request r = new Gson().fromJson(json, Request.class);
		QueryBuilder query = new QueryBuilder(r);

		String sql = query.getSQL();
		String expected = "select net_revenue, avg(age) from members group by net_revenue, avg(age)";

		Assert.assertEquals(sql, expected);

	}

	@Test
	public void testNoSelection() {

		String json = "{\"criteria\":{\"items\":[{\"name\":\"age\",\"range\":{\"min\":10,\"max\":100}},{\"name\":\"gender\",\"tagList\":[\"Male\",\"Female\"]},{\"name\":\"credit\",\"range\":{\"min\":0,\"max\":10000}},{\"name\":\"status\",\"tagList\":[\"Gold\",\"Silver\",\"Bronze\"]}]}}";
		Request r = new Gson().fromJson(json, Request.class);
		QueryBuilder query = new QueryBuilder(r);

		String sql = query.getSQL();
		String expected = "select * from members where age>=10 and age>=100 and gender in ('Male','Female') and credit>=0 and credit>=10000 and status in ('Gold','Silver','Bronze')";

		Assert.assertEquals(sql, expected);

	}
	
	@Test
	public void testEmpty() {

		String json = "";
	    Request r = new Gson().fromJson(json, Request.class);
		QueryBuilder query = new QueryBuilder(r);

		String sql = query.getSQL();
		System.out.println(sql);
		String expected = "";
		
		Assert.assertEquals(sql, expected);

	}
}