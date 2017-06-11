/**
 * This static class creates and writes a log file
 */
package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/** 
 * @author Java spring 2017
 * 
 */
public final class MyFileLogWriter{
	
	/** An output file */
	static private File outputLogFile;
	
	/** A file writer buffer */
	static private FileWriter writer; 
	
	/**
	 * Creates a file and a writer for logging
	 */
	public static void initializeMyFileWriter(){
		outputLogFile = new File("output.txt");
		try {
			writer = new FileWriter(outputLogFile);
		}
		catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	/**
	 * Writes given text message to the log file.
	 * @param message The text to be written in the log
	 * @param isSeparatorNeeded True if seperator is needed
	 */
	public static void writeToLogFile(String message, boolean isSeparatorNeeded){
		try {
			writer.write(message);
			if(isSeparatorNeeded)
				writeAsteriskSeparatorToLogFile();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes separator to log file.
	 */
	public static void writeHyphenSeparatorToLogFile(){
		try {
			writer.write("\n-----------------------------------------------------------------------------");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes separator to log file.
	 */
	public static void writeAsteriskSeparatorToLogFile(){
		try {
			writer.write("\n****************************************************************************\n");
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Saves the log file (by closing the file writer).
	 */
	public static void saveLogFile(){
		try {
			writer.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	

}
