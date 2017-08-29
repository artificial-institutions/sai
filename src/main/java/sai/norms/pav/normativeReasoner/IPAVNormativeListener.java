package sai.norms.pav.normativeReasoner;


import jason.asSyntax.Pred;

/**
 * External classes that want be clients of the SAI normative state must implement this interface
 * @author maiquel
 *
 */

public interface IPAVNormativeListener {
	
	public void addNormInstance(Pred instance);
	public void removeNormInstance(Pred instance);
	public void informFulfilledInstance(Pred instance);
	public void informViolatedInstance(Pred instance);

}
