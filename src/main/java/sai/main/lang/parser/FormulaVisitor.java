package sai.main.lang.parser;

import sai.main.lang.parser.sai_constitutiveParser.Sf_formulaContext;
import sai.main.lang.parser.sai_constitutiveParser.Sff_and_exprContext;
import sai.main.lang.parser.sai_constitutiveParser.Sff_or_exprContext;

public class FormulaVisitor extends sai_constitutiveBaseVisitor<Void> {

	protected String formula;

	public String getFormula(){
		return this.formula;
	}

	@Override
	public Void visitSf_formula(Sf_formulaContext ctx) {		
		formula = "";
		visitSff_or_expr(ctx.sff_or_expr());
		return null;
	}

	@Override
	public Void visitSff_and_expr(Sff_and_exprContext ctx) {
		if(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().NEGATION()!=null){
			formula = formula.concat("not");
		}
		if(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().sff_or_expr()!=null){
			formula = formula.concat("(");
			visitSff_or_expr(ctx.sff_rel().arithm_term().arithm_factor().sff_atom().sff_or_expr());
			formula = formula.concat(")");
		}
		else{
			if(ctx.sff_rel().TK_IS()!=null){
				formula = formula.concat("sai__is(" + ctx.sff_rel().arithm_term().getText() + "," + ctx.sff_rel().sff_rel().getText() + ",_)");
			}
			else
				if(ctx.sff_rel().arithm_term().arithm_factor().INTMOD()!=null){
					formula = formula +  "((" + ctx.sff_rel().arithm_term().arithm_factor().sff_atom().getText() + ")mod(" + ctx.sff_rel().arithm_term().arithm_factor().arithm_factor().getText() + "))" + ctx.sff_rel().TK_REL_OP().getText() + ctx.sff_rel().sff_rel().getText();
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
	public Void visitSff_or_expr(Sff_or_exprContext ctx) {		
		//visit(ctx.sff_and_expr());
		visitSff_and_expr(ctx.sff_and_expr());
		if(ctx.sff_or_expr()!=null){
			//System.out.println("|");
			formula = formula.concat("|");
			//visit(ctx.sff_or_expr());
			visitSff_or_expr(ctx.sff_or_expr());
		}
		return null;
	}



}
