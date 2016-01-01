package brennan.brennan.robotlogger;

import brennan.brennan.robotlogger.command.LogToFile;
import brennan.brennan.robotlogger.config.Config;

/**
 * RobotLogger (c) 2016 by Brennan Macaig
 *
 * RobotLogger is licensed under a
 * Creative Commons Attribution-ShareAlike 4.0 International License.

 * You should have received a copy of the license along with this
 * work. If not, see <http://creativecommons.org/licenses/by-sa/4.0/>. 
 *
 */
public class RobotLogger {
	public static boolean programWasQuit = false;
	/**
	 * Bootstrap the program.
	 * 1. Gets the properties file, and reads it
	 * 2. Passes input of this file to other functions.
	 * 3. Cleanly runs, and exists when no longer needed.
	 */
	public static void init() {
		Config.getConfig(); // Get the config file
		
	}
	
	public static void commandHandle(String cmd, String msg, String level) {
		LogToFile.commandListener(cmd, msg, level);
	}
	
	public static void exitClean(String errorLevel, String message) {
		// Safely exit the program
		programWasQuit = true; // Alert all files that the program was quit (clean or no) so that code does not crash. 
		System.out.println("This is a notice of CLEAN-EXIT. Code provided following exit reason: \n LVL: " + errorLevel + ", RSN: " + message);
	}
	
	public static void main(String args[]) {
		init();
	}
}
