/**
 * 
 */
package edu.buffalo.cse.ir.wikiindexer.indexer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nikhillo
 * An abstract class that represents a dictionary object for a given index
 */
public abstract class Dictionary implements Writeable {
	protected static Map<String,Integer> termDictionary;
	public Dictionary (Properties props, INDEXFIELD field) {
		//TODO Implement this method
		termDictionary = new HashMap<String,Integer>();
	}
	
	/* (non-Javadoc)
	 * @see edu.buffalo.cse.ir.wikiindexer.indexer.Writeable#writeToDisk()
	 */
	public void writeToDisk() throws IndexerException {
		// TODO Implement this method

	}

	/* (non-Javadoc)
	 * @see edu.buffalo.cse.ir.wikiindexer.indexer.Writeable#cleanUp()
	 */
	public void cleanUp() {
		// TODO Implement this method

	}
	
	/**
	 * Method to check if the given value exists in the dictionary or not
	 * Unlike the subclassed lookup methods, it only checks if the value exists
	 * and does not change the underlying data structure
	 * @param value: The value to be looked up
	 * @return true if found, false otherwise
	 */
	public boolean exists(String value) {
		//TODO Implement this method
		if(termDictionary.get(value)!=null)
		{
			return true;
		}
		return false;
	}
	
	/**
	 * MEthod to lookup a given string from the dictionary.
	 * The query string can be an exact match or have wild cards (* and ?)
	 * Must be implemented ONLY AS A BONUS
	 * @param queryStr: The query string to be searched
	 * @return A collection of ordered strings enumerating all matches if found
	 * null if no match is found
	 */
	public Collection<String> query(String queryStr) {
		//TODO: Implement this method (FOR A BONUS)
		ArrayList<String> keyMatches = new ArrayList<String>();
		
		Iterator<String> keyIterator = keyMatches.iterator();
		Set<String>keySet = termDictionary.keySet();
		
		Pattern queryPattern = Pattern.compile(queryStr);
		
		Iterator<String> setIterator = keySet.iterator();
		
		while(setIterator.hasNext())
		{
			String key = setIterator.next();
			Matcher m=queryPattern.matcher(key);
			
			if(m.matches())
			{
				keyMatches.add(key);
			}
			
		}
		System.out.println("The keys found matcing the query are : \n" );
		while(keyIterator.hasNext())
		{
			System.out.println(keyIterator.next()+"\n");
		}
		
		
		
		return null;
	}
	
	/**
	 * Method to get the total number of terms in the dictionary
	 * @return The size of the dictionary
	 */
	public int getTotalTerms() {
		//TODO: Implement this method
		return termDictionary.size();
		
		
	}
}
