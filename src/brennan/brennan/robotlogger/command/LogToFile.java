package brennan.brennan.robotlogger.command;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import brennan.brennan.robotlogger.RobotLogger;
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
public class LogToFile {
	
	public static String id = "log";
	/*
	 * Filled this variable with junk, so that if filePath has been reset then it will exist, otherwise it won't (and won't throw errors!)
	 */
	public static String filePath = "asdlfhiy3kjadi";
	
	public static void commandListener(String input, String pass, String level) {
		if (input.equalsIgnoreCase(id)) {
			executeCommand(input, pass, level);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void executeCommand(String cmd, String msg, String level) {
		if (RobotLogger.programWasQuit == true) {
			return;
		}
		File f = new File(filePath);
		if (f.exists() && (!f.isDirectory())) {
			// File exists
			writeToLog(msg, level);
		} else if (!(f.exists() && (!f.isDirectory()))) {
			// File doesn't exist
			createLogFile();
			writeToLog(msg, level);
			System.out.println("Does not exist got run");
		} else {
			RobotLogger.exitClean("LogToFile.executeCommand()[19]; File is a directory! Please clean filesystem.", "HIGH");
		}
	}
	private static String buildLogName() {
		System.out.println("Building logfile name");
		return "" + Config.filePath.toString() + Config.prefix.toString() + "-" + getCurrentTime().toString() + ".log";
	}
	
	private static void createLogFile() {
		System.out.println("Creating log file");
		filePath = buildLogName();
		PrintWriter writer;
		try {
			writer = new PrintWriter(filePath, "UTF-8");
			writer.println("# Log file created by LogRobo");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
	}
	
	private static String buildMessage(String message, String level) {
		return "[" + getCurrentTime() + "] [" + level + "] " + message + "\n";
	}
	
	private static void writeToLog(String write, String level) {
		System.out.println("Writing to log file");
		try {
		    Files.write(Paths.get(filePath), buildMessage(write, level).getBytes(), StandardOpenOption.APPEND);
		}catch (IOException e) {
		    //exception handling left as an exercise for the reader
			e.printStackTrace();
		}
	}
	
	private static String getCurrentTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd+HH-mm-ss");
		Date date = new Date();
		return dateFormat.format(date).toString();
	}
}
