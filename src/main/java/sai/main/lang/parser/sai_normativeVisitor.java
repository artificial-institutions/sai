// Generated from sai_normative.g by ANTLR 4.4

package sai.main.lang.parser;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link sai_normativeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface sai_normativeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#normative_spec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormative_spec(@NotNull sai_normativeParser.Normative_specContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#agent_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_decl(@NotNull sai_normativeParser.Agent_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#aim}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAim(@NotNull sai_normativeParser.AimContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sff_atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_atom(@NotNull sai_normativeParser.Sff_atomContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sff_rel}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_rel(@NotNull sai_normativeParser.Sff_relContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sff_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_and_expr(@NotNull sai_normativeParser.Sff_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#event_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf(@NotNull sai_normativeParser.Event_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sf_formula}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSf_formula(@NotNull sai_normativeParser.Sf_formulaContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#list_of_pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_of_pred_terms(@NotNull sai_normativeParser.List_of_pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#institution_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInstitution_id(@NotNull sai_normativeParser.Institution_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#norm}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNorm(@NotNull sai_normativeParser.NormContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#or_else}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOr_else(@NotNull sai_normativeParser.Or_elseContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#state_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf(@NotNull sai_normativeParser.State_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#state_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_decl(@NotNull sai_normativeParser.State_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#pred}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred(@NotNull sai_normativeParser.PredContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sai}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSai(@NotNull sai_normativeParser.SaiContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(@NotNull sai_normativeParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#attribute}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAttribute(@NotNull sai_normativeParser.AttributeContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#deadline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeadline(@NotNull sai_normativeParser.DeadlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#agent_sf}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf(@NotNull sai_normativeParser.Agent_sfContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#sff_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSff_or_expr(@NotNull sai_normativeParser.Sff_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#state_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitState_sf_list(@NotNull sai_normativeParser.State_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(@NotNull sai_normativeParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#event_sf_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_decl(@NotNull sai_normativeParser.Event_sf_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#list_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_term(@NotNull sai_normativeParser.List_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#arithm_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_term(@NotNull sai_normativeParser.Arithm_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#status_functions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatus_functions(@NotNull sai_normativeParser.Status_functionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#pred_terms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_terms(@NotNull sai_normativeParser.Pred_termsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#arithm_factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArithm_factor(@NotNull sai_normativeParser.Arithm_factorContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#pred_term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPred_term(@NotNull sai_normativeParser.Pred_termContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList(@NotNull sai_normativeParser.ListContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#agent_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgent_sf_list(@NotNull sai_normativeParser.Agent_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#event_sf_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEvent_sf_list(@NotNull sai_normativeParser.Event_sf_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(@NotNull sai_normativeParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#norms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNorms(@NotNull sai_normativeParser.NormsContext ctx);
	/**
	 * Visit a parse tree produced by {@link sai_normativeParser#deontic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeontic(@NotNull sai_normativeParser.DeonticContext ctx);
}