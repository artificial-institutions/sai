package sai.main.lang.parser;

import java.util.ArrayList;
import java.util.List;

import sai.main.lang.parser.sai_normativeParser.Pred_termContext;

public class FormulaCheckerListener extends sai_normativeBaseListener {
	private ArrayList<String> terms = new ArrayList<String>();

	@Override
	public void exitPred_term(Pred_termContext ctx) {
		terms.add(ctx.getText());
	}

	
	public List<String> getTerms(){
		return this.terms;
	}
	

}
