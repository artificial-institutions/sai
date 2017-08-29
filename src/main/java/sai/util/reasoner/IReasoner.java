package sai.util.reasoner;

import java.util.Iterator;

/**
 * All the reasoners (e.g. based on Jason, Drolls, jess) must implement this interface
 */

public interface IReasoner {
	/**
	 * adds a value (or a fact) to the reasoner's base
	 * @param value
	 * @throws Exception
	 */
	public void  assertValue(String value) throws Exception;
	
	/**
	 * Returns true if the reasoner find the goal "formula"
	 * @param formula
	 * @return
	 */
	public boolean check(String formula) throws Exception;
	
	public Iterator<?> getBeliefs();
	
	public Iterator<?> findall(String formula) throws Exception;
	
	public void retract(String value) throws Exception;

}
