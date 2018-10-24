package sai.norms.sai.normativeReasoner;


import sai.util.reasoner.BasicReasonerHttpGUI;
import sai.util.reasoner.jason.JasonReasoner;
import jason.asSyntax.Atom;
import jason.asSyntax.LogicalFormula;


/**
 * A customized reasoner to reason about norms.
 * Notice that this classe only provides the means to deduce normative facts based on already known facts. 
 * The addition of new facts is done by an external element. 
 * 
 * @author maiquel
 *
 *particular facts (related to the normative model):
 *  - instance(A,D,I,Cd) :- the agent A is D\in{obliged,prohibited} to do I until the deadline Cd
 *  - fulfilled_instance(A,D,I,Cd) :- the instance (A,D,I,Cd) has been fulfilled 
 *  - violated_instance(A,D,I,Cd) :- the instance (A,D,I,Cd) has been violated
 *
 *rules: 
 *   toInstantiate(A,I,Ca,Cd) - returns the instances that should be created 
 *
 */




public class NormativeReasoner extends JasonReasoner{
	

	
	public NormativeReasoner(){	
		super(BasicReasonerHttpGUI.get(8002));
		
		
		try {
			assertValue("toAddObliged(A,I,Ca,Cd):-obligation(A,I,Ca,Cd)&Ca&not(instance(A,obliged,I,Cd))&not(fulfilled_instance(A,obliged,I,Cd))&not(violated_instance(A,obliged,I,Cd))&not(Cd)");
			//assertValue("toAddObliged(A,I,Ca,Cd):-obligation(A,I,Ca,Cd)&Ca&not(instance(A,obliged,I,Cd))");
			assertValue("toAddProhibited(A,I,Ca,Cd):-prohibition(A,I,Ca,Cd)&Ca&not(instance(A,prohibited,I,Cd))&not(fulfilled_instance(A,prohibited,I,Cd))&not(violated_instance(A,prohibited,I,Cd))&not(Cd)");
			//assertValue("toAddFulfilledObligation(A,I,Ca,Cd):-obliged(A,I,Ca,Cd)&not(Cd)&I");
			assertValue("toAddFulfilledObligation(A,I,Ca,Cd):-obliged(A,I,Ca,Cd)&I&not(fulfilled(obliged(A,I,Ca,Cd)))");
			assertValue("toAddFulfilledProhibition(A,I,Ca,Cd):-prohibited(A,I,Ca,Cd)&Cd&not(I)");
			assertValue("toAddViolatedProhibition(A,I,Ca,Cd):-prohibited(A,I,Ca,Cd)&I&not(Cd)");
			assertValue("toAddViolatedObligation(A,I,Ca,Cd):-obliged(A,I,Ca,Cd)&not(I)&Cd&not(violated_instance(A,obliged,I,Cd))");

						
			assertValue("toInstantiate(A,I,Ca,Cd):-toAddObliged(A,I,Ca,Cd)|toAddProhibited(A,I,Ca,Cd)");
			assertValue("violated(A,D,I,Cd):-instance(A,D,I,Cd)&((D==obliged&Cd&not(I))|(D==prohibited&not(Cd)&I))");
			assertValue("fulfilled(A,D,I,Cd):-instance(A,D,I,Cd)&((D==obliged&not(Cd)&I)|(D==prohibited&Cd&not(I)))");		//assertValue("violated(A,D,I,Cd):-instance(A,D,I,Cd)&((d==obliged&Cd&not(I)|(d==prohibited&not(Cd)&I))");


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public void addObligation(Atom agent, LogicalFormula aim, LogicalFormula activationCondition, LogicalFormula deadlineCondition) throws Exception{
		assertValue("obligation(" + agent.toString() + "," + aim.toString() + "," + activationCondition.toString() + "," + deadlineCondition +")");
	}
	
	
	
	public void addProhibition(Atom agent, LogicalFormula aim, LogicalFormula activationCondition, LogicalFormula deadlineCondition) throws Exception{
			assertValue("prohibition(" + agent.toString() + "," + aim.toString() + "," + activationCondition.toString() + "," + deadlineCondition + ")");
	}
	
	
	

}
