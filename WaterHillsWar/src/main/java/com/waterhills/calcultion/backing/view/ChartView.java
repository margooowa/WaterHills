package com.waterhills.calcultion.backing.view;

import org.primefaces.model.chart.BarChartModel;

/**
 * This view includes methods which are used in a controller. In this case the
 * view is only responsible for the component and value-binding and the
 * delegation of the events.
 */
public interface ChartView {

	public void setResult(Integer result);
	
	public void setBarModel(BarChartModel barModel);
	
	public BarChartModel getBarModel();
	
	public String getInputNumberArray();

	public void setInputNumberArray(String inputArray);
	
}
