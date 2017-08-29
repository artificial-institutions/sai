// Generated from sai_normative.g by ANTLR 4.6

package sai.main.lang.parser;

import jason.asSyntax.Atom;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sai_normativeParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, TK_OR=23, TK_AND=24, 
		TK_REL_OP=25, TK_IS=26, STRING=27, NEGATION=28, TK_NEG=29, INTDIV=30, 
		INTMOD=31, ATOM=32, VAR=33, DIGIT=34, TERM_NULL=35, COMMENT_STAT=36, WS=37;
	public static final int
		RULE_sai = 0, RULE_normative_spec = 1, RULE_institution_id = 2, RULE_status_functions = 3, 
		RULE_agent_sf_decl = 4, RULE_agent_sf_list = 5, RULE_event_sf_decl = 6, 
		RULE_event_sf_list = 7, RULE_state_sf_decl = 8, RULE_state_sf_list = 9, 
		RULE_norms = 10, RULE_norm = 11, RULE_id = 12, RULE_condition = 13, RULE_attribute = 14, 
		RULE_deontic = 15, RULE_aim = 16, RULE_deadline = 17, RULE_or_else = 18, 
		RULE_agent_sf = 19, RULE_event_sf = 20, RULE_state_sf = 21, RULE_sf_formula = 22, 
		RULE_sff_or_expr = 23, RULE_sff_and_expr = 24, RULE_sff_rel = 25, RULE_arithm_term = 26, 
		RULE_arithm_factor = 27, RULE_sff_atom = 28, RULE_pred = 29, RULE_list_of_pred_terms = 30, 
		RULE_pred_terms = 31, RULE_pred_term = 32, RULE_annotation = 33, RULE_list = 34, 
		RULE_list_term = 35;
	public static final String[] ruleNames = {
		"sai", "normative_spec", "institution_id", "status_functions", "agent_sf_decl", 
		"agent_sf_list", "event_sf_decl", "event_sf_list", "state_sf_decl", "state_sf_list", 
		"norms", "norm", "id", "condition", "attribute", "deontic", "aim", "deadline", 
		"or_else", "agent_sf", "event_sf", "state_sf", "sf_formula", "sff_or_expr", 
		"sff_and_expr", "sff_rel", "arithm_term", "arithm_factor", "sff_atom", 
		"pred", "list_of_pred_terms", "pred_terms", "pred_term", "annotation", 
		"list", "list_term"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'institution_id'", "':'", "'.'", "'status_functions'", "'agents'", 
		"','", "'events'", "'states'", "'norms'", "'until'", "'else'", "'obliged'", 
		"'prohibited'", "'permitted'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", 
		"'['", "']'", "'|'", "'&'", null, "'is'", null, "'not'", "'~'", "'div'", 
		"'mod'", null, null, null, "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, "TK_OR", 
		"TK_AND", "TK_REL_OP", "TK_IS", "STRING", "NEGATION", "TK_NEG", "INTDIV", 
		"INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", "COMMENT_STAT", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "sai_normative.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  

	public sai_normativeParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SaiContext extends ParserRuleContext {
		public Normative_specContext normative_spec() {
			return getRuleContext(Normative_specContext.class,0);
		}
		public SaiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sai; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSai(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSai(this);
		}
	}

	public final SaiContext sai() throws RecognitionException {
		SaiContext _localctx = new SaiContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_sai);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			normative_spec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Normative_specContext extends ParserRuleContext {
		public Institution_idContext institution_id() {
			return getRuleContext(Institution_idContext.class,0);
		}
		public NormsContext norms() {
			return getRuleContext(NormsContext.class,0);
		}
		public Status_functionsContext status_functions() {
			return getRuleContext(Status_functionsContext.class,0);
		}
		public Normative_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normative_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterNormative_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitNormative_spec(this);
		}
	}

	public final Normative_specContext normative_spec() throws RecognitionException {
		Normative_specContext _localctx = new Normative_specContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_normative_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(74);
			institution_id();
			}
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(75);
				status_functions();
				}
			}

			{
			setState(78);
			norms();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Institution_idContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(sai_normativeParser.ATOM, 0); }
		public Institution_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_institution_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterInstitution_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitInstitution_id(this);
		}
	}

	public final Institution_idContext institution_id() throws RecognitionException {
		Institution_idContext _localctx = new Institution_idContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_institution_id);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(T__0);
			setState(81);
			match(T__1);
			setState(82);
			match(ATOM);
			setState(83);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Status_functionsContext extends ParserRuleContext {
		public List<Agent_sf_declContext> agent_sf_decl() {
			return getRuleContexts(Agent_sf_declContext.class);
		}
		public Agent_sf_declContext agent_sf_decl(int i) {
			return getRuleContext(Agent_sf_declContext.class,i);
		}
		public List<Event_sf_declContext> event_sf_decl() {
			return getRuleContexts(Event_sf_declContext.class);
		}
		public Event_sf_declContext event_sf_decl(int i) {
			return getRuleContext(Event_sf_declContext.class,i);
		}
		public List<State_sf_declContext> state_sf_decl() {
			return getRuleContexts(State_sf_declContext.class);
		}
		public State_sf_declContext state_sf_decl(int i) {
			return getRuleContext(State_sf_declContext.class,i);
		}
		public Status_functionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_status_functions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterStatus_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitStatus_functions(this);
		}
	}

	public final Status_functionsContext status_functions() throws RecognitionException {
		Status_functionsContext _localctx = new Status_functionsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_status_functions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(T__3);
			setState(86);
			match(T__1);
			setState(90); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(90);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(87);
					agent_sf_decl();
					}
					break;
				case T__6:
					{
					setState(88);
					event_sf_decl();
					}
					break;
				case T__7:
					{
					setState(89);
					state_sf_decl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(92); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__4) | (1L << T__6) | (1L << T__7))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Agent_sf_declContext extends ParserRuleContext {
		public Agent_sf_listContext agent_sf_list() {
			return getRuleContext(Agent_sf_listContext.class,0);
		}
		public Agent_sf_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent_sf_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAgent_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAgent_sf_decl(this);
		}
	}

	public final Agent_sf_declContext agent_sf_decl() throws RecognitionException {
		Agent_sf_declContext _localctx = new Agent_sf_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_agent_sf_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(T__4);
			setState(95);
			match(T__1);
			setState(96);
			agent_sf_list();
			setState(97);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Agent_sf_listContext extends ParserRuleContext {
		public List<Agent_sfContext> agent_sf() {
			return getRuleContexts(Agent_sfContext.class);
		}
		public Agent_sfContext agent_sf(int i) {
			return getRuleContext(Agent_sfContext.class,i);
		}
		public Agent_sf_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent_sf_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAgent_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAgent_sf_list(this);
		}
	}

	public final Agent_sf_listContext agent_sf_list() throws RecognitionException {
		Agent_sf_listContext _localctx = new Agent_sf_listContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_agent_sf_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(99);
			agent_sf();
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(100);
				match(T__5);
				setState(101);
				agent_sf();
				}
				}
				setState(106);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_sf_declContext extends ParserRuleContext {
		public Event_sf_listContext event_sf_list() {
			return getRuleContext(Event_sf_listContext.class,0);
		}
		public Event_sf_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_sf_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterEvent_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitEvent_sf_decl(this);
		}
	}

	public final Event_sf_declContext event_sf_decl() throws RecognitionException {
		Event_sf_declContext _localctx = new Event_sf_declContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_event_sf_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(107);
			match(T__6);
			setState(108);
			match(T__1);
			setState(109);
			event_sf_list();
			setState(110);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_sf_listContext extends ParserRuleContext {
		public List<Event_sfContext> event_sf() {
			return getRuleContexts(Event_sfContext.class);
		}
		public Event_sfContext event_sf(int i) {
			return getRuleContext(Event_sfContext.class,i);
		}
		public Event_sf_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_sf_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterEvent_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitEvent_sf_list(this);
		}
	}

	public final Event_sf_listContext event_sf_list() throws RecognitionException {
		Event_sf_listContext _localctx = new Event_sf_listContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_event_sf_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			event_sf();
			setState(117);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(113);
				match(T__5);
				setState(114);
				event_sf();
				}
				}
				setState(119);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_sf_declContext extends ParserRuleContext {
		public State_sf_listContext state_sf_list() {
			return getRuleContext(State_sf_listContext.class,0);
		}
		public State_sf_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_sf_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterState_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitState_sf_decl(this);
		}
	}

	public final State_sf_declContext state_sf_decl() throws RecognitionException {
		State_sf_declContext _localctx = new State_sf_declContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_state_sf_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			match(T__7);
			setState(121);
			match(T__1);
			setState(122);
			state_sf_list();
			setState(123);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_sf_listContext extends ParserRuleContext {
		public List<State_sfContext> state_sf() {
			return getRuleContexts(State_sfContext.class);
		}
		public State_sfContext state_sf(int i) {
			return getRuleContext(State_sfContext.class,i);
		}
		public State_sf_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_sf_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterState_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitState_sf_list(this);
		}
	}

	public final State_sf_listContext state_sf_list() throws RecognitionException {
		State_sf_listContext _localctx = new State_sf_listContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_state_sf_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125);
			state_sf();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(126);
				match(T__5);
				setState(127);
				state_sf();
				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormsContext extends ParserRuleContext {
		public List<NormContext> norm() {
			return getRuleContexts(NormContext.class);
		}
		public NormContext norm(int i) {
			return getRuleContext(NormContext.class,i);
		}
		public NormsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_norms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterNorms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitNorms(this);
		}
	}

	public final NormsContext norms() throws RecognitionException {
		NormsContext _localctx = new NormsContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_norms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			match(T__8);
			setState(134);
			match(T__1);
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				norm();
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NormContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public AttributeContext attribute() {
			return getRuleContext(AttributeContext.class,0);
		}
		public DeonticContext deontic() {
			return getRuleContext(DeonticContext.class,0);
		}
		public AimContext aim() {
			return getRuleContext(AimContext.class,0);
		}
		public DeadlineContext deadline() {
			return getRuleContext(DeadlineContext.class,0);
		}
		public Or_elseContext or_else() {
			return getRuleContext(Or_elseContext.class,0);
		}
		public NormContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_norm; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterNorm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitNorm(this);
		}
	}

	public final NormContext norm() throws RecognitionException {
		NormContext _localctx = new NormContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_norm);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			id();
			setState(141);
			match(T__1);
			setState(142);
			condition();
			setState(143);
			match(T__1);
			setState(144);
			attribute();
			setState(145);
			deontic();
			setState(146);
			aim();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__9) {
				{
				setState(147);
				match(T__9);
				setState(148);
				deadline();
				}
			}

			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(151);
				match(T__10);
				setState(152);
				or_else();
				}
			}

			setState(155);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public List<TerminalNode> DIGIT() { return getTokens(sai_normativeParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_normativeParser.DIGIT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(157);
				match(DIGIT);
				}
				}
				setState(160); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==DIGIT );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitCondition(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_condition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			sf_formula();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AttributeContext extends ParserRuleContext {
		public Agent_sfContext agent_sf() {
			return getRuleContext(Agent_sfContext.class,0);
		}
		public AttributeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attribute; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAttribute(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAttribute(this);
		}
	}

	public final AttributeContext attribute() throws RecognitionException {
		AttributeContext _localctx = new AttributeContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_attribute);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(164);
			agent_sf();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeonticContext extends ParserRuleContext {
		public DeonticContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deontic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterDeontic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitDeontic(this);
		}
	}

	public final DeonticContext deontic() throws RecognitionException {
		DeonticContext _localctx = new DeonticContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_deontic);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__11) | (1L << T__12) | (1L << T__13))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AimContext extends ParserRuleContext {
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public AimContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_aim; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAim(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAim(this);
		}
	}

	public final AimContext aim() throws RecognitionException {
		AimContext _localctx = new AimContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_aim);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			sf_formula();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeadlineContext extends ParserRuleContext {
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public DeadlineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_deadline; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterDeadline(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitDeadline(this);
		}
	}

	public final DeadlineContext deadline() throws RecognitionException {
		DeadlineContext _localctx = new DeadlineContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_deadline);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170);
			sf_formula();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Or_elseContext extends ParserRuleContext {
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public Or_elseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_or_else; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterOr_else(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitOr_else(this);
		}
	}

	public final Or_elseContext or_else() throws RecognitionException {
		Or_elseContext _localctx = new Or_elseContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_or_else);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			sf_formula();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Agent_sfContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(sai_normativeParser.ATOM, 0); }
		public Agent_sfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent_sf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAgent_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAgent_sf(this);
		}
	}

	public final Agent_sfContext agent_sf() throws RecognitionException {
		Agent_sfContext _localctx = new Agent_sfContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_agent_sf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(174);
			match(ATOM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Event_sfContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Event_sfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_sf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterEvent_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitEvent_sf(this);
		}
	}

	public final Event_sfContext event_sf() throws RecognitionException {
		Event_sfContext _localctx = new Event_sfContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_event_sf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			pred();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class State_sfContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public State_sfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_sf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterState_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitState_sf(this);
		}
	}

	public final State_sfContext state_sf() throws RecognitionException {
		State_sfContext _localctx = new State_sfContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_state_sf);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(178);
			pred();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sf_formulaContext extends ParserRuleContext {
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Sf_formulaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sf_formula; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSf_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSf_formula(this);
		}
	}

	public final Sf_formulaContext sf_formula() throws RecognitionException {
		Sf_formulaContext _localctx = new Sf_formulaContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_sf_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			sff_or_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sff_or_exprContext extends ParserRuleContext {
		public Sff_and_exprContext sff_and_expr() {
			return getRuleContext(Sff_and_exprContext.class,0);
		}
		public TerminalNode TK_OR() { return getToken(sai_normativeParser.TK_OR, 0); }
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Sff_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSff_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSff_or_expr(this);
		}
	}

	public final Sff_or_exprContext sff_or_expr() throws RecognitionException {
		Sff_or_exprContext _localctx = new Sff_or_exprContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sff_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			sff_and_expr();
			setState(185);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_OR) {
				{
				setState(183);
				match(TK_OR);
				setState(184);
				sff_or_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sff_and_exprContext extends ParserRuleContext {
		public Sff_relContext sff_rel() {
			return getRuleContext(Sff_relContext.class,0);
		}
		public TerminalNode TK_AND() { return getToken(sai_normativeParser.TK_AND, 0); }
		public Sff_and_exprContext sff_and_expr() {
			return getRuleContext(Sff_and_exprContext.class,0);
		}
		public Sff_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSff_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSff_and_expr(this);
		}
	}

	public final Sff_and_exprContext sff_and_expr() throws RecognitionException {
		Sff_and_exprContext _localctx = new Sff_and_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sff_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			sff_rel();
			setState(190);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_AND) {
				{
				setState(188);
				match(TK_AND);
				setState(189);
				sff_and_expr();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sff_relContext extends ParserRuleContext {
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public Sff_relContext sff_rel() {
			return getRuleContext(Sff_relContext.class,0);
		}
		public TerminalNode TK_REL_OP() { return getToken(sai_normativeParser.TK_REL_OP, 0); }
		public TerminalNode TK_IS() { return getToken(sai_normativeParser.TK_IS, 0); }
		public Sff_relContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSff_rel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSff_rel(this);
		}
	}

	public final Sff_relContext sff_rel() throws RecognitionException {
		Sff_relContext _localctx = new Sff_relContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sff_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192);
			arithm_term();
			setState(195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_REL_OP || _la==TK_IS) {
				{
				setState(193);
				_la = _input.LA(1);
				if ( !(_la==TK_REL_OP || _la==TK_IS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(194);
				sff_rel();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arithm_termContext extends ParserRuleContext {
		public Arithm_factorContext arithm_factor() {
			return getRuleContext(Arithm_factorContext.class,0);
		}
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public Arithm_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterArithm_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitArithm_term(this);
		}
	}

	public final Arithm_termContext arithm_term() throws RecognitionException {
		Arithm_termContext _localctx = new Arithm_termContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_arithm_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(197);
			arithm_factor();
			setState(200);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__14 || _la==T__15) {
				{
				setState(198);
				_la = _input.LA(1);
				if ( !(_la==T__14 || _la==T__15) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(199);
				arithm_term();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arithm_factorContext extends ParserRuleContext {
		public Sff_atomContext sff_atom() {
			return getRuleContext(Sff_atomContext.class,0);
		}
		public Arithm_factorContext arithm_factor() {
			return getRuleContext(Arithm_factorContext.class,0);
		}
		public TerminalNode INTDIV() { return getToken(sai_normativeParser.INTDIV, 0); }
		public TerminalNode INTMOD() { return getToken(sai_normativeParser.INTMOD, 0); }
		public Arithm_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterArithm_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitArithm_factor(this);
		}
	}

	public final Arithm_factorContext arithm_factor() throws RecognitionException {
		Arithm_factorContext _localctx = new Arithm_factorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arithm_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			sff_atom();
			setState(205);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << INTDIV) | (1L << INTMOD))) != 0)) {
				{
				setState(203);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__16) | (1L << T__17) | (1L << INTDIV) | (1L << INTMOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(204);
				arithm_factor();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sff_atomContext extends ParserRuleContext {
		public TerminalNode NEGATION() { return getToken(sai_normativeParser.NEGATION, 0); }
		public TerminalNode VAR() { return getToken(sai_normativeParser.VAR, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public List<TerminalNode> DIGIT() { return getTokens(sai_normativeParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_normativeParser.DIGIT, i);
		}
		public Sff_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterSff_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitSff_atom(this);
		}
	}

	public final Sff_atomContext sff_atom() throws RecognitionException {
		Sff_atomContext _localctx = new Sff_atomContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_sff_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(207);
				match(NEGATION);
				}
			}

			setState(223);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VAR:
				{
				setState(212);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(210);
					match(VAR);
					}
					break;
				case ATOM:
					{
					setState(211);
					pred();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__18:
				{
				{
				setState(214);
				match(T__18);
				setState(215);
				sff_or_expr();
				setState(216);
				match(T__19);
				}
				}
				break;
			case DIGIT:
				{
				{
				setState(219); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(218);
					match(DIGIT);
					}
					}
					setState(221); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PredContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(sai_normativeParser.ATOM, 0); }
		public List_of_pred_termsContext list_of_pred_terms() {
			return getRuleContext(List_of_pred_termsContext.class,0);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public PredContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitPred(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_pred);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(225);
			match(ATOM);
			setState(227);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(226);
				list_of_pred_terms();
				}
			}

			setState(230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__20) {
				{
				setState(229);
				list();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_of_pred_termsContext extends ParserRuleContext {
		public Pred_termsContext pred_terms() {
			return getRuleContext(Pred_termsContext.class,0);
		}
		public List_of_pred_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_of_pred_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterList_of_pred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitList_of_pred_terms(this);
		}
	}

	public final List_of_pred_termsContext list_of_pred_terms() throws RecognitionException {
		List_of_pred_termsContext _localctx = new List_of_pred_termsContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_list_of_pred_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(232);
			match(T__18);
			setState(233);
			pred_terms();
			setState(234);
			match(T__19);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pred_termsContext extends ParserRuleContext {
		public List<Pred_termContext> pred_term() {
			return getRuleContexts(Pred_termContext.class);
		}
		public Pred_termContext pred_term(int i) {
			return getRuleContext(Pred_termContext.class,i);
		}
		public Pred_termsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_terms; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterPred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitPred_terms(this);
		}
	}

	public final Pred_termsContext pred_terms() throws RecognitionException {
		Pred_termsContext _localctx = new Pred_termsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_pred_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(236);
			pred_term();
			setState(241);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(237);
				match(T__5);
				setState(238);
				pred_term();
				}
				}
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Pred_termContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(sai_normativeParser.VAR, 0); }
		public TerminalNode TERM_NULL() { return getToken(sai_normativeParser.TERM_NULL, 0); }
		public TerminalNode STRING() { return getToken(sai_normativeParser.STRING, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(sai_normativeParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_normativeParser.DIGIT, i);
		}
		public TerminalNode ATOM() { return getToken(sai_normativeParser.ATOM, 0); }
		public List_of_pred_termsContext list_of_pred_terms() {
			return getRuleContext(List_of_pred_termsContext.class,0);
		}
		public Pred_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterPred_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitPred_term(this);
		}
	}

	public final Pred_termContext pred_term() throws RecognitionException {
		Pred_termContext _localctx = new Pred_termContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pred_term);
		int _la;
		try {
			setState(256);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(244);
				match(VAR);
				}
				break;
			case TERM_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(245);
				match(TERM_NULL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(246);
				match(STRING);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(248); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(247);
					match(DIGIT);
					}
					}
					setState(250); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				break;
			case ATOM:
				enterOuterAlt(_localctx, 5);
				{
				setState(252);
				match(ATOM);
				setState(254);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__18) {
					{
					setState(253);
					list_of_pred_terms();
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AnnotationContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			list();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListContext extends ParserRuleContext {
		public List<List_termContext> list_term() {
			return getRuleContexts(List_termContext.class);
		}
		public List_termContext list_term(int i) {
			return getRuleContext(List_termContext.class,i);
		}
		public ListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260);
			match(T__20);
			setState(261);
			list_term();
			setState(266);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(262);
				match(T__5);
				setState(263);
				list_term();
				}
				}
				setState(268);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(269);
			match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_termContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public TerminalNode STRING() { return getToken(sai_normativeParser.STRING, 0); }
		public List_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).enterList_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_normativeListener ) ((sai_normativeListener)listener).exitList_term(this);
		}
	}

	public final List_termContext list_term() throws RecognitionException {
		List_termContext _localctx = new List_termContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_list_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__20:
				{
				setState(271);
				list();
				}
				break;
			case T__18:
			case NEGATION:
			case ATOM:
			case VAR:
			case DIGIT:
				{
				setState(272);
				arithm_term();
				}
				break;
			case STRING:
				{
				setState(273);
				match(STRING);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\'\u0117\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\5\3O\n\3\3\3\3\3\3\4\3\4"+
		"\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\6\5]\n\5\r\5\16\5^\3\6\3\6\3\6\3\6\3"+
		"\6\3\7\3\7\3\7\7\7i\n\7\f\7\16\7l\13\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t"+
		"\7\tv\n\t\f\t\16\ty\13\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\7\13\u0083"+
		"\n\13\f\13\16\13\u0086\13\13\3\f\3\f\3\f\6\f\u008b\n\f\r\f\16\f\u008c"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u0098\n\r\3\r\3\r\5\r\u009c\n"+
		"\r\3\r\3\r\3\16\6\16\u00a1\n\16\r\16\16\16\u00a2\3\17\3\17\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\31\5\31\u00bc\n\31\3\32\3\32\3\32\5\32\u00c1\n\32"+
		"\3\33\3\33\3\33\5\33\u00c6\n\33\3\34\3\34\3\34\5\34\u00cb\n\34\3\35\3"+
		"\35\3\35\5\35\u00d0\n\35\3\36\5\36\u00d3\n\36\3\36\3\36\5\36\u00d7\n\36"+
		"\3\36\3\36\3\36\3\36\3\36\6\36\u00de\n\36\r\36\16\36\u00df\5\36\u00e2"+
		"\n\36\3\37\3\37\5\37\u00e6\n\37\3\37\5\37\u00e9\n\37\3 \3 \3 \3 \3!\3"+
		"!\3!\7!\u00f2\n!\f!\16!\u00f5\13!\3\"\3\"\3\"\3\"\6\"\u00fb\n\"\r\"\16"+
		"\"\u00fc\3\"\3\"\5\"\u0101\n\"\5\"\u0103\n\"\3#\3#\3$\3$\3$\3$\7$\u010b"+
		"\n$\f$\16$\u010e\13$\3$\3$\3%\3%\3%\5%\u0115\n%\3%\2\2&\2\4\6\b\n\f\16"+
		"\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFH\2\6\3\2\16\20\3"+
		"\2\33\34\3\2\21\22\4\2\23\24 !\u0113\2J\3\2\2\2\4L\3\2\2\2\6R\3\2\2\2"+
		"\bW\3\2\2\2\n`\3\2\2\2\fe\3\2\2\2\16m\3\2\2\2\20r\3\2\2\2\22z\3\2\2\2"+
		"\24\177\3\2\2\2\26\u0087\3\2\2\2\30\u008e\3\2\2\2\32\u00a0\3\2\2\2\34"+
		"\u00a4\3\2\2\2\36\u00a6\3\2\2\2 \u00a8\3\2\2\2\"\u00aa\3\2\2\2$\u00ac"+
		"\3\2\2\2&\u00ae\3\2\2\2(\u00b0\3\2\2\2*\u00b2\3\2\2\2,\u00b4\3\2\2\2."+
		"\u00b6\3\2\2\2\60\u00b8\3\2\2\2\62\u00bd\3\2\2\2\64\u00c2\3\2\2\2\66\u00c7"+
		"\3\2\2\28\u00cc\3\2\2\2:\u00d2\3\2\2\2<\u00e3\3\2\2\2>\u00ea\3\2\2\2@"+
		"\u00ee\3\2\2\2B\u0102\3\2\2\2D\u0104\3\2\2\2F\u0106\3\2\2\2H\u0114\3\2"+
		"\2\2JK\5\4\3\2K\3\3\2\2\2LN\5\6\4\2MO\5\b\5\2NM\3\2\2\2NO\3\2\2\2OP\3"+
		"\2\2\2PQ\5\26\f\2Q\5\3\2\2\2RS\7\3\2\2ST\7\4\2\2TU\7\"\2\2UV\7\5\2\2V"+
		"\7\3\2\2\2WX\7\6\2\2X\\\7\4\2\2Y]\5\n\6\2Z]\5\16\b\2[]\5\22\n\2\\Y\3\2"+
		"\2\2\\Z\3\2\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3\2\2\2_\t\3\2\2\2`"+
		"a\7\7\2\2ab\7\4\2\2bc\5\f\7\2cd\7\5\2\2d\13\3\2\2\2ej\5(\25\2fg\7\b\2"+
		"\2gi\5(\25\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\r\3\2\2\2lj\3\2"+
		"\2\2mn\7\t\2\2no\7\4\2\2op\5\20\t\2pq\7\5\2\2q\17\3\2\2\2rw\5*\26\2st"+
		"\7\b\2\2tv\5*\26\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2x\21\3\2\2\2"+
		"yw\3\2\2\2z{\7\n\2\2{|\7\4\2\2|}\5\24\13\2}~\7\5\2\2~\23\3\2\2\2\177\u0084"+
		"\5,\27\2\u0080\u0081\7\b\2\2\u0081\u0083\5,\27\2\u0082\u0080\3\2\2\2\u0083"+
		"\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\25\3\2\2"+
		"\2\u0086\u0084\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u008a\7\4\2\2\u0089"+
		"\u008b\5\30\r\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\27\3\2\2\2\u008e\u008f\5\32\16\2\u008f"+
		"\u0090\7\4\2\2\u0090\u0091\5\34\17\2\u0091\u0092\7\4\2\2\u0092\u0093\5"+
		"\36\20\2\u0093\u0094\5 \21\2\u0094\u0097\5\"\22\2\u0095\u0096\7\f\2\2"+
		"\u0096\u0098\5$\23\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009b"+
		"\3\2\2\2\u0099\u009a\7\r\2\2\u009a\u009c\5&\24\2\u009b\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\7\5\2\2\u009e\31\3\2\2"+
		"\2\u009f\u00a1\7$\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a0"+
		"\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\33\3\2\2\2\u00a4\u00a5\5.\30\2\u00a5"+
		"\35\3\2\2\2\u00a6\u00a7\5(\25\2\u00a7\37\3\2\2\2\u00a8\u00a9\t\2\2\2\u00a9"+
		"!\3\2\2\2\u00aa\u00ab\5.\30\2\u00ab#\3\2\2\2\u00ac\u00ad\5.\30\2\u00ad"+
		"%\3\2\2\2\u00ae\u00af\5.\30\2\u00af\'\3\2\2\2\u00b0\u00b1\7\"\2\2\u00b1"+
		")\3\2\2\2\u00b2\u00b3\5<\37\2\u00b3+\3\2\2\2\u00b4\u00b5\5<\37\2\u00b5"+
		"-\3\2\2\2\u00b6\u00b7\5\60\31\2\u00b7/\3\2\2\2\u00b8\u00bb\5\62\32\2\u00b9"+
		"\u00ba\7\31\2\2\u00ba\u00bc\5\60\31\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc"+
		"\3\2\2\2\u00bc\61\3\2\2\2\u00bd\u00c0\5\64\33\2\u00be\u00bf\7\32\2\2\u00bf"+
		"\u00c1\5\62\32\2\u00c0\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\63\3\2"+
		"\2\2\u00c2\u00c5\5\66\34\2\u00c3\u00c4\t\3\2\2\u00c4\u00c6\5\64\33\2\u00c5"+
		"\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\65\3\2\2\2\u00c7\u00ca\58\35"+
		"\2\u00c8\u00c9\t\4\2\2\u00c9\u00cb\5\66\34\2\u00ca\u00c8\3\2\2\2\u00ca"+
		"\u00cb\3\2\2\2\u00cb\67\3\2\2\2\u00cc\u00cf\5:\36\2\u00cd\u00ce\t\5\2"+
		"\2\u00ce\u00d0\58\35\2\u00cf\u00cd\3\2\2\2\u00cf\u00d0\3\2\2\2\u00d09"+
		"\3\2\2\2\u00d1\u00d3\7\36\2\2\u00d2\u00d1\3\2\2\2\u00d2\u00d3\3\2\2\2"+
		"\u00d3\u00e1\3\2\2\2\u00d4\u00d7\7#\2\2\u00d5\u00d7\5<\37\2\u00d6\u00d4"+
		"\3\2\2\2\u00d6\u00d5\3\2\2\2\u00d7\u00e2\3\2\2\2\u00d8\u00d9\7\25\2\2"+
		"\u00d9\u00da\5\60\31\2\u00da\u00db\7\26\2\2\u00db\u00e2\3\2\2\2\u00dc"+
		"\u00de\7$\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2\u00df\u00dd\3\2"+
		"\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e2\3\2\2\2\u00e1\u00d6\3\2\2\2\u00e1"+
		"\u00d8\3\2\2\2\u00e1\u00dd\3\2\2\2\u00e2;\3\2\2\2\u00e3\u00e5\7\"\2\2"+
		"\u00e4\u00e6\5> \2\u00e5\u00e4\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e9\5F$\2\u00e8\u00e7\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"=\3\2\2\2\u00ea\u00eb\7\25\2\2\u00eb\u00ec\5@!\2\u00ec\u00ed\7\26\2\2"+
		"\u00ed?\3\2\2\2\u00ee\u00f3\5B\"\2\u00ef\u00f0\7\b\2\2\u00f0\u00f2\5B"+
		"\"\2\u00f1\u00ef\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1\3\2\2\2\u00f3"+
		"\u00f4\3\2\2\2\u00f4A\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6\u0103\7#\2\2\u00f7"+
		"\u0103\7%\2\2\u00f8\u0103\7\35\2\2\u00f9\u00fb\7$\2\2\u00fa\u00f9\3\2"+
		"\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fa\3\2\2\2\u00fc\u00fd\3\2\2\2\u00fd"+
		"\u0103\3\2\2\2\u00fe\u0100\7\"\2\2\u00ff\u0101\5> \2\u0100\u00ff\3\2\2"+
		"\2\u0100\u0101\3\2\2\2\u0101\u0103\3\2\2\2\u0102\u00f6\3\2\2\2\u0102\u00f7"+
		"\3\2\2\2\u0102\u00f8\3\2\2\2\u0102\u00fa\3\2\2\2\u0102\u00fe\3\2\2\2\u0103"+
		"C\3\2\2\2\u0104\u0105\5F$\2\u0105E\3\2\2\2\u0106\u0107\7\27\2\2\u0107"+
		"\u010c\5H%\2\u0108\u0109\7\b\2\2\u0109\u010b\5H%\2\u010a\u0108\3\2\2\2"+
		"\u010b\u010e\3\2\2\2\u010c\u010a\3\2\2\2\u010c\u010d\3\2\2\2\u010d\u010f"+
		"\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\7\30\2\2\u0110G\3\2\2\2\u0111"+
		"\u0115\5F$\2\u0112\u0115\5\66\34\2\u0113\u0115\7\35\2\2\u0114\u0111\3"+
		"\2\2\2\u0114\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115I\3\2\2\2\35N\\^j"+
		"w\u0084\u008c\u0097\u009b\u00a2\u00bb\u00c0\u00c5\u00ca\u00cf\u00d2\u00d6"+
		"\u00df\u00e1\u00e5\u00e8\u00f3\u00fc\u0100\u0102\u010c\u0114";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}