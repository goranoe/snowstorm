package org.snomed.snowstorm.core.data.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class DescriptionTest {

	@Test
	public void getTag() {
		assertEquals(null, new Description("abc de").setTypeId(Concepts.SYNONYM).getTag());
		assertEquals(null, new Description("abc de (disorder)").setTypeId(Concepts.SYNONYM).getTag());
		assertEquals(null, new Description("abc de (disorder) ").setTypeId(Concepts.FSN).getTag());
		assertEquals(null, new Description("abc de (disorder").setTypeId(Concepts.FSN).getTag());
		assertEquals(null, new Description("abc de (thing) 1").setTypeId(Concepts.FSN).getTag());
		assertEquals(null, new Description("abc de(disorder)").setTypeId(Concepts.FSN).getTag());
		assertEquals(null, new Description("abc de(disorder").setTypeId(Concepts.FSN).getTag());
		assertEquals("disorder", new Description("abc de (disorder)").setTypeId(Concepts.FSN).getTag());
		assertEquals("disorder aa", new Description("abc de (disorder aa)").setTypeId(Concepts.FSN).getTag());
	}

}
