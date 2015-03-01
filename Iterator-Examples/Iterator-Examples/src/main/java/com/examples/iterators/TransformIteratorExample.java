package com.examples.iterators;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.IteratorUtils;
import org.apache.commons.collections.Transformer;
import org.apache.commons.io.LineIterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author ag_3112@outlook.com
 * 
 *         Example to Change the content of Iterator using Transformer of
 *         Apache-Commons
 * 
 */
public class TransformIteratorExample {

	private static Log logger = LogFactory
			.getLog(TransformIteratorExample.class);

	public static void main(String[] args) throws IllegalArgumentException,
			UnsupportedEncodingException {
		/* INFO: Copied from LineIterator Example */
		/* INFO: Below line will read the file line by line, encoded in UTF-8 */
		LineIterator li = new LineIterator(new InputStreamReader(
				LineIteratorExample.class.getClassLoader().getResourceAsStream(
						"TestIterator.txt" /* File Source */), "UTF-8"));
		/* Now we have iterator containing list of Strings */

		List<String> strList = new ArrayList<String>();
		while (li.hasNext()) {
			strList.add((String) li.next());
		}

		Iterator<String> itr = strList.iterator();
		itr = transformContent(itr);
		while (itr.hasNext()) {
			logger.info(itr.next());
		}
	}

	@SuppressWarnings("unchecked")
	private static Iterator<String> transformContent(Iterator<String> itr) {
		Transformer transform = new Transformer() {

			@Override
			public Object transform(Object input) {
				String str = (String) input;
				/* INFO: Now you can change the content of Iterator */
				if ("TestLine 2".equals(str)) {
					str = "Changed to TestList 10";
				}
				return str;
			}
		};

		return IteratorUtils.transformedIterator(itr, transform);
	}
}
