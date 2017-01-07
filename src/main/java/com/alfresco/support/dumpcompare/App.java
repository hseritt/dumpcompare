package com.alfresco.support.dumpcompare;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

import com.alfresco.support.dumpcompare.parser.JmxDumpParser;

public class App 
{
	private static final String VERSION = "0.0.1";
	
	public static void showUsage() {
		System.out.println("dumcompare.jar : Shows a difference in properties between two jmxdump files.");
		System.out.println("  Version: " + VERSION);
		System.out.println("  Output values will be separated by a ':'");
		System.out.println("Usage: ");
		System.out.println("  java -jar dumpcompare.jar [target file] [source file]");
		System.out.println("");
	}
	
    public static void main( String[] args ) throws IOException
    {        
    	File testJmxDumpFile = null;
		File controlJmxDumpFile = null;
    	
    	try {
    		testJmxDumpFile = new File(args[0]);
    		controlJmxDumpFile = new File(args[1]);
    	} catch (ArrayIndexOutOfBoundsException e) {
    		showUsage();
    		System.exit(0);
    	}
    	
        HashMap<String,String> testProperties = new HashMap<String,String>();
        HashMap<String,String> controlProperties = new HashMap<String,String>();
        
        JmxDumpParser jmxDumpParser = new JmxDumpParser(testJmxDumpFile);
        testProperties = jmxDumpParser.getProperties();
        
        JmxDumpParser controlJParser = new JmxDumpParser(controlJmxDumpFile);
        controlProperties = controlJParser.getProperties();
        
        SortedSet<String> keys = new TreeSet<String>(controlProperties.keySet());
        
        for (String key : keys) {
        	try {
        		if (! testProperties.get(key).equals(controlProperties.get(key)))
        			System.out.println(key + " ? " + testProperties.get(key) + " : " + controlProperties.get(key) );
        	} catch (NullPointerException e) {
        		try {	
        			System.out.println(key + " ? " + testProperties.get(key) + " : ");
        		} catch (NullPointerException err) {
        			System.out.println(key + " ? " + " " + " : " + controlProperties.get(key));
        		}
        	}
        }
    }
}
