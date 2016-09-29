package com.crx.waterhills.controllogic;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WaterHillsServiceBeanTest {


	@Mock
	private WaterHillsServiceBean waterService;

	@Before
	public void setup() throws NamingException {
		waterService = new WaterHillsServiceBean();
	}

	@Test
	public void testTotalWaterAmount() {
		int[] arr = new int[] { 9, 1, 9 };
		int expectedResult = 8;
		assertEquals(expectedResult, waterService.getTotalWaterAmount(arr));		
	}

	@Test
	public void testTotalWaterAmountOneSize() {
		int[] arr = new int[] { 9 };
		int expectedResult = 0;
		assertEquals(expectedResult, waterService.getTotalWaterAmount(arr));
	}

	@Test(expected = NullPointerException.class)
	public void testNullTotalWaterAmount() {
		int[] arr = null;
		waterService.getTotalWaterAmount(arr);
	}

	@Test
	public void testWaterForEachHill() {
		int[] arr = new int[] { 9, 1, 9 };
		int[] expectedArray = { 0, 8, 0 };
		assertArrayEquals(expectedArray, waterService.getWaterForEachHill(arr));
	}

	@Test
	public void testWaterForEachHillEmpty() {
		int[] arr = new int[] { 9, 9, 9 };
		int[] expectedArray = { 0, 0, 0 };
		assertArrayEquals(expectedArray, waterService.getWaterForEachHill(arr));
	}

	@Test(expected = NullPointerException.class)
	public void testNullWaterForEachHill() {
		int[] arr = null;
		waterService.getWaterForEachHill(arr);
	}
}
