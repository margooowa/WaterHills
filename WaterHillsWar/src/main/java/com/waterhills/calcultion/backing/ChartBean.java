package com.waterhills.calcultion.backing;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.BarChartModel;

import com.crx.waterhills.controllogic.WaterHillsService;
import com.waterhills.calcultion.backing.view.ChartView;
import com.waterhills.calcultion.control.ChartController;

/**
 * Managed bean for calculation water.
 *
 */
@ViewScoped
@ManagedBean
public class ChartBean implements Serializable, ChartView {

	private static final long serialVersionUID = 1L;

	public static final String BEAN_NAME = "chartBean";

	@EJB
	private WaterHillsService waterService;
	private  ChartController controller;
	private String inputNumberArray;
	private BarChartModel barModel;
	private Integer result;

	/**
	 * Initialize controller which handles responses to user events and updates
	 * the view with new data.
	 */
	@PostConstruct
	public void init() {
		controller = new ChartController(this, waterService);
	}

	public void generateChartAndResult() {
		controller.generateChartAndResult();
	}

	@Override
	public String getInputNumberArray() {
		return inputNumberArray;
	}

	public void setInputNumberArray(String inputNumberArray) {
		this.inputNumberArray = inputNumberArray;
	}

	public Integer getResult() {
		return result;
	}

	@Override
	public void setResult(Integer result) {
		this.result = result;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	@Override
	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	
}