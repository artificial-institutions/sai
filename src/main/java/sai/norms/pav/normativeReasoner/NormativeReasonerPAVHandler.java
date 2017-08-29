package sai.norms.pav.normativeReasoner;

import jason.asSemantics.Unifier;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Implements the operational semantics as proposed in http://dx.doi.org/10.1007/978-3-319-07314-9_19
 * 
 * 
 * @author maiquel
 *
 */
public class NormativeReasonerPAVHandler {

	private NormativeReasonerPAV reasoner;
	private ArrayList<String> lastAdded = new ArrayList<String>();
	private ArrayList<String> lastFulfilled = new ArrayList<String>();
	private ArrayList<String> lastViolated = new ArrayList<String>();

	public NormativeReasonerPAVHandler(NormativeReasonerPAV reasoner) {
		super();
		this.reasoner = reasoner;
	}

	
	public NormativeReasonerPAV getReasoner(){
		return this.reasoner;
	}

	private String adaptTerm(String term){
		return term.replaceAll("((_)(\\d)+(Var)?)+", "Var");
	}

	
	public ArrayList<String> getLastAdded(){
		return this.lastAdded;
	}
	
	public ArrayList<String> getLastFulfilled(){
		return this.lastFulfilled;
	}
	
	public ArrayList<String> getLastViolated(){
		return this.lastViolated;
	}
	
	/**
	 * Handle the reasoner updating the normative state
	 */
	public void updateState(){
		
		
		
		ArrayList<String> toAdd = new ArrayList<String>();
		ArrayList<String> toRemove = new ArrayList<String>();

		this.lastAdded.clear();
		this.lastFulfilled.clear();
		this.lastViolated.clear();
		
		try {

			do{
				toAdd.clear();
				toRemove.clear();
				
				Iterator<Unifier> iActive = reasoner.findall("xactive(A,Fa,Fm,Fd,Fr,Timeout)&not(as(A,Fa,Fm,Fd,Fr,Timeout))");
				while(iActive.hasNext()){
					Unifier un = iActive.next();
					toAdd.add("as("+adaptTerm(un.get("A").toString())+","+ adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					this.lastAdded.add("as("+adaptTerm(un.get("A").toString())+","+ adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}	
				
				Iterator<Unifier> iViol = reasoner.findall("xviol(A,Fa,Fm,Fd,Fr,Timeout)&not(vs(A,Fa,Fm,Fd,Fr,Timeout))");
				while(iViol.hasNext()){
					Unifier un = iViol.next();
					toAdd.add("vs("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					toRemove.add("as("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					this.lastViolated.add("as("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}
				
				
				Iterator<Unifier> iDeactF = reasoner.findall("xdeact_f(A,Fa,Fm,Fd,Fr,Timeout)");
				while(iDeactF.hasNext()){
					Unifier un = iDeactF.next();
					toAdd.add("ds("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString()+","+un.get("Timeout").toString())+")");
					toRemove.add("as("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					this.lastFulfilled.add("as("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}
				
				Iterator<Unifier> iDeactR = reasoner.findall("xdeact_r(A,Fa,Fm,Fd,Fr,Timeout)");
				while(iDeactR.hasNext()){
					Unifier un = iDeactR.next();
					toAdd.add("ds("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					toRemove.add("vs("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					this.lastFulfilled.add("vs("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}
				
				Iterator<Unifier> iFailed = reasoner.findall("xfailed(A,Fa,Fm,Fd,Fr,Timeout)");
				while(iFailed.hasNext()){
					Unifier un = iFailed.next();
					toAdd.add("fs("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
					toRemove.add("vs("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}
				
				//norms deactivated (fulfilled) whose maintenance condition does not hold can be removed.
				//if they are not removed, new instances of the same norm are not activated
				Iterator<Unifier> iDeactivated_to_remove = reasoner.findall("ds(A,Fa,Fm,Fd,Fr,Timeout)&not(Fm)");
				while(iDeactivated_to_remove.hasNext()){
					Unifier un = iDeactivated_to_remove.next();
					toRemove.add("ds("+adaptTerm(un.get("A").toString())+","+adaptTerm(un.get("Fa").toString())+","+adaptTerm(un.get("Fm").toString())+","+adaptTerm(un.get("Fd").toString())+","+adaptTerm(un.get("Fr").toString())+","+adaptTerm(un.get("Timeout").toString())+")");
				}

				
				for(String s:toAdd){
					reasoner.assertValue(s);
				}
				
				for(String s:toRemove){
					reasoner.retract(s);
				}
				
			}while(toAdd.size()>0|toRemove.size()>0);						
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}
