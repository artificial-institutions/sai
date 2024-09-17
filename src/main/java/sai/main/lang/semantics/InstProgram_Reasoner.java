package sai.main.lang.semantics;

import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.parseFormula;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import sai.main.exception.StatusFunctionNotFoundException;
import sai.main.lang.parser.FormulaAdapter;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.AgentStatusFunction;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.main.lang.semantics.statusFunction.StatusFunction;
import sai.util.reasoner.IReasoner;




/**
 * An institutional program associated to a constitutive reasoner.  
 * 
 * 
 * 
 * @author maiquel
 *
 */

public class InstProgram_Reasoner extends InstProgram{

	private IReasoner reasoner;		
	private int varCount = 0;

	public InstProgram_Reasoner(IReasoner reasoner){
		super();
		//setReasoner(reasoner);
		this.reasoner = reasoner;

	}

	
	
	public IReasoner getReasoner(){
		return this.reasoner;
	}

	@Override
	public StatusFunction addStatusFunction(StatusFunction sf) throws Exception  {
		String lit = "";
		if (sf instanceof AgentStatusFunction) {
			lit = "sai__af(" + sf.toString() + ")";

		}else
			if (sf instanceof EventStatusFunction) {
				lit = "sai__ef(" + renameVars(sf.getId()) + ")";

			}else
				if (sf instanceof StateStatusFunction) 
					lit ="sai__sf(" + renameVars(sf.getId()) + ")";
		reasoner.assertValue(lit);		
		return super.addStatusFunction(sf);
	}

	
	/* customize variables with a custmized sai variable */
	private Literal renameVars(Literal literal) {
		for(int i=0;i<literal.getArity();i++)
			if(literal.getTerm(i).isVar()) {
				literal.setTerm(i, createVar("Sai__Var__" + varCount++ +"__" + literal.getTerm(i)));
				
			}
		return literal;
	}



	@Override
	public ConstitutiveRule addConstitutiveRule(ConstitutiveRule crule) throws Exception	{		

		if(crule.getY()==null || getStatusFunctionByName(crule.getY().toString())==null) {			
			throw new StatusFunctionNotFoundException();
		}


		if((getStatusFunctionByName(crule.getY().toString()) instanceof StateStatusFunction)&&(!crule.getX().isVar())&&(getStatusFunctionByName(crule.getX().toString())==null)){	//if Y is a state status function, the term X is added to the term M, thus it is not necessary add "true" to the term M
			if(crule.getM()==null||crule.getM().toString()=="true")
				crule.setM(parseFormula(crule.getX().toString()));
			else
				crule.setM(parseFormula("(" + crule.getX() + ")&(" + crule.getM()+")" ));
		}
		else
			if(crule.getM()==null){				
				crule.setM(parseFormula("true"));
			}


		String rule = "sai__crule(";
		if(crule.getX().toString().equals("_")){ //the parser (sai_constitutveListenerImpl.java) returns "_" when termX is null.
			crule.setX(new Pred(createLiteral("sai__freestandingY")));
		}
		else
			if((getStatusFunctionByName(crule.getX().toString())!=null)&(!crule.getX().isVar())){ 
				if(getStatusFunctionByName(crule.getX().toString()) instanceof EventStatusFunction){
					Pred p = new Pred(crule.getX().getFunctor());
					p.addTerms(crule.getX().getTerms());				
					crule.setM(parseFormula(crule.getM().toString() + " & sai__is(SaiSF,"+ p +"," + crule.getX().getAnnot("sai__agent").getTerm(0) + ",_)"));
				}else{
					crule.setM(parseFormula(crule.getM().toString() + " & sai__is(SaiSF,"+ crule.getX().toString() +",_)"));
				}
				crule.setX(new Pred(createVar("SaiSF")));
			} 



		if(crule.getY()instanceof EventStatusFunction)
			rule=rule+"event("+crule.getX()+")";
		else			
			rule=rule+crule.getX();



		rule = rule +","+crule.getY()+",";
		if(crule.getT()==null)
			rule = rule + "true";
		else{				
			if(crule.getT() instanceof EventStatusFunction)
				rule = rule + "is(_,"+crule.getT().toString()+ ",_)";
			else
				rule = rule + "sigmaE("+crule.getT().toString() + ")";
		}


		rule = rule + ",";

		/* In the case of state-status function, the term X is attached to the term M due to substitutions*/
		//if(getStatusFunctionByName(crule.getY().toString()) instanceof StateStatusFunction){
		//	rule = rule + "("+crule.getX().toString() + ")&";
		//}

		//rule = rule + crule.getM();
		rule = rule + FormulaAdapter.adaptFormula( crule.getM().toString().replaceAll("((_)+(\\d+)(Var)?)+", "Var$3"), this);
		rule = rule + ")";


		reasoner.assertValue(rule);
		return super.addConstitutiveRule(crule);
	}

	public boolean CheckBel(String formula) throws Exception{
		return reasoner.check(formula);

	}

}
