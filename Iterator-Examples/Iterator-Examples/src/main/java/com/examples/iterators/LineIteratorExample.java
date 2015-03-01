package com.examples.iterators;

import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.commons.io.LineIterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class LineIteratorExample {
	
	private static Log log = LogFactory.getLog(LineIteratorExample.class);
	
	public static void main(String[] args) throws IllegalArgumentException, UnsupportedEncodingException, FileNotFoundException {
		/* INFO: Below line will read the file line by line, encoded in UTF-8*/
		LineIterator li = new LineIterator(new InputStreamReader(LineIteratorExample.class.getClassLoader().getResourceAsStream("TestIterator.txt" /*File Source*/),"UTF-8"));
		while(li.hasNext()){
			String str = (String) li.next();
			log.info(str);
		}
		log.info("Finished Reading");
	}

}
