# WaterHills
Application which takes an array as an input, and calculates the volume of water which remained after the rain.

  I am using two variants of algorithm. This is because I found one solution and then another, better one, but I decided to leave them two for comparing and use their results for different purposes in UI. Implementation in WaterHillsServiceBean class

  1.	int[] getWaterForEachHill(int initialArray[])
  
It was my first variant. The idea is to have two additional arrays: one that contains the highest elements to the left and another contains the highest elements to the right. In the end founding amount of water for each hill by min(left[i],right[i])-arr[i]. This algorithm returns array of values not just one final result because I wanted to show series on the chart in UI.

  Time Complexity: O(n)
  Memmory complexity: O(n)

  2.	int getTotalWaterAmount(int initialArray[]) 

The second one: algorithm is going from left to right and getting the highest elements of left and right separately. E.g. if current height left lower than previous one I add value (previous height-current height) to the common result; else: max height of the left will be equals current height. The loop goes until left meets right. 

  Time Complexity: O(n)
  Memmory complexity: O(1)
  

So the optimal algorithm is the second.

