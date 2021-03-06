package io.magicthegathering.javasdk.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import io.magicthegathering.javasdk.resource.Card;
import io.magicthegathering.javasdk.resource.MtgSet;

import java.util.List;

import org.junit.Test;

public class SetAPITest {
	@Test
	public void testGetSet() {
		MtgSet testSet = new MtgSet();
		testSet.setGatherercode("1E");
		assertEquals(testSet, SetAPI.getSet("LEA"));
		assertFalse(testSet.equals(SetAPI.getSet("LEB")));
	}
	
	@Test
	public void testBadSetId() {
		assertNull(SetAPI.getSet("666"));
	}
	
	@Test
	public void testGetAllSets() {
		List<MtgSet> testSetList = SetAPI.getAllSets();
		MtgSet testSet = new MtgSet();
		testSet.setGatherercode("1E");
		assertEquals(testSetList.get(0), testSet);
	}
	
	@Test
	public void testGetBoosterFromSet(){
		String setCode = "KLD";
		List<Card> booster = SetAPI.getBooster(setCode);
		assertEquals(14, booster.size());
	}
}
