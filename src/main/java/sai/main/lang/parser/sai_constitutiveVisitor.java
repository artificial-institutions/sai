// Generated from grammar/sai_constitutive.g by ANTLR 4.8

package sai.main.lang.parser;


import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sai_constitutiveParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sai_constitutiveVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#constitutive_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstitutive_spec(sai_constitutiveParser.Constitutive_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#normative_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormative_id(sai_constitutiveParser.Normative_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#status_functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatus_functions(sai_constitutiveParser.Status_functionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_decl(sai_constitutiveParser.Agent_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_list(sai_constitutiveParser.Agent_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_decl(sai_constitutiveParser.Event_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_list(sai_constitutiveParser.Event_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_decl(sai_constitutiveParser.State_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_list(sai_constitutiveParser.State_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#constitutive_rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstitutive_rules(sai_constitutiveParser.Constitutive_rulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#const_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_rule(sai_constitutiveParser.Const_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(sai_constitutiveParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#count_as_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount_as_stat(sai_constitutiveParser.Count_as_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY(sai_constitutiveParser.YContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(sai_constitutiveParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(sai_constitutiveParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM(sai_constitutiveParser.MContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf(sai_constitutiveParser.Agent_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf(sai_constitutiveParser.Event_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf(sai_constitutiveParser.State_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_x(sai_constitutiveParser.Agent_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_x(sai_constitutiveParser.Event_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_x(sai_constitutiveParser.State_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sf_formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSf_formula(sai_constitutiveParser.Sf_formulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_or_expr(sai_constitutiveParser.Sff_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_and_expr(sai_constitutiveParser.Sff_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_rel(sai_constitutiveParser.Sff_relContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#arithm_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_term(sai_constitutiveParser.Arithm_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#arithm_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_factor(sai_constitutiveParser.Arithm_factorContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_atom(sai_constitutiveParser.Sff_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sai__is_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSai__is_term(sai_constitutiveParser.Sai__is_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(sai_constitutiveParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_pred_terms(sai_constitutiveParser.List_of_pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_terms(sai_constitutiveParser.Pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_term(sai_constitutiveParser.Pred_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(sai_constitutiveParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(sai_constitutiveParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_term(sai_constitutiveParser.List_termContext ctx);
}
