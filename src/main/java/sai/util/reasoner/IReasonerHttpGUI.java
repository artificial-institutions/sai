package sai.util.reasoner;


/**
 * 
 * @author maiquel
 *
 */

public interface IReasonerHttpGUI extends IReasonerGUI {
	
	/**
	 * Handles the facts from the reasoner to produce the expected output
	 * @return
	 */
	public String handleFacts();

}
