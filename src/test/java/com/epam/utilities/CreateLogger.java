package com.epam.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CreateLogger {
	
	private Logger logger;
	private static CreateLogger createLogger;
	
	private CreateLogger(){
		
	}
	
	public static CreateLogger getLoggerInstance(){
		
		if (createLogger == null){
			createLogger =  new CreateLogger();
			return createLogger;
		}else{
			return createLogger;
		}
	}
	
	public Logger getLogger(){
		logger = LogManager.getLogger(this.getClass());
		return logger;
	}

}
