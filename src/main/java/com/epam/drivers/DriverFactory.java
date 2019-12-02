package com.epam.drivers;

public class DriverFactory {
	
	private DriverFactory(){
		
	}
	
	public static Driver getInstance(String driverName){
		if (driverName.equalsIgnoreCase("chrome")){
			return new Chrome();
		}else if (driverName.equalsIgnoreCase("ie")){
			return new Ie();
		}else if (driverName.equalsIgnoreCase("firefox")){
			return new Firefox();
		}else {
			return null;
		}
	}

}
