package com.crx.waterhills.controllogic;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Implementation of the interface WaterHillsService.
 *
 */
@Stateless
@LocalBean
public class WaterHillsServiceBean implements WaterHillsService {
	

	@Override
	public int getTotalWaterAmount(int initialArray[]) {
		//getting size of initial array
		int size = initialArray.length;
		//initialization result 
		int result = 0;
		//getting index number of first and last elements
		int left = 0;
		int right = size - 1;
		//initialization the highest elements
		int maxleft = 0, maxright = 0;
		
		//Calculate water until left<=right
		while (left <= right) {
			if (initialArray[left] <= initialArray[right]) {
				if (initialArray[left] >= maxleft)
					maxleft = initialArray[left];
				else
					result += maxleft - initialArray[left];
				left++;
			} else {
				if (initialArray[right] >= maxright)
					maxright = initialArray[right];
				else
					result += maxright - initialArray[right];
				right--;
			}
		}
		return result;
	}

	@Override
	public int[] getWaterForEachHill(int initialArray[]) {
		//getting size of initial array
		int size = initialArray.length;
		//initialization result array
		int[] resutArray = new int[size];
		
		// left[i] contains the highest elements to the left
		int[] left = new int[size];

		// right [i] contains the highest elements to the right
		int[] right = new int[size];		

		// Fill left[i]
		left[0] = initialArray[0];
		for (int i = 1; i < size; i++) {
			left[i] = Math.max(left[i - 1], initialArray[i]);
		}

		// Fill right [i]
		right[size - 1] = initialArray[size - 1];
		for (int i = size - 2; i >= 0; i--) {
			right[i] = Math.max(right[i + 1], initialArray[i]);
		}
		//Calculate water for each element.
		for (int i = 0; i < size; i++) {
			resutArray[i] = Math.min(left[i], right[i]) - initialArray[i];
		}
		return resutArray;
	}

}
