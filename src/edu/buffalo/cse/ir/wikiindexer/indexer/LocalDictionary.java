/**
 * 
 */
package edu.buffalo.cse.ir.wikiindexer.indexer;

import java.util.Properties;

/**
 * @author nikhillo
 * This class represents a subclass of a Dictionary class that is
 * local to a single thread. All methods in this class are
 * assumed thread safe for the same reason.
 */
public class LocalDictionary extends Dictionary {
	
	/**
	 * Public default constructor
	 * @param props: The properties file
	 * @param field: The field being indexed by this dictionary
	
	 */
	private static int docId;
	public LocalDictionary(Properties props, INDEXFIELD field) {
		super(props, field);
		// TODO Auto-generated constructor stub
		docId=0;
		docString+="nil";
		compressedLinkDictionary.put(docString.indexOf("nil"),docId++);
	}
	
	/**
	 * Method to lookup and possibly add a mapping for the given value
	 * in the dictionary. The class should first try and find the given
	 * value within its dictionary. If found, it should return its
	 * id (Or hash value). If not found, it should create an entry and
	 * return the newly created id.
	 * @param value: The value to be looked up
	 * @return The id as explained above.
	 */
	public int lookup(String value) {
		//TODO Implement this method
		
		if(docString.contains(value))
			
		{
			
			return compressedLinkDictionary.get(docString.indexOf(value));
		}
		else
		{
			
			docString+=value; 
			compressedLinkDictionary.put(docString.indexOf(value),docId);
					
			return docId++;
		}
		
		
		}
}
