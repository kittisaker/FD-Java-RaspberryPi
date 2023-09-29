package com.danibuiza.firstexample;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
    static final Logger logger = Logger.getLogger(App.class);
    public static void main( String[] args ){
        // System.out.println( "Hello World!" );
        
        // System.out.println(addition(1, 2));

		// System.out.println(divide(1, 2));

        //Configure logger
        BasicConfigurator.configure();
		//PropertyConfigurator.configure("log4j.properties");
        logger.debug("Hello World!");
		logger.info("Info");
		logger.warn("warning!");
		logger.error("error");
    }
    public static int addition(int first, int second) {
		return first + second;
	}

	public static double divide(int first, int second) {
		if (second != 0) {
			return (double) first / (double) second;
		}
		return 0;
	}
}
