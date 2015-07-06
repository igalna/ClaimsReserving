package testingClaimsRevserving;

import static org.junit.Assert.*;

import org.junit.Test;

import claimsreversing.AccumulateData;

public class TestingClaimsReserving {
	
	AccumulateData store;
	
	@Test
	public void testFileExists() {
		assertNotNull(store = new AccumulateData("input"));
	}
}
