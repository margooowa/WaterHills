package com.waterhills.calcultion.control;

import org.apache.log4j.Logger;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.crx.waterhills.controllogic.WaterHillsService;
import com.waterhills.calcultion.backing.view.ChartView;
import com.waterhills.utils.ConversionUtils;

/**
 * This controller handles responses to user events and updates the view with
 * new data.
 */
public class ChartController {

	private Logger logger = Logger.getLogger(getClass().getName());
	private ChartView view;
	private WaterHillsService waterService;

	public ChartController(ChartView view, WaterHillsService waterService) {
		this.view = view;
		this.waterService = waterService;
	}

	/**
	 * Calculating water and creating bar chart model.
	 */
	public void generateChartAndResult() {
		int[] numbers = ConversionUtils.parseStringToArray(view
				.getInputNumberArray());
		int[] resultWaterArray = countWater(numbers);

		createBarModel(numbers, resultWaterArray);

	}

	/**
	 * Count water with the help of two algorithms.
	 * 
	 * @param numbers
	 *            inputed values.
	 * @return array of water in hills.
	 */
	public int[] countWater(int[] numbers) {
		int[] resultArray = waterService.getWaterForEachHill(numbers);
		int result = waterService.getTotalWaterAmount(numbers);
		view.setResult(result);
		return resultArray;
	}

	/**
	 * init chart model.
	 * 
	 * @param numbers
	 *            array of inputed numbers(height of hills)
	 * @param resultArray
	 *            calculated array(saved water in hills)
	 */
	private void createBarModel(int[] numbers, int[] resultArray) {
		BarChartModel barModel = new BarChartModel();

		// hills series creating
		ChartSeries hills = new ChartSeries();
		hills.setLabel("Hills");

		// water setries creating
		ChartSeries water = new ChartSeries();
		water.setLabel("Water");

		// fill series with data
		int columnNr = 1;
		for (int i = 0; i < numbers.length; i++) {
			hills.set(columnNr, numbers[i]);
			water.set(columnNr, resultArray[i]);
			columnNr++;
		}

		barModel.addSeries(hills);
		barModel.addSeries(water);

		configureChartModel(barModel);

		view.setBarModel(barModel);
		logger.info("Bar model war generated");
	}

	/**
	 * Add additional properties to chart model.
	 * 
	 * @param barModel
	 *            generated chart model
	 */
	private void configureChartModel(BarChartModel barModel) {
		// bars have width 100%
		barModel.setBarMargin(0);
		// colors of bars
		barModel.setSeriesColors("26a69a,b3e5fc");
		barModel.setAnimate(true);
		barModel.setStacked(true);
		// min for y axis=0
		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setMin(0);
	}

	public ChartView getView() {
		return view;
	}
	
	

}
