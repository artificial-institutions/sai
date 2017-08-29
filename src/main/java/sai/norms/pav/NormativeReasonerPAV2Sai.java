package sai.norms.pav;


import java.util.ArrayList;

import jason.RevisionFailedException;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import static jason.asSyntax.ASSyntax.parseLiteral;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.main.institution.INormativeEngine;
import sai.norms.pav.normativeReasoner.IPAVNormativeListener;
import sai.norms.pav.normativeReasoner.NormativeReasonerPAV;
import sai.norms.pav.normativeReasoner.NormativeReasonerPAVHandler;

public class NormativeReasonerPAV2Sai implements INormativeEngine {
	
	private NormativeReasonerPAV reasoner = new NormativeReasonerPAV();
	private NormativeReasonerPAVHandler handler = new NormativeReasonerPAVHandler(reasoner);
	private ArrayList<IPAVNormativeListener> saiNormativeListeners = new ArrayList<IPAVNormativeListener>();
	

	
	public void addPAVNormativeReasonerListener(IPAVNormativeListener listener){
		saiNormativeListeners.add(listener);
	}
	
	@Override
	public void addStateAssignment(String assignee, StateStatusFunction sf) {
		try {
			this.reasoner.assertValue("sai__is("+assignee+","+sf.toString()+")" );
			this.reasoner.assertValue(sf.toString());
		} catch (RevisionFailedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addAgentAssignment(String assignee, AgentStatusFunction sf) {
		try {
			this.reasoner.assertValue("sai__is("+assignee+","+sf.toString()+")" );
		} catch (RevisionFailedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void addEventAssignment(String assignee, EventStatusFunction sf,
			AgentStatusFunction agent) {
		try {
			this.reasoner.assertValue("sai__is("+assignee+","+sf.toString()+","+agent.toString()+")" );
			this.reasoner.assertValue("sai__event("+sf.toString()+","+agent.toString()+")");
			this.reasoner.assertValue(sf.toString()+"[sai__agent("+agent.toString()+")]");
			this.reasoner.assertValue(sf.toString());
		} catch (RevisionFailedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeStateAssignment(String assignee, StateStatusFunction sf) {
		try {
			this.reasoner.retract("sai__is("+assignee+","+sf.toString()+")" );
			this.reasoner.retract(sf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeAgentAssignment(String assignee, AgentStatusFunction sf) {
		try {
			this.reasoner.retract("sai__is("+assignee+","+sf.toString()+")" );
			this.reasoner.retract(sf.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeEventAssignment(String assignee, EventStatusFunction sf,
			AgentStatusFunction agent) {
		try {
			this.reasoner.retract("sai__is("+assignee+","+sf.toString()+","+agent.toString()+")" );
			this.reasoner.retract("sai__event("+sf.toString()+","+agent.toString()+")");
			this.reasoner.retract(sf.toString());
		} catch (RevisionFailedException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@Override
	public void updateState() {
		this.handler.updateState();
		
		
		for(String s:this.handler.getLastAdded()){				
			for(IPAVNormativeListener snl:saiNormativeListeners){
				try {
					snl.addNormInstance(new Pred(parseLiteral(s)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(String s:this.handler.getLastFulfilled()){				
			for(IPAVNormativeListener snl:saiNormativeListeners){
				try {
					snl.informFulfilledInstance(new Pred(parseLiteral(s)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(String s:this.handler.getLastViolated()){				
			for(IPAVNormativeListener snl:saiNormativeListeners){
				try {
					snl.informViolatedInstance(new Pred(parseLiteral(s)));
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}
		}


	}

	@Override
	public void setInstitutionalProgram(InstProgram instProgram) {
		// TODO Auto-generated method stub

	}

		
	
	public void addNorm(String norm) throws RevisionFailedException, ParseException{
		this.reasoner.assertValue(norm);
	}

}
