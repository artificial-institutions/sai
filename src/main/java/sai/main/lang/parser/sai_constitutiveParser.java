// Generated from grammar/sai_constitutive.g by ANTLR 4.7

package sai.main.lang.parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sai_constitutiveParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, TK_OR=21, TK_AND=22, TK_REL_OP=23, TK_IS=24, 
		STRING=25, NEGATION=26, TK_NEG=27, INTDIV=28, INTMOD=29, ATOM=30, VAR=31, 
		DIGIT=32, TERM_NULL=33, COMMENT_STAT=34, WS=35;
	public static final int
		RULE_constitutive_spec = 0, RULE_normative_id = 1, RULE_status_functions = 2, 
		RULE_agent_sf_decl = 3, RULE_agent_sf_list = 4, RULE_event_sf_decl = 5, 
		RULE_event_sf_list = 6, RULE_state_sf_decl = 7, RULE_state_sf_list = 8, 
		RULE_constitutive_rules = 9, RULE_const_rule = 10, RULE_id = 11, RULE_count_as_stat = 12, 
		RULE_y = 13, RULE_x = 14, RULE_t = 15, RULE_m = 16, RULE_agent_sf = 17, 
		RULE_event_sf = 18, RULE_state_sf = 19, RULE_agent_x = 20, RULE_event_x = 21, 
		RULE_state_x = 22, RULE_sf_formula = 23, RULE_sff_or_expr = 24, RULE_sff_and_expr = 25, 
		RULE_sff_rel = 26, RULE_arithm_term = 27, RULE_arithm_factor = 28, RULE_sff_atom = 29, 
		RULE_pred = 30, RULE_list_of_pred_terms = 31, RULE_pred_terms = 32, RULE_pred_term = 33, 
		RULE_annotation = 34, RULE_list = 35, RULE_list_term = 36;
	public static final String[] ruleNames = {
		"constitutive_spec", "normative_id", "status_functions", "agent_sf_decl", 
		"agent_sf_list", "event_sf_decl", "event_sf_list", "state_sf_decl", "state_sf_list", 
		"constitutive_rules", "const_rule", "id", "count_as_stat", "y", "x", "t", 
		"m", "agent_sf", "event_sf", "state_sf", "agent_x", "event_x", "state_x", 
		"sf_formula", "sff_or_expr", "sff_and_expr", "sff_rel", "arithm_term", 
		"arithm_factor", "sff_atom", "pred", "list_of_pred_terms", "pred_terms", 
		"pred_term", "annotation", "list", "list_term"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'institution_id'", "':'", "'.'", "'status_functions'", "'agents'", 
		"','", "'events'", "'states'", "'constitutive_rules'", "'count-as'", "'when'", 
		"'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'['", "']'", "'|'", 
		"'&'", null, "'is'", null, "'not'", "'~'", "'div'", "'mod'", null, null, 
		null, "'_'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, "TK_OR", "TK_AND", 
		"TK_REL_OP", "TK_IS", "STRING", "NEGATION", "TK_NEG", "INTDIV", "INTMOD", 
		"ATOM", "VAR", "DIGIT", "TERM_NULL", "COMMENT_STAT", "WS"
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
	public String getGrammarFileName() { return "sai_constitutive.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }



	  

	public sai_constitutiveParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Constitutive_specContext extends ParserRuleContext {
		public Normative_idContext normative_id() {
			return getRuleContext(Normative_idContext.class,0);
		}
		public Constitutive_rulesContext constitutive_rules() {
			return getRuleContext(Constitutive_rulesContext.class,0);
		}
		public Status_functionsContext status_functions() {
			return getRuleContext(Status_functionsContext.class,0);
		}
		public Constitutive_specContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constitutive_spec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterConstitutive_spec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitConstitutive_spec(this);
		}
	}

	public final Constitutive_specContext constitutive_spec() throws RecognitionException {
		Constitutive_specContext _localctx = new Constitutive_specContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_constitutive_spec);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			normative_id();
			setState(76);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(75);
				status_functions();
				}
			}

			setState(78);
			constitutive_rules();
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

	public static class Normative_idContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(sai_constitutiveParser.ATOM, 0); }
		public Normative_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_normative_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterNormative_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitNormative_id(this);
		}
	}

	public final Normative_idContext normative_id() throws RecognitionException {
		Normative_idContext _localctx = new Normative_idContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_normative_id);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterStatus_functions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitStatus_functions(this);
		}
	}

	public final Status_functionsContext status_functions() throws RecognitionException {
		Status_functionsContext _localctx = new Status_functionsContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_status_functions);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterAgent_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitAgent_sf_decl(this);
		}
	}

	public final Agent_sf_declContext agent_sf_decl() throws RecognitionException {
		Agent_sf_declContext _localctx = new Agent_sf_declContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_agent_sf_decl);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterAgent_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitAgent_sf_list(this);
		}
	}

	public final Agent_sf_listContext agent_sf_list() throws RecognitionException {
		Agent_sf_listContext _localctx = new Agent_sf_listContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_agent_sf_list);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterEvent_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitEvent_sf_decl(this);
		}
	}

	public final Event_sf_declContext event_sf_decl() throws RecognitionException {
		Event_sf_declContext _localctx = new Event_sf_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_event_sf_decl);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterEvent_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitEvent_sf_list(this);
		}
	}

	public final Event_sf_listContext event_sf_list() throws RecognitionException {
		Event_sf_listContext _localctx = new Event_sf_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_event_sf_list);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterState_sf_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitState_sf_decl(this);
		}
	}

	public final State_sf_declContext state_sf_decl() throws RecognitionException {
		State_sf_declContext _localctx = new State_sf_declContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_state_sf_decl);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterState_sf_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitState_sf_list(this);
		}
	}

	public final State_sf_listContext state_sf_list() throws RecognitionException {
		State_sf_listContext _localctx = new State_sf_listContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_state_sf_list);
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

	public static class Constitutive_rulesContext extends ParserRuleContext {
		public List<Const_ruleContext> const_rule() {
			return getRuleContexts(Const_ruleContext.class);
		}
		public Const_ruleContext const_rule(int i) {
			return getRuleContext(Const_ruleContext.class,i);
		}
		public Constitutive_rulesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constitutive_rules; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterConstitutive_rules(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitConstitutive_rules(this);
		}
	}

	public final Constitutive_rulesContext constitutive_rules() throws RecognitionException {
		Constitutive_rulesContext _localctx = new Constitutive_rulesContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_constitutive_rules);
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
				const_rule();
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

	public static class Const_ruleContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Count_as_statContext count_as_stat() {
			return getRuleContext(Count_as_statContext.class,0);
		}
		public TContext t() {
			return getRuleContext(TContext.class,0);
		}
		public MContext m() {
			return getRuleContext(MContext.class,0);
		}
		public Const_ruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_const_rule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterConst_rule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitConst_rule(this);
		}
	}

	public final Const_ruleContext const_rule() throws RecognitionException {
		Const_ruleContext _localctx = new Const_ruleContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_const_rule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			id();
			setState(141);
			match(T__1);
			setState(142);
			count_as_stat();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(143);
				t();
				}
			}

			setState(147);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(146);
				m();
				}
			}

			setState(149);
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
		public List<TerminalNode> DIGIT() { return getTokens(sai_constitutiveParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_constitutiveParser.DIGIT, i);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitId(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(152); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(151);
				match(DIGIT);
				}
				}
				setState(154); 
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

	public static class Count_as_statContext extends ParserRuleContext {
		public YContext y() {
			return getRuleContext(YContext.class,0);
		}
		public XContext x() {
			return getRuleContext(XContext.class,0);
		}
		public Count_as_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_count_as_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterCount_as_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitCount_as_stat(this);
		}
	}

	public final Count_as_statContext count_as_stat() throws RecognitionException {
		Count_as_statContext _localctx = new Count_as_statContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_count_as_stat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATOM || _la==VAR) {
				{
				setState(156);
				x();
				}
			}

			setState(159);
			match(T__9);
			setState(160);
			y();
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

	public static class YContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public YContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_y; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterY(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitY(this);
		}
	}

	public final YContext y() throws RecognitionException {
		YContext _localctx = new YContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_y);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
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

	public static class XContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(sai_constitutiveParser.VAR, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public XContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterX(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitX(this);
		}
	}

	public final XContext x() throws RecognitionException {
		XContext _localctx = new XContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(166);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(164);
				match(VAR);
				}
				break;
			case ATOM:
				{
				setState(165);
				pred();
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

	public static class TContext extends ParserRuleContext {
		public Event_sfContext event_sf() {
			return getRuleContext(Event_sfContext.class,0);
		}
		public TContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_t; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterT(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitT(this);
		}
	}

	public final TContext t() throws RecognitionException {
		TContext _localctx = new TContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_t);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(168);
			match(T__10);
			setState(169);
			event_sf();
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

	public static class MContext extends ParserRuleContext {
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public MContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_m; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterM(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitM(this);
		}
	}

	public final MContext m() throws RecognitionException {
		MContext _localctx = new MContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_m);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__11);
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
		public TerminalNode ATOM() { return getToken(sai_constitutiveParser.ATOM, 0); }
		public Agent_sfContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent_sf; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterAgent_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitAgent_sf(this);
		}
	}

	public final Agent_sfContext agent_sf() throws RecognitionException {
		Agent_sfContext _localctx = new Agent_sfContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_agent_sf);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterEvent_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitEvent_sf(this);
		}
	}

	public final Event_sfContext event_sf() throws RecognitionException {
		Event_sfContext _localctx = new Event_sfContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_event_sf);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterState_sf(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitState_sf(this);
		}
	}

	public final State_sfContext state_sf() throws RecognitionException {
		State_sfContext _localctx = new State_sfContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_state_sf);
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

	public static class Agent_xContext extends ParserRuleContext {
		public TerminalNode ATOM() { return getToken(sai_constitutiveParser.ATOM, 0); }
		public Agent_xContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_agent_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterAgent_x(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitAgent_x(this);
		}
	}

	public final Agent_xContext agent_x() throws RecognitionException {
		Agent_xContext _localctx = new Agent_xContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_agent_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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

	public static class Event_xContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Event_xContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_event_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterEvent_x(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitEvent_x(this);
		}
	}

	public final Event_xContext event_x() throws RecognitionException {
		Event_xContext _localctx = new Event_xContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_event_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
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

	public static class State_xContext extends ParserRuleContext {
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public State_xContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_state_x; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterState_x(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitState_x(this);
		}
	}

	public final State_xContext state_x() throws RecognitionException {
		State_xContext _localctx = new State_xContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_state_x);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSf_formula(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSf_formula(this);
		}
	}

	public final Sf_formulaContext sf_formula() throws RecognitionException {
		Sf_formulaContext _localctx = new Sf_formulaContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_sf_formula);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(186);
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
		public TerminalNode TK_OR() { return getToken(sai_constitutiveParser.TK_OR, 0); }
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Sff_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSff_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSff_or_expr(this);
		}
	}

	public final Sff_or_exprContext sff_or_expr() throws RecognitionException {
		Sff_or_exprContext _localctx = new Sff_or_exprContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_sff_or_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(188);
			sff_and_expr();
			setState(191);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_OR) {
				{
				setState(189);
				match(TK_OR);
				setState(190);
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
		public TerminalNode TK_AND() { return getToken(sai_constitutiveParser.TK_AND, 0); }
		public Sff_and_exprContext sff_and_expr() {
			return getRuleContext(Sff_and_exprContext.class,0);
		}
		public Sff_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSff_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSff_and_expr(this);
		}
	}

	public final Sff_and_exprContext sff_and_expr() throws RecognitionException {
		Sff_and_exprContext _localctx = new Sff_and_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_sff_and_expr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			sff_rel();
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_AND) {
				{
				setState(194);
				match(TK_AND);
				setState(195);
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
		public TerminalNode TK_REL_OP() { return getToken(sai_constitutiveParser.TK_REL_OP, 0); }
		public TerminalNode TK_IS() { return getToken(sai_constitutiveParser.TK_IS, 0); }
		public Sff_relContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_rel; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSff_rel(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSff_rel(this);
		}
	}

	public final Sff_relContext sff_rel() throws RecognitionException {
		Sff_relContext _localctx = new Sff_relContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_sff_rel);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(198);
			arithm_term();
			setState(201);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_REL_OP || _la==TK_IS) {
				{
				setState(199);
				_la = _input.LA(1);
				if ( !(_la==TK_REL_OP || _la==TK_IS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(200);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterArithm_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitArithm_term(this);
		}
	}

	public final Arithm_termContext arithm_term() throws RecognitionException {
		Arithm_termContext _localctx = new Arithm_termContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_arithm_term);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			arithm_factor();
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__13) {
				{
				setState(204);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(205);
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
		public TerminalNode INTDIV() { return getToken(sai_constitutiveParser.INTDIV, 0); }
		public TerminalNode INTMOD() { return getToken(sai_constitutiveParser.INTMOD, 0); }
		public Arithm_factorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arithm_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterArithm_factor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitArithm_factor(this);
		}
	}

	public final Arithm_factorContext arithm_factor() throws RecognitionException {
		Arithm_factorContext _localctx = new Arithm_factorContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_arithm_factor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(208);
			sff_atom();
			setState(211);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << INTDIV) | (1L << INTMOD))) != 0)) {
				{
				setState(209);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << INTDIV) | (1L << INTMOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(210);
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
		public TerminalNode NEGATION() { return getToken(sai_constitutiveParser.NEGATION, 0); }
		public TerminalNode VAR() { return getToken(sai_constitutiveParser.VAR, 0); }
		public PredContext pred() {
			return getRuleContext(PredContext.class,0);
		}
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public List<TerminalNode> DIGIT() { return getTokens(sai_constitutiveParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_constitutiveParser.DIGIT, i);
		}
		public Sff_atomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sff_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSff_atom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSff_atom(this);
		}
	}

	public final Sff_atomContext sff_atom() throws RecognitionException {
		Sff_atomContext _localctx = new Sff_atomContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_sff_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(214);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(213);
				match(NEGATION);
				}
			}

			setState(229);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
			case VAR:
				{
				setState(218);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(216);
					match(VAR);
					}
					break;
				case ATOM:
					{
					setState(217);
					pred();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case T__16:
				{
				{
				setState(220);
				match(T__16);
				setState(221);
				sff_or_expr();
				setState(222);
				match(T__17);
				}
				}
				break;
			case DIGIT:
				{
				{
				setState(225); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(224);
					match(DIGIT);
					}
					}
					setState(227); 
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
		public TerminalNode ATOM() { return getToken(sai_constitutiveParser.ATOM, 0); }
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterPred(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitPred(this);
		}
	}

	public final PredContext pred() throws RecognitionException {
		PredContext _localctx = new PredContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_pred);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(231);
			match(ATOM);
			setState(233);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(232);
				list_of_pred_terms();
				}
			}

			setState(236);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__18) {
				{
				setState(235);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterList_of_pred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitList_of_pred_terms(this);
		}
	}

	public final List_of_pred_termsContext list_of_pred_terms() throws RecognitionException {
		List_of_pred_termsContext _localctx = new List_of_pred_termsContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_list_of_pred_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(238);
			match(T__16);
			setState(239);
			pred_terms();
			setState(240);
			match(T__17);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterPred_terms(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitPred_terms(this);
		}
	}

	public final Pred_termsContext pred_terms() throws RecognitionException {
		Pred_termsContext _localctx = new Pred_termsContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_pred_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(242);
			pred_term();
			setState(247);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(243);
				match(T__5);
				setState(244);
				pred_term();
				}
				}
				setState(249);
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
		public TerminalNode VAR() { return getToken(sai_constitutiveParser.VAR, 0); }
		public TerminalNode TERM_NULL() { return getToken(sai_constitutiveParser.TERM_NULL, 0); }
		public TerminalNode STRING() { return getToken(sai_constitutiveParser.STRING, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(sai_constitutiveParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_constitutiveParser.DIGIT, i);
		}
		public TerminalNode ATOM() { return getToken(sai_constitutiveParser.ATOM, 0); }
		public List_of_pred_termsContext list_of_pred_terms() {
			return getRuleContext(List_of_pred_termsContext.class,0);
		}
		public Sff_or_exprContext sff_or_expr() {
			return getRuleContext(Sff_or_exprContext.class,0);
		}
		public Pred_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pred_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterPred_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitPred_term(this);
		}
	}

	public final Pred_termContext pred_term() throws RecognitionException {
		Pred_termContext _localctx = new Pred_termContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_pred_term);
		int _la;
		try {
			setState(266);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(250);
				match(VAR);
				}
				break;
			case TERM_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(TERM_NULL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				match(STRING);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(254); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(253);
					match(DIGIT);
					}
					}
					setState(256); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				break;
			case ATOM:
				enterOuterAlt(_localctx, 5);
				{
				setState(258);
				match(ATOM);
				setState(260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(259);
					list_of_pred_terms();
					}
				}

				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(262);
				match(T__16);
				setState(263);
				sff_or_expr();
				setState(264);
				match(T__17);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterAnnotation(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitAnnotation(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(268);
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
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterList(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitList(this);
		}
	}

	public final ListContext list() throws RecognitionException {
		ListContext _localctx = new ListContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270);
			match(T__18);
			setState(271);
			list_term();
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(272);
				match(T__5);
				setState(273);
				list_term();
				}
				}
				setState(278);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(279);
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

	public static class List_termContext extends ParserRuleContext {
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
		}
		public Arithm_termContext arithm_term() {
			return getRuleContext(Arithm_termContext.class,0);
		}
		public TerminalNode STRING() { return getToken(sai_constitutiveParser.STRING, 0); }
		public List_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterList_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitList_term(this);
		}
	}

	public final List_termContext list_term() throws RecognitionException {
		List_termContext _localctx = new List_termContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_list_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
				{
				setState(281);
				list();
				}
				break;
			case T__16:
			case NEGATION:
			case ATOM:
			case VAR:
			case DIGIT:
				{
				setState(282);
				arithm_term();
				}
				break;
			case STRING:
				{
				setState(283);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0121\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\5\2O\n\2\3\2\3\2\3\3\3\3\3"+
		"\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4]\n\4\r\4\16\4^\3\5\3\5\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\7\6i\n\6\f\6\16\6l\13\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\7"+
		"\bv\n\b\f\b\16\by\13\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u0083\n\n\f"+
		"\n\16\n\u0086\13\n\3\13\3\13\3\13\6\13\u008b\n\13\r\13\16\13\u008c\3\f"+
		"\3\f\3\f\3\f\5\f\u0093\n\f\3\f\5\f\u0096\n\f\3\f\3\f\3\r\6\r\u009b\n\r"+
		"\r\r\16\r\u009c\3\16\5\16\u00a0\n\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20"+
		"\5\20\u00a9\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u00c2"+
		"\n\32\3\33\3\33\3\33\5\33\u00c7\n\33\3\34\3\34\3\34\5\34\u00cc\n\34\3"+
		"\35\3\35\3\35\5\35\u00d1\n\35\3\36\3\36\3\36\5\36\u00d6\n\36\3\37\5\37"+
		"\u00d9\n\37\3\37\3\37\5\37\u00dd\n\37\3\37\3\37\3\37\3\37\3\37\6\37\u00e4"+
		"\n\37\r\37\16\37\u00e5\5\37\u00e8\n\37\3 \3 \5 \u00ec\n \3 \5 \u00ef\n"+
		" \3!\3!\3!\3!\3\"\3\"\3\"\7\"\u00f8\n\"\f\"\16\"\u00fb\13\"\3#\3#\3#\3"+
		"#\6#\u0101\n#\r#\16#\u0102\3#\3#\5#\u0107\n#\3#\3#\3#\3#\5#\u010d\n#\3"+
		"$\3$\3%\3%\3%\3%\7%\u0115\n%\f%\16%\u0118\13%\3%\3%\3&\3&\3&\5&\u011f"+
		"\n&\3&\2\2\'\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJ\2\5\3\2\31\32\3\2\17\20\4\2\21\22\36\37\2\u011f\2L\3\2\2"+
		"\2\4R\3\2\2\2\6W\3\2\2\2\b`\3\2\2\2\ne\3\2\2\2\fm\3\2\2\2\16r\3\2\2\2"+
		"\20z\3\2\2\2\22\177\3\2\2\2\24\u0087\3\2\2\2\26\u008e\3\2\2\2\30\u009a"+
		"\3\2\2\2\32\u009f\3\2\2\2\34\u00a4\3\2\2\2\36\u00a8\3\2\2\2 \u00aa\3\2"+
		"\2\2\"\u00ad\3\2\2\2$\u00b0\3\2\2\2&\u00b2\3\2\2\2(\u00b4\3\2\2\2*\u00b6"+
		"\3\2\2\2,\u00b8\3\2\2\2.\u00ba\3\2\2\2\60\u00bc\3\2\2\2\62\u00be\3\2\2"+
		"\2\64\u00c3\3\2\2\2\66\u00c8\3\2\2\28\u00cd\3\2\2\2:\u00d2\3\2\2\2<\u00d8"+
		"\3\2\2\2>\u00e9\3\2\2\2@\u00f0\3\2\2\2B\u00f4\3\2\2\2D\u010c\3\2\2\2F"+
		"\u010e\3\2\2\2H\u0110\3\2\2\2J\u011e\3\2\2\2LN\5\4\3\2MO\5\6\4\2NM\3\2"+
		"\2\2NO\3\2\2\2OP\3\2\2\2PQ\5\24\13\2Q\3\3\2\2\2RS\7\3\2\2ST\7\4\2\2TU"+
		"\7 \2\2UV\7\5\2\2V\5\3\2\2\2WX\7\6\2\2X\\\7\4\2\2Y]\5\b\5\2Z]\5\f\7\2"+
		"[]\5\20\t\2\\Y\3\2\2\2\\Z\3\2\2\2\\[\3\2\2\2]^\3\2\2\2^\\\3\2\2\2^_\3"+
		"\2\2\2_\7\3\2\2\2`a\7\7\2\2ab\7\4\2\2bc\5\n\6\2cd\7\5\2\2d\t\3\2\2\2e"+
		"j\5$\23\2fg\7\b\2\2gi\5$\23\2hf\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2"+
		"k\13\3\2\2\2lj\3\2\2\2mn\7\t\2\2no\7\4\2\2op\5\16\b\2pq\7\5\2\2q\r\3\2"+
		"\2\2rw\5&\24\2st\7\b\2\2tv\5&\24\2us\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2"+
		"\2\2x\17\3\2\2\2yw\3\2\2\2z{\7\n\2\2{|\7\4\2\2|}\5\22\n\2}~\7\5\2\2~\21"+
		"\3\2\2\2\177\u0084\5(\25\2\u0080\u0081\7\b\2\2\u0081\u0083\5(\25\2\u0082"+
		"\u0080\3\2\2\2\u0083\u0086\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2"+
		"\2\2\u0085\23\3\2\2\2\u0086\u0084\3\2\2\2\u0087\u0088\7\13\2\2\u0088\u008a"+
		"\7\4\2\2\u0089\u008b\5\26\f\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2"+
		"\u008c\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\25\3\2\2\2\u008e\u008f"+
		"\5\30\r\2\u008f\u0090\7\4\2\2\u0090\u0092\5\32\16\2\u0091\u0093\5 \21"+
		"\2\u0092\u0091\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0095\3\2\2\2\u0094\u0096"+
		"\5\"\22\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u0097\3\2\2\2"+
		"\u0097\u0098\7\5\2\2\u0098\27\3\2\2\2\u0099\u009b\7\"\2\2\u009a\u0099"+
		"\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d"+
		"\31\3\2\2\2\u009e\u00a0\5\36\20\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2"+
		"\2\2\u00a0\u00a1\3\2\2\2\u00a1\u00a2\7\f\2\2\u00a2\u00a3\5\34\17\2\u00a3"+
		"\33\3\2\2\2\u00a4\u00a5\5> \2\u00a5\35\3\2\2\2\u00a6\u00a9\7!\2\2\u00a7"+
		"\u00a9\5> \2\u00a8\u00a6\3\2\2\2\u00a8\u00a7\3\2\2\2\u00a9\37\3\2\2\2"+
		"\u00aa\u00ab\7\r\2\2\u00ab\u00ac\5&\24\2\u00ac!\3\2\2\2\u00ad\u00ae\7"+
		"\16\2\2\u00ae\u00af\5\60\31\2\u00af#\3\2\2\2\u00b0\u00b1\7 \2\2\u00b1"+
		"%\3\2\2\2\u00b2\u00b3\5> \2\u00b3\'\3\2\2\2\u00b4\u00b5\5> \2\u00b5)\3"+
		"\2\2\2\u00b6\u00b7\7 \2\2\u00b7+\3\2\2\2\u00b8\u00b9\5> \2\u00b9-\3\2"+
		"\2\2\u00ba\u00bb\5> \2\u00bb/\3\2\2\2\u00bc\u00bd\5\62\32\2\u00bd\61\3"+
		"\2\2\2\u00be\u00c1\5\64\33\2\u00bf\u00c0\7\27\2\2\u00c0\u00c2\5\62\32"+
		"\2\u00c1\u00bf\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2\63\3\2\2\2\u00c3\u00c6"+
		"\5\66\34\2\u00c4\u00c5\7\30\2\2\u00c5\u00c7\5\64\33\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7\65\3\2\2\2\u00c8\u00cb\58\35\2\u00c9\u00ca"+
		"\t\2\2\2\u00ca\u00cc\5\66\34\2\u00cb\u00c9\3\2\2\2\u00cb\u00cc\3\2\2\2"+
		"\u00cc\67\3\2\2\2\u00cd\u00d0\5:\36\2\u00ce\u00cf\t\3\2\2\u00cf\u00d1"+
		"\58\35\2\u00d0\u00ce\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d19\3\2\2\2\u00d2"+
		"\u00d5\5<\37\2\u00d3\u00d4\t\4\2\2\u00d4\u00d6\5:\36\2\u00d5\u00d3\3\2"+
		"\2\2\u00d5\u00d6\3\2\2\2\u00d6;\3\2\2\2\u00d7\u00d9\7\34\2\2\u00d8\u00d7"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\u00e7\3\2\2\2\u00da\u00dd\7!\2\2\u00db"+
		"\u00dd\5> \2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\u00e8\3\2\2"+
		"\2\u00de\u00df\7\23\2\2\u00df\u00e0\5\62\32\2\u00e0\u00e1\7\24\2\2\u00e1"+
		"\u00e8\3\2\2\2\u00e2\u00e4\7\"\2\2\u00e3\u00e2\3\2\2\2\u00e4\u00e5\3\2"+
		"\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7"+
		"\u00dc\3\2\2\2\u00e7\u00de\3\2\2\2\u00e7\u00e3\3\2\2\2\u00e8=\3\2\2\2"+
		"\u00e9\u00eb\7 \2\2\u00ea\u00ec\5@!\2\u00eb\u00ea\3\2\2\2\u00eb\u00ec"+
		"\3\2\2\2\u00ec\u00ee\3\2\2\2\u00ed\u00ef\5H%\2\u00ee\u00ed\3\2\2\2\u00ee"+
		"\u00ef\3\2\2\2\u00ef?\3\2\2\2\u00f0\u00f1\7\23\2\2\u00f1\u00f2\5B\"\2"+
		"\u00f2\u00f3\7\24\2\2\u00f3A\3\2\2\2\u00f4\u00f9\5D#\2\u00f5\u00f6\7\b"+
		"\2\2\u00f6\u00f8\5D#\2\u00f7\u00f5\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faC\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u010d\7!\2\2\u00fd\u010d\7#\2\2\u00fe\u010d\7\33\2\2\u00ff\u0101\7\""+
		"\2\2\u0100\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103\u010d\3\2\2\2\u0104\u0106\7 \2\2\u0105\u0107\5@!"+
		"\2\u0106\u0105\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u010d\3\2\2\2\u0108\u0109"+
		"\7\23\2\2\u0109\u010a\5\62\32\2\u010a\u010b\7\24\2\2\u010b\u010d\3\2\2"+
		"\2\u010c\u00fc\3\2\2\2\u010c\u00fd\3\2\2\2\u010c\u00fe\3\2\2\2\u010c\u0100"+
		"\3\2\2\2\u010c\u0104\3\2\2\2\u010c\u0108\3\2\2\2\u010dE\3\2\2\2\u010e"+
		"\u010f\5H%\2\u010fG\3\2\2\2\u0110\u0111\7\25\2\2\u0111\u0116\5J&\2\u0112"+
		"\u0113\7\b\2\2\u0113\u0115\5J&\2\u0114\u0112\3\2\2\2\u0115\u0118\3\2\2"+
		"\2\u0116\u0114\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0119\3\2\2\2\u0118\u0116"+
		"\3\2\2\2\u0119\u011a\7\26\2\2\u011aI\3\2\2\2\u011b\u011f\5H%\2\u011c\u011f"+
		"\58\35\2\u011d\u011f\7\33\2\2\u011e\u011b\3\2\2\2\u011e\u011c\3\2\2\2"+
		"\u011e\u011d\3\2\2\2\u011fK\3\2\2\2\37N\\^jw\u0084\u008c\u0092\u0095\u009c"+
		"\u009f\u00a8\u00c1\u00c6\u00cb\u00d0\u00d5\u00d8\u00dc\u00e5\u00e7\u00eb"+
		"\u00ee\u00f9\u0102\u0106\u010c\u0116\u011e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}