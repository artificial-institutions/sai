package sai.main.lang.parser;


public class NormativeFormulaVisitor extends sai_normativeBaseVisitor<Void> {
	
private String formula;
	
	public String getFormula(){
		return this.formula;
	}

	
 	@Override
	public Void visitSf_formula(sai.main.lang.parser.sai_normativeParser.Sf_formulaContext ctx) {
		formula = "";
		//visit(ctx.sff_or_expr());
		visitSff_or_expr(ctx.sff_or_expr());
		return null;
	}
	
	@Override
	public Void visitSff_and_expr(sai.main.lang.parser.sai_normativeParser.Sff_and_exprContext ctx) {
		if(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().NEGATION()!=null)
			formula = formula.concat("not ");
		if(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().sff_or_expr()!=null){
			formula = formula.concat("(");
			visitSff_or_expr(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().sff_or_expr());
			formula = formula.concat(")");
		}
		else{
			if(ctx.sff_rel().TK_IS()!=null){
				formula = formula.concat("sai__is(" + ctx.sff_rel().arithm_term().getText() + "," + ctx.sff_rel().sff_rel().getText() + ")");
			}
			else
				formula = formula.concat(ctx.sff_rel().getText());
		}
		if(ctx.sff_and_expr()!=null){
			formula = formula.concat("&");
			visitSff_and_expr(ctx.sff_and_expr());
		}
		return null;
	}

	@Override
	public Void visitSff_or_expr(sai.main.lang.parser.sai_normativeParser.Sff_or_exprContext ctx) {
		visitSff_and_expr(ctx.sff_and_expr());
		if(ctx.sff_or_expr()!=null){
			formula = formula.concat("|");
			visitSff_or_expr(ctx.sff_or_expr());
		}
		return null;
	}



	

}
