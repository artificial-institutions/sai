package sai.norms.sai;

import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import sai.main.institution.INormativeEngine;
import jason.RevisionFailedException;
import jason.asSemantics.Unifier;
import jason.asSyntax.Atom;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.IAchievableStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.main.lang.semantics.statusFunction.StatusFunction;
import sai.norms.sai.normativeReasoner.NormativeReasoner;
import sai.norms.sai.normativeReasoner.NormativeReasonerHandler;
import sai.norms.sai.semantics.Deontic;
import sai.norms.sai.semantics.ISAINormativeListener;
import sai.norms.sai.semantics.Norm;
import sai.norms.sai.semantics.NormInstance;
import sai.norms.sai.semantics.Obligation;
import sai.norms.sai.semantics.Permission;
import sai.norms.sai.semantics.Prohibition;


/**
 * 
 * This class is the SAI handler of the normative stuff implemented to SAI. 
 * While such normative stuff (normativeReasoner pakage) is generic (i.e. not related to the SAI concepts), 
 * the NormativeReasoner2Sai takes the results of the reasoning and relate them to SAI the concepts.
 * 
 * If a differente normative machinery is used (e.g. NPL), the a simillar class (e.g. NPL2Sai) should be implemented.
 * 
 * @author maiquel
 *
 */

public class NormativeReasoner2Sai implements INormativeEngine {

	private NormativeReasoner reasoner = new NormativeReasoner();
	private NormativeReasonerHandler handler = new NormativeReasonerHandler(reasoner);
	private InstProgram instProgram;
	private ArrayList<ISAINormativeListener> saiNormativeListeners = new ArrayList<ISAINormativeListener>();

	public NormativeReasoner2Sai() {
	}


	/**
	 * Defines the institutional (constitutive) program where the status functions come from
	 * TODO: maybe change to constitutiveProgram instead of institutionalProgram
	 * @param program
	 */
	@Override
	public void setInstitutionalProgram(InstProgram program){
		this.instProgram = program;
	}


	public InstProgram getInstitutionalProgram(){
		return this.instProgram;
	}

	
	public void addSaiNormativeReasonerListener(ISAINormativeListener listener){
		saiNormativeListeners.add(listener);
	}



	/**
	 * Add a norm to the normative reasoner
	 * @param norm
	 */
	public void addNorm(Norm norm){		
		AgentStatusFunction attribute = new AgentStatusFunction(norm.getAttribute());
		Deontic deontic = norm.getDeontic();
		IAchievableStatusFunction aim = norm.getAim();
		LogicalFormula conditionActivation = norm.getCondition();
		LogicalFormula conditionDeadline = norm.getDeadline();
		if(conditionDeadline == null){
			try {
				conditionDeadline = parseFormula("false");
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}

		LogicalFormula formulaAim=null;
		try {
			if(aim instanceof EventStatusFunction){

				formulaAim = parseFormula("sai__event("+aim.toString()+",Agent)");

			}else
				formulaAim = parseFormula(aim.toString());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		try {
			if(deontic instanceof Obligation){
				reasoner.addObligation(createAtom("Agent"), formulaAim, parseFormula(conditionActivation.toString()+"& sai__is(Agent," + attribute.toString() + ")"), conditionDeadline);
			}else
				if(deontic instanceof Prohibition){					
					reasoner.addProhibition(createAtom("Agent"), formulaAim, parseFormula(conditionActivation.toString()+"& sai__is(Agent," + attribute.toString() + ")"), conditionDeadline);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	

	/**
	 * Takes a norm instance as received from the reasoner and returns an instance of NormInstance
	 * @param instance
	 * @return
	 */
	private NormInstance adaptInstance(String instance){
		try {			
			Pred pNorm = new Pred(parseLiteral(instance));
			//replacing vars such as "_999" by "Var" to avoid problems with client interfaces
			LogicalFormula	fDeadline = parseFormula(pNorm.getTerm(3).toString().replaceAll("((_)(\\d)+)+", "Var"));
			Deontic deontic;
			if(pNorm.getTerm(1).toString().equals("obliged"))
				deontic = new Obligation();
			else
				if(pNorm.getTerm(1).toString().equals("prohibited"))
					deontic = new Prohibition();
				else 
					deontic = new Permission();

			//*** First, check whether the status function belongs to the SAI program ***
			StatusFunction sfTemp;
			if(pNorm.getTerm(2).isPred()&((Pred)pNorm.getTerm(2)).getFunctor().toString().equals("sai__event")){ //the reasoner returns event-sfs as sai__event(event). We need here to remove the functor sai__event
				sfTemp = instProgram.getStatusFunctionByName(((Pred)pNorm.getTerm(2)).getTerm(0).toString());	
			}
			else //it it is not an event
				sfTemp = instProgram.getStatusFunctionByName(pNorm.getTerm(2).toString());
			//we have, so far, checked that the aim of the norm is a status function. Below, we check whether this is an IAchievableStatusFunction
			IAchievableStatusFunction fAim;
			if(sfTemp instanceof EventStatusFunction|sfTemp instanceof StateStatusFunction)
				fAim = (IAchievableStatusFunction) sfTemp;
			else
				fAim = null;


			return  new NormInstance((Atom)pNorm.getTerm(0), deontic, fAim,  fDeadline);

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}


	}



	/**
	 * Update the normative state
	 * 
	 */
	@Override
	public void updateState(){
		try {
			
			this.handler.check();



			for(String s:this.handler.getLastAdded()){				
				for(ISAINormativeListener snl:saiNormativeListeners){
					snl.addNormInstance(adaptInstance(s));
				}
			}


			for(String s:this.handler.getLastFulfilled()){
				for(ISAINormativeListener snl:saiNormativeListeners){
					snl.informFulfilledInstance(adaptInstance(s));
				}
			}


			for(String s:this.handler.getLastViolated()){
				for(ISAINormativeListener snl:saiNormativeListeners){
					snl.informViolatedInstance(adaptInstance(s));
				}
			}


			for(String s:this.handler.getLastRemoved()){
				for(ISAINormativeListener snl:saiNormativeListeners){
					snl.removeNormInstance(adaptInstance(s));
				}				
			}

		} catch (Exception e) {
			e.printStackTrace();
		}		
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

	
	//TODO: rewrite to public List<Norm> getNormativeProgram(){
	public List<String> getNormativeProgram(){
		ArrayList<String> list = new ArrayList<String>();
		try {
			Iterator<Unifier> obligations = reasoner.findall("obligation(A,I,Ca,Cd)");
			while(obligations.hasNext()){
				Unifier un = obligations.next();
				list.add("obligation("+un.get("A")+","+un.get("I")+","+un.get("Ca")+","+un.get("Cd")+")");
			}
			Iterator<Unifier> prohibitions = reasoner.findall("prohibited(A,I,Ca,Cd)");
			while(obligations.hasNext()){
				Unifier un = obligations.next();
				list.add("prohibited("+un.get("A")+","+un.get("I")+","+un.get("Ca")+","+un.get("Cd")+")");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
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



}


