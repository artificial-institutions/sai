// Generated from sai_normative.g by ANTLR 4.6

package sai.main.lang.parser;

import jason.asSyntax.Atom;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link sai_normativeParser}.
 */
public interface sai_normativeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sai}.
	 * @param ctx the parse tree
	 */
	void enterSai(sai_normativeParser.SaiContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sai}.
	 * @param ctx the parse tree
	 */
	void exitSai(sai_normativeParser.SaiContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#normative_spec}.
	 * @param ctx the parse tree
	 */
	void enterNormative_spec(sai_normativeParser.Normative_specContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#normative_spec}.
	 * @param ctx the parse tree
	 */
	void exitNormative_spec(sai_normativeParser.Normative_specContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#institution_id}.
	 * @param ctx the parse tree
	 */
	void enterInstitution_id(sai_normativeParser.Institution_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#institution_id}.
	 * @param ctx the parse tree
	 */
	void exitInstitution_id(sai_normativeParser.Institution_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#status_functions}.
	 * @param ctx the parse tree
	 */
	void enterStatus_functions(sai_normativeParser.Status_functionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#status_functions}.
	 * @param ctx the parse tree
	 */
	void exitStatus_functions(sai_normativeParser.Status_functionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#agent_sf_decl}.
	 * @param ctx the parse tree
	 */
	void enterAgent_sf_decl(sai_normativeParser.Agent_sf_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#agent_sf_decl}.
	 * @param ctx the parse tree
	 */
	void exitAgent_sf_decl(sai_normativeParser.Agent_sf_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#agent_sf_list}.
	 * @param ctx the parse tree
	 */
	void enterAgent_sf_list(sai_normativeParser.Agent_sf_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#agent_sf_list}.
	 * @param ctx the parse tree
	 */
	void exitAgent_sf_list(sai_normativeParser.Agent_sf_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#event_sf_decl}.
	 * @param ctx the parse tree
	 */
	void enterEvent_sf_decl(sai_normativeParser.Event_sf_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#event_sf_decl}.
	 * @param ctx the parse tree
	 */
	void exitEvent_sf_decl(sai_normativeParser.Event_sf_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#event_sf_list}.
	 * @param ctx the parse tree
	 */
	void enterEvent_sf_list(sai_normativeParser.Event_sf_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#event_sf_list}.
	 * @param ctx the parse tree
	 */
	void exitEvent_sf_list(sai_normativeParser.Event_sf_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#state_sf_decl}.
	 * @param ctx the parse tree
	 */
	void enterState_sf_decl(sai_normativeParser.State_sf_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#state_sf_decl}.
	 * @param ctx the parse tree
	 */
	void exitState_sf_decl(sai_normativeParser.State_sf_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#state_sf_list}.
	 * @param ctx the parse tree
	 */
	void enterState_sf_list(sai_normativeParser.State_sf_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#state_sf_list}.
	 * @param ctx the parse tree
	 */
	void exitState_sf_list(sai_normativeParser.State_sf_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#norms}.
	 * @param ctx the parse tree
	 */
	void enterNorms(sai_normativeParser.NormsContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#norms}.
	 * @param ctx the parse tree
	 */
	void exitNorms(sai_normativeParser.NormsContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#norm}.
	 * @param ctx the parse tree
	 */
	void enterNorm(sai_normativeParser.NormContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#norm}.
	 * @param ctx the parse tree
	 */
	void exitNorm(sai_normativeParser.NormContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(sai_normativeParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(sai_normativeParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(sai_normativeParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(sai_normativeParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#attribute}.
	 * @param ctx the parse tree
	 */
	void enterAttribute(sai_normativeParser.AttributeContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#attribute}.
	 * @param ctx the parse tree
	 */
	void exitAttribute(sai_normativeParser.AttributeContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#deontic}.
	 * @param ctx the parse tree
	 */
	void enterDeontic(sai_normativeParser.DeonticContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#deontic}.
	 * @param ctx the parse tree
	 */
	void exitDeontic(sai_normativeParser.DeonticContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#aim}.
	 * @param ctx the parse tree
	 */
	void enterAim(sai_normativeParser.AimContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#aim}.
	 * @param ctx the parse tree
	 */
	void exitAim(sai_normativeParser.AimContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#deadline}.
	 * @param ctx the parse tree
	 */
	void enterDeadline(sai_normativeParser.DeadlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#deadline}.
	 * @param ctx the parse tree
	 */
	void exitDeadline(sai_normativeParser.DeadlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#or_else}.
	 * @param ctx the parse tree
	 */
	void enterOr_else(sai_normativeParser.Or_elseContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#or_else}.
	 * @param ctx the parse tree
	 */
	void exitOr_else(sai_normativeParser.Or_elseContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#agent_sf}.
	 * @param ctx the parse tree
	 */
	void enterAgent_sf(sai_normativeParser.Agent_sfContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#agent_sf}.
	 * @param ctx the parse tree
	 */
	void exitAgent_sf(sai_normativeParser.Agent_sfContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#event_sf}.
	 * @param ctx the parse tree
	 */
	void enterEvent_sf(sai_normativeParser.Event_sfContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#event_sf}.
	 * @param ctx the parse tree
	 */
	void exitEvent_sf(sai_normativeParser.Event_sfContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#state_sf}.
	 * @param ctx the parse tree
	 */
	void enterState_sf(sai_normativeParser.State_sfContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#state_sf}.
	 * @param ctx the parse tree
	 */
	void exitState_sf(sai_normativeParser.State_sfContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sf_formula}.
	 * @param ctx the parse tree
	 */
	void enterSf_formula(sai_normativeParser.Sf_formulaContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sf_formula}.
	 * @param ctx the parse tree
	 */
	void exitSf_formula(sai_normativeParser.Sf_formulaContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sff_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterSff_or_expr(sai_normativeParser.Sff_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sff_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitSff_or_expr(sai_normativeParser.Sff_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sff_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterSff_and_expr(sai_normativeParser.Sff_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sff_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitSff_and_expr(sai_normativeParser.Sff_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sff_rel}.
	 * @param ctx the parse tree
	 */
	void enterSff_rel(sai_normativeParser.Sff_relContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sff_rel}.
	 * @param ctx the parse tree
	 */
	void exitSff_rel(sai_normativeParser.Sff_relContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#arithm_term}.
	 * @param ctx the parse tree
	 */
	void enterArithm_term(sai_normativeParser.Arithm_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#arithm_term}.
	 * @param ctx the parse tree
	 */
	void exitArithm_term(sai_normativeParser.Arithm_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#arithm_factor}.
	 * @param ctx the parse tree
	 */
	void enterArithm_factor(sai_normativeParser.Arithm_factorContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#arithm_factor}.
	 * @param ctx the parse tree
	 */
	void exitArithm_factor(sai_normativeParser.Arithm_factorContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#sff_atom}.
	 * @param ctx the parse tree
	 */
	void enterSff_atom(sai_normativeParser.Sff_atomContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#sff_atom}.
	 * @param ctx the parse tree
	 */
	void exitSff_atom(sai_normativeParser.Sff_atomContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#pred}.
	 * @param ctx the parse tree
	 */
	void enterPred(sai_normativeParser.PredContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#pred}.
	 * @param ctx the parse tree
	 */
	void exitPred(sai_normativeParser.PredContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 */
	void enterList_of_pred_terms(sai_normativeParser.List_of_pred_termsContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 */
	void exitList_of_pred_terms(sai_normativeParser.List_of_pred_termsContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#pred_terms}.
	 * @param ctx the parse tree
	 */
	void enterPred_terms(sai_normativeParser.Pred_termsContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#pred_terms}.
	 * @param ctx the parse tree
	 */
	void exitPred_terms(sai_normativeParser.Pred_termsContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#pred_term}.
	 * @param ctx the parse tree
	 */
	void enterPred_term(sai_normativeParser.Pred_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#pred_term}.
	 * @param ctx the parse tree
	 */
	void exitPred_term(sai_normativeParser.Pred_termContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#annotation}.
	 * @param ctx the parse tree
	 */
	void enterAnnotation(sai_normativeParser.AnnotationContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#annotation}.
	 * @param ctx the parse tree
	 */
	void exitAnnotation(sai_normativeParser.AnnotationContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#list}.
	 * @param ctx the parse tree
	 */
	void enterList(sai_normativeParser.ListContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#list}.
	 * @param ctx the parse tree
	 */
	void exitList(sai_normativeParser.ListContext ctx);
	/**
	 * Enter a parse tree produced by {@link sai_normativeParser#list_term}.
	 * @param ctx the parse tree
	 */
	void enterList_term(sai_normativeParser.List_termContext ctx);
	/**
	 * Exit a parse tree produced by {@link sai_normativeParser#list_term}.
	 * @param ctx the parse tree
	 */
	void exitList_term(sai_normativeParser.List_termContext ctx);
}