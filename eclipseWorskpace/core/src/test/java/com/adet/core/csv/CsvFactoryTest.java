package com.adet.core.csv;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CsvFactoryTest {

	@Test
	public void testGetActors() {

		 String fields = "ACTOR_ID,FIRST_NAME,LAST_NAME,LAST_UPDATE";
		 String table = "ACTOR";

//		String fields = "ADDRESS,ADDRESS2";
//		String table = "ADDRESS";

		CsvGenerator factory = new CsvGenerator();

		assertTrue(factory.generate(fields, table));

	}

}
