package com.waterhills.calcultion.control;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.naming.NamingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.crx.waterhills.controllogic.WaterHillsServiceBean;
import com.waterhills.calcultion.backing.view.ChartView;

public class ChartControllerTest {

	@InjectMocks
	private ChartController chartController;

	@Mock
	private ChartView view;

	@Mock
	private WaterHillsServiceBean waterService;

	@Before
	public void setup() throws NamingException {
		MockitoAnnotations.initMocks(this);
		chartController = new ChartController(view, waterService);
	}

	@Test
	public void testCountWater() {
		int[] inputArray = { 9, 1, 9 };
		int[] expectedArray = { 0, 8, 0 };
		int expectedSum = 8;
		when(waterService.getTotalWaterAmount(inputArray)).thenReturn(expectedSum);
		when(waterService.getWaterForEachHill(inputArray)).thenReturn(expectedArray);
		
		int[] recievedResult = chartController.countWater(inputArray);
		verify(waterService, times(1)).getTotalWaterAmount(inputArray);
		verify(waterService, times(1)).getWaterForEachHill(inputArray);
		assertArrayEquals(expectedArray, recievedResult);
	}
	
	@Test
	public void testCountWaterEmpty() {
		int[] inputArray = { 9, 1, 9 };
		int[] expectedArray = { 9, 1, 9 };
		int expectedSum = 0;
		when(waterService.getTotalWaterAmount(inputArray)).thenReturn(expectedSum);
		when(waterService.getWaterForEachHill(inputArray)).thenReturn(expectedArray);
		
		int[] recievedResult = chartController.countWater(inputArray);
		verify(waterService, times(1)).getTotalWaterAmount(inputArray);
		verify(waterService, times(1)).getWaterForEachHill(inputArray);
		assertArrayEquals(expectedArray, recievedResult);
	}
	
	@Test(expected = NullPointerException.class)
	public void testCountWaterOnNull() {
		int[] inputArray = null;
		when(waterService.getTotalWaterAmount(null)).thenThrow(new NullPointerException());
		when(waterService.getWaterForEachHill(null)).thenThrow(new NullPointerException());
		chartController.countWater(inputArray);		
	}

	@Test(expected = NullPointerException.class)
	public void testGenerateChartAndResultException() {
		when(view.getInputNumberArray()).thenReturn(null);
		chartController.generateChartAndResult();
	}
	

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testBarModelArrayIndexOfBound() {
		int[] inputArray = { 9, 1, 9 };
		int[] expectedWrongArray = { 0, 8 };
		chartController.createBarModel(inputArray, expectedWrongArray);
	}

}
