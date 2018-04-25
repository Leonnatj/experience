package com.adet.core.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DynamicQueryBuilderTest {

	@Test
	public void testBuildQuery() {
		String fields = "FIRST_NAME,LAST_NAME";
		String table = "ACTOR";
		String query = DynamicQueryBuilder.buildQuery(fields, table);
		assertEquals(query, "SELECT FIRST_NAME,LAST_NAME FROM ACTOR");
	}

}
