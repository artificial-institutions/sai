package sai.norms.sai.semantics;





/**
 * External classes that want be clients of the SAI normative state must implement this interface
 * @author maiquel
 *
 */

public interface ISAINormativeListener {
	
	public void addNormInstance(NormInstance instance);
	public void removeNormInstance(NormInstance instance);
	public void informFulfilledInstance(NormInstance instance);
	public void informViolatedInstance(NormInstance instance);

}
