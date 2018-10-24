package sai.norms.pav.normativeReasoner;

import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.jason.JasonReasoner;
import jason.RevisionFailedException;
import jason.asSyntax.parser.ParseException;


/**
 * Implements the logics of the normative reasoning.  
 * 
 *  - xactive(A,Fa,Fm,Fd,Fr,Timeout): the instance <A,Fa,Fm,Fd,Fr,Timeout> is to be active in the next state
 *  - xviol(A,Fa,Fm,Fd,Fr,Timeout): the instance <A,Fa,Fm,Fd,Fr,Timeout> is to be violated in the next state
 *  - xdeact_f(A,Fa,Fm,Fd,Fr,Timeout): the instance <A,Fa,Fm,Fd,Fr,Timeout> is to be deactivated by fulfilment in the next state
 *  - xdeact_r(A,Fa,Fm,Fd,Fr,Timeout): the instance <A,Fa,Fm,Fd,Fr,Timeout> is to be deactivated by fulfilment in the next state
 *  - xfailed(A,Fa,Fm,Fd,Fr,Timeout): the instance <A,Fa,Fm,Fd,Fr,Timeout> is to be failed in the next state
 * - A norm is represented by norm(A,Fa,Fm,Fd,Fr,Timeout)
 * - The set of active norms is "as". An active norm os represented by as(A,Fa,Fm,Fd,Fr,Timeout)
 * 
 * @author maiquel
 */
public class NormativeReasonerPAV extends JasonReasoner {
	
	
	
	public NormativeReasonerPAV(){					
		    super(BasicReasonerHttpGUI.get(8004));		
			try {
				assertValue("xactive(A,Fa,Fm,Fd,Fr,Timeout):-(norm(A,Fa,Fm,Fd,Fr,Timeout)&Fa&not(Fd)&not(ds(A,Fa,Fm,Fd,Fr,Timeout)|vs(A,Fa,Fm,Fd,Fr,Timeout)))|as(A,Fa,Fm,Fd,Fr,Timeout)");
				assertValue("xviol(A,Fa,Fm,Fd,Fr,Timeout):-as(A,Fa,Fm,Fd,Fr,Timeout)&not(Fm)");				
				assertValue("xdeact_f(A,Fa,Fm,Fd,Fr,Timeout):-as(A,Fa,Fm,Fd,Fr,Timeout)&Fd&Fm");
				assertValue("xdeact_r(A,Fa,Fm,Fd,Fr,Timeout):-vs(A,Fa,Fm,Fd,Fr,Timeout)&Fr");
				assertValue("xfailed(A,Fa,Fm,Fd,Fr,Timeout):-vs(A,Fa,Fm,Fd,Fr,Timeout)&Timeout");
			} catch (RevisionFailedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
	}

}
