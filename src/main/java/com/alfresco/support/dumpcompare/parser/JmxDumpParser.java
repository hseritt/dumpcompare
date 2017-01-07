package com.alfresco.support.dumpcompare.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class JmxDumpParser {
	
	private File jmxdumpFile;
	
	public File getJmxdumpFile() {
		return jmxdumpFile;
	}

	public void setJmxdumpFile(File jmxdumpFile) {
		this.jmxdumpFile = jmxdumpFile;
	}

	public JmxDumpParser(File jmxdumpFile) {
		setJmxdumpFile(jmxdumpFile);
	}
	
	public HashMap<String,String> getProperties() throws IOException {
		
		BufferedReader br = new BufferedReader(new FileReader(jmxdumpFile));
        ArrayList<String> lines = new ArrayList<String>();
        HashMap<String,String> propertiesMap = new HashMap<String,String>();
        String line;
        
        while ((line = br.readLine()) != null) {
        	lines.add(line);
        	String lineElement;
        	String value;
        	
        	try {
        		lineElement = line.split(" ")[0];
        		value = line.split(" ")[line.split(" ").length - 1];
        		
        		if (value.equals("readable>")) {
        			value = "<unreadable>";
        		}
        		
        	} catch (ArrayIndexOutOfBoundsException e) {
        		lineElement = "";
        		value = "";
        	}
        	
        	if (lineElement.contains(".") & !lineElement.contains("=")) {
        		propertiesMap.put(lineElement, value);
        	}
        }
        
        br.close();
        
        return propertiesMap;
	}
}
