package com.crx.waterhills.controllogic;

import javax.ejb.Local;

/**
 * 
 * Interface containing all available methods provided by this module.
 *
 */
@Local
public interface WaterHillsService {

	int getTotalWaterAmount(int initialArray[]);

	int[] getWaterForEachHill(int initialArray[]);
	

}
