package com.test.unittesting.business;

import com.test.unittesting.data.DataService;

public class BusinessImpl {

	private DataService dataService;
	
	public void setDataService(DataService dataService) {
		this.dataService = dataService;
	}

	public int sum(int[] nums) {
		int sum = 0 ;
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
	
	public int sumUsingDataService() {
		int sum = 0 ;
		int[] nums = dataService.retrieveAllData();
		for(int num : nums) {
			sum += num;
		}
		return sum;
	}
}
