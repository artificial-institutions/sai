package sai.main.lang.semantics;

import static jason.asSyntax.ASSyntax.createLiteral;
import static jason.asSyntax.ASSyntax.createVar;
import static jason.asSyntax.ASSyntax.parseFormula;
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

	public InstProgram_Reasoner(IReasoner reasoner){
		super();
		//setReasoner(reasoner);
		this.reasoner = reasoner;

	}

	/*public void setReasoner(IReasoner reasoner){
		this.reasoner = reasoner;
	}*/

	/*

	@Override
	public Norm addNorm(Norm norm) throws Exception {				

		String lit = "sai__norm("+norm.getAttribute() +","+
				norm.getDeontic().toString()+","+
				norm.getAim().toString()+",";


		if(norm.getCondition()==null)
			lit = lit + "true,";
		else{
			lit = lit + norm.getCondition() + ",";
		}

		if(norm.getOrElse()==null)
			lit = lit + "true,";
		else
			lit = lit + norm.getOrElse().toString() + ",";
		if(norm.getDeadline()==null)
			lit = lit + "false";
		else{
			lit = lit + norm.getDeadline().toString();

		}

		lit = lit + ")";


		try{
			reasoner.assertValue(lit);
		}catch(Exception e){
			e.printStackTrace();
		}



		return super.addNorm(norm);
	}
	 */

	@Override
	public StatusFunction addStatusFunction(StatusFunction sf) throws Exception  {
		String lit = "";
		if (sf instanceof AgentStatusFunction) {
			lit = "sai__af(" + sf.toString() + ")";

		}else
			if (sf instanceof EventStatusFunction) {
				lit = "sai__ef(" + sf.toString() + ")";

			}else
				if (sf instanceof StateStatusFunction) {
					lit ="sai__sf(" + sf.toString() + ")";

				}
		reasoner.assertValue(lit);		
		return super.addStatusFunction(sf);
	}




	@Override
	public ConstitutiveRule addConstitutiveRule(ConstitutiveRule crule) throws Exception	{		

		if(crule.getY()==null || getStatusFunctionByName(crule.getY().toString())==null) {			
			throw new StatusFunctionNotFoundException();
		}


		if((getStatusFunctionByName(crule.getY().toString()) instanceof StateStatusFunction)&&(!crule.getX().isVar())&&(getStatusFunctionByName(crule.getX().toString())==null)){	//if Y is a state status function, the term X is added to the term M, thus it is not necessary add "true" to the term M
			if(crule.getM()==null||crule.getM().toString()=="true")
				crule.setM(parseFormula(crule.getX().toString()));
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





	/*
	class FormulaParser extends sai_normativeBaseListener{
		private ArrayList<String> terms = new ArrayList<String>();


		@Override
		public void exitPred_term(Pred_termContext ctx) {
			terms.add(ctx.getText());

		}


		public List<String> getTerms(){
			return this.terms;
		}		

	}

	class NormParser extends sai_normativeBaseListener {
		String sNorm = "";


		public void exitSff_and_expr(@NotNull sai_normativeParser.Sff_and_exprContext ctx) {
			if(ctx.TK_AND()!= null)
				this.sNorm =  ctx.TK_AND().getText()+ this.sNorm ;


		}





		String getResult(){
			return this.sNorm;
		}

	}		
	 */
}
