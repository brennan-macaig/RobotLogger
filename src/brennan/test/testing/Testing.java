package brennan.test.testing;

import brennan.brennan.robotlogger.RobotLogger;

public class Testing {
	/**
	 * THIS IS A TESTING FILE.
	 * Please be aware. If this got pushed somehow, well, I don't know.
	 */
	
	public static void main(String args[]) {
		RobotLogger.init();
		RobotLogger.log("Hello, logger! This is me!", "INFO");
		RobotLogger.log("Whoah there buddy! This be a warning!", "WARN");
		RobotLogger.log("And here be an error!", "ERROR");
		
	}
}
