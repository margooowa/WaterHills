package com.waterhills.calcultion.backing;

import static org.junit.Assert.assertNotNull;

import javax.naming.NamingException;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.crx.waterhills.controllogic.WaterHillsServiceBean;
import com.waterhills.calcultion.control.ChartController;

@RunWith(MockitoJUnitRunner.class)
public class ChartBeanTest {

	@Mock
	private WaterHillsServiceBean waterService;

	@Mock
	private ChartController chartController;
	
	@Mock
	private Logger logger;

	@InjectMocks
	private ChartBean chartBean;

	@Before
	public void setup() throws NamingException {
		MockitoAnnotations.initMocks(this);
		waterService = new WaterHillsServiceBean();
		chartBean.setWaterService(waterService);
		chartBean.init();
	}

	@Test
	public void testBarModel() {
		String inputArray = "919";
		chartBean.setInputNumberArray(inputArray);
		chartBean.generateChartAndResult();
		assertNotNull(chartBean.getBarModel());
	}

}
