// Generated from sai_constitutive.g by ANTLR 4.4

package sai.main.lang.parser;


import org.antlr.v4.runtime.misc.NotNull;
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
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_decl(@NotNull sai_constitutiveParser.Agent_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_atom(@NotNull sai_constitutiveParser.Sff_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#normative_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormative_id(@NotNull sai_constitutiveParser.Normative_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_rel(@NotNull sai_constitutiveParser.Sff_relContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_and_expr(@NotNull sai_constitutiveParser.Sff_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf(@NotNull sai_constitutiveParser.Event_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sf_formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSf_formula(@NotNull sai_constitutiveParser.Sf_formulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_pred_terms(@NotNull sai_constitutiveParser.List_of_pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#count_as_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCount_as_stat(@NotNull sai_constitutiveParser.Count_as_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf(@NotNull sai_constitutiveParser.State_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_decl(@NotNull sai_constitutiveParser.State_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(@NotNull sai_constitutiveParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull sai_constitutiveParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf(@NotNull sai_constitutiveParser.Agent_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#sff_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_or_expr(@NotNull sai_constitutiveParser.Sff_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_list(@NotNull sai_constitutiveParser.State_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#constitutive_rules}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstitutive_rules(@NotNull sai_constitutiveParser.Constitutive_rulesContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(@NotNull sai_constitutiveParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#state_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_x(@NotNull sai_constitutiveParser.State_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#constitutive_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstitutive_spec(@NotNull sai_constitutiveParser.Constitutive_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_decl(@NotNull sai_constitutiveParser.Event_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_term(@NotNull sai_constitutiveParser.List_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#arithm_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_term(@NotNull sai_constitutiveParser.Arithm_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#status_functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatus_functions(@NotNull sai_constitutiveParser.Status_functionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_terms(@NotNull sai_constitutiveParser.Pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_x(@NotNull sai_constitutiveParser.Event_xContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#arithm_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_factor(@NotNull sai_constitutiveParser.Arithm_factorContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#pred_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_term(@NotNull sai_constitutiveParser.Pred_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull sai_constitutiveParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#m}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitM(@NotNull sai_constitutiveParser.MContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_list(@NotNull sai_constitutiveParser.Agent_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#event_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_list(@NotNull sai_constitutiveParser.Event_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(@NotNull sai_constitutiveParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitX(@NotNull sai_constitutiveParser.XContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#y}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitY(@NotNull sai_constitutiveParser.YContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#const_rule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConst_rule(@NotNull sai_constitutiveParser.Const_ruleContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_constitutiveParser#agent_x}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_x(@NotNull sai_constitutiveParser.Agent_xContext ctx);
}