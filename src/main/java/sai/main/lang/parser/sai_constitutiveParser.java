// Generated from sai_constitutive.g by ANTLR 4.7.2

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
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, TK_OR=22, TK_AND=23, TK_REL_OP=24, 
		TK_IS=25, STRING=26, NEGATION=27, TK_NEG=28, INTDIV=29, INTMOD=30, ATOM=31, 
		VAR=32, DIGIT=33, TERM_NULL=34, SPECIAL_CHAR_TERM=35, COMMENT_STAT=36, 
		WS=37;
	public static final int
		RULE_constitutive_spec = 0, RULE_normative_id = 1, RULE_status_functions = 2, 
		RULE_agent_sf_decl = 3, RULE_agent_sf_list = 4, RULE_event_sf_decl = 5, 
		RULE_event_sf_list = 6, RULE_state_sf_decl = 7, RULE_state_sf_list = 8, 
		RULE_constitutive_rules = 9, RULE_const_rule = 10, RULE_id = 11, RULE_count_as_stat = 12, 
		RULE_y = 13, RULE_x = 14, RULE_t = 15, RULE_m = 16, RULE_agent_sf = 17, 
		RULE_event_sf = 18, RULE_state_sf = 19, RULE_agent_x = 20, RULE_event_x = 21, 
		RULE_state_x = 22, RULE_sf_formula = 23, RULE_sff_or_expr = 24, RULE_sff_and_expr = 25, 
		RULE_sff_rel = 26, RULE_arithm_term = 27, RULE_arithm_factor = 28, RULE_sff_atom = 29, 
		RULE_sai__is_term = 30, RULE_pred = 31, RULE_list_of_pred_terms = 32, 
		RULE_pred_terms = 33, RULE_pred_term = 34, RULE_annotation = 35, RULE_list = 36, 
		RULE_list_term = 37;
	private static String[] makeRuleNames() {
		return new String[] {
			"constitutive_spec", "normative_id", "status_functions", "agent_sf_decl", 
			"agent_sf_list", "event_sf_decl", "event_sf_list", "state_sf_decl", "state_sf_list", 
			"constitutive_rules", "const_rule", "id", "count_as_stat", "y", "x", 
			"t", "m", "agent_sf", "event_sf", "state_sf", "agent_x", "event_x", "state_x", 
			"sf_formula", "sff_or_expr", "sff_and_expr", "sff_rel", "arithm_term", 
			"arithm_factor", "sff_atom", "sai__is_term", "pred", "list_of_pred_terms", 
			"pred_terms", "pred_term", "annotation", "list", "list_term"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'institution_id'", "':'", "'.'", "'status_functions'", "'agents'", 
			"','", "'events'", "'states'", "'constitutive_rules'", "'count-as'", 
			"'when'", "'while'", "'+'", "'-'", "'*'", "'/'", "'('", "')'", "'sai__is('", 
			"'['", "']'", "'|'", "'&'", null, "'is'", null, "'not'", "'~'", "'div'", 
			"'mod'", null, null, null, "'_'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, "TK_OR", 
			"TK_AND", "TK_REL_OP", "TK_IS", "STRING", "NEGATION", "TK_NEG", "INTDIV", 
			"INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", "SPECIAL_CHAR_TERM", "COMMENT_STAT", 
			"WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
			setState(76);
			normative_id();
			setState(78);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(77);
				status_functions();
				}
			}

			setState(80);
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
			setState(82);
			match(T__0);
			setState(83);
			match(T__1);
			setState(84);
			match(ATOM);
			setState(85);
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
			setState(87);
			match(T__3);
			setState(88);
			match(T__1);
			setState(92); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(92);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__4:
					{
					setState(89);
					agent_sf_decl();
					}
					break;
				case T__6:
					{
					setState(90);
					event_sf_decl();
					}
					break;
				case T__7:
					{
					setState(91);
					state_sf_decl();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(94); 
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
			setState(96);
			match(T__4);
			setState(97);
			match(T__1);
			setState(98);
			agent_sf_list();
			setState(99);
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
			setState(101);
			agent_sf();
			setState(106);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(102);
				match(T__5);
				setState(103);
				agent_sf();
				}
				}
				setState(108);
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
			setState(109);
			match(T__6);
			setState(110);
			match(T__1);
			setState(111);
			event_sf_list();
			setState(112);
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
			setState(114);
			event_sf();
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(115);
				match(T__5);
				setState(116);
				event_sf();
				}
				}
				setState(121);
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
			setState(122);
			match(T__7);
			setState(123);
			match(T__1);
			setState(124);
			state_sf_list();
			setState(125);
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
			setState(127);
			state_sf();
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(128);
				match(T__5);
				setState(129);
				state_sf();
				}
				}
				setState(134);
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
			setState(135);
			match(T__8);
			setState(136);
			match(T__1);
			setState(138); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(137);
				const_rule();
				}
				}
				setState(140); 
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
			setState(142);
			id();
			setState(143);
			match(T__1);
			setState(144);
			count_as_stat();
			setState(146);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(145);
				t();
				}
			}

			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__11) {
				{
				setState(148);
				m();
				}
			}

			setState(151);
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
			setState(154); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(153);
				match(DIGIT);
				}
				}
				setState(156); 
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
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ATOM || _la==VAR) {
				{
				setState(158);
				x();
				}
			}

			setState(161);
			match(T__9);
			setState(162);
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
			setState(164);
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
			setState(168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				{
				setState(166);
				match(VAR);
				}
				break;
			case ATOM:
				{
				setState(167);
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
			setState(170);
			match(T__10);
			setState(171);
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
			setState(173);
			match(T__11);
			setState(174);
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
			setState(176);
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
		public TerminalNode VAR() { return getToken(sai_constitutiveParser.VAR, 0); }
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
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
		int _la;
		try {
			setState(183);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
				enterOuterAlt(_localctx, 1);
				{
				setState(178);
				pred();
				}
				break;
			case VAR:
				enterOuterAlt(_localctx, 2);
				{
				{
				setState(179);
				match(VAR);
				setState(181);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__19) {
					{
					setState(180);
					annotation();
					}
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
			setState(185);
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
			setState(187);
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
			setState(189);
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
			setState(191);
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
			setState(193);
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
			setState(195);
			sff_and_expr();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_OR) {
				{
				setState(196);
				match(TK_OR);
				setState(197);
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
			setState(200);
			sff_rel();
			setState(203);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_AND) {
				{
				setState(201);
				match(TK_AND);
				setState(202);
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
			setState(205);
			arithm_term();
			setState(208);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==TK_REL_OP || _la==TK_IS) {
				{
				setState(206);
				_la = _input.LA(1);
				if ( !(_la==TK_REL_OP || _la==TK_IS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(207);
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
			setState(210);
			arithm_factor();
			setState(213);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12 || _la==T__13) {
				{
				setState(211);
				_la = _input.LA(1);
				if ( !(_la==T__12 || _la==T__13) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(212);
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
			setState(215);
			sff_atom();
			setState(218);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << INTDIV) | (1L << INTMOD))) != 0)) {
				{
				setState(216);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__14) | (1L << T__15) | (1L << INTDIV) | (1L << INTMOD))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(217);
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
		public Sai__is_termContext sai__is_term() {
			return getRuleContext(Sai__is_termContext.class,0);
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
			setState(221);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEGATION) {
				{
				setState(220);
				match(NEGATION);
				}
			}

			setState(237);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__18:
			case ATOM:
			case VAR:
				{
				setState(226);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case VAR:
					{
					setState(223);
					match(VAR);
					}
					break;
				case ATOM:
					{
					setState(224);
					pred();
					}
					break;
				case T__18:
					{
					setState(225);
					sai__is_term();
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
				setState(228);
				match(T__16);
				setState(229);
				sff_or_expr();
				setState(230);
				match(T__17);
				}
				}
				break;
			case DIGIT:
				{
				{
				setState(233); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(232);
					match(DIGIT);
					}
					}
					setState(235); 
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

	public static class Sai__is_termContext extends ParserRuleContext {
		public List<Pred_termContext> pred_term() {
			return getRuleContexts(Pred_termContext.class);
		}
		public Pred_termContext pred_term(int i) {
			return getRuleContext(Pred_termContext.class,i);
		}
		public Sf_formulaContext sf_formula() {
			return getRuleContext(Sf_formulaContext.class,0);
		}
		public Sai__is_termContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sai__is_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).enterSai__is_term(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof sai_constitutiveListener ) ((sai_constitutiveListener)listener).exitSai__is_term(this);
		}
	}

	public final Sai__is_termContext sai__is_term() throws RecognitionException {
		Sai__is_termContext _localctx = new Sai__is_termContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_sai__is_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(239);
			match(T__18);
			setState(240);
			pred_term();
			setState(241);
			match(T__5);
			setState(242);
			pred_term();
			setState(243);
			match(T__5);
			setState(244);
			sf_formula();
			setState(245);
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
		enterRule(_localctx, 62, RULE_pred);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(247);
			match(ATOM);
			setState(249);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(248);
				list_of_pred_terms();
				}
			}

			setState(252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__19) {
				{
				setState(251);
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
		enterRule(_localctx, 64, RULE_list_of_pred_terms);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			match(T__16);
			setState(255);
			pred_terms();
			setState(256);
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
		enterRule(_localctx, 66, RULE_pred_terms);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			pred_term();
			setState(263);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(259);
				match(T__5);
				setState(260);
				pred_term();
				}
				}
				setState(265);
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
		enterRule(_localctx, 68, RULE_pred_term);
		int _la;
		try {
			setState(282);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case VAR:
				enterOuterAlt(_localctx, 1);
				{
				setState(266);
				match(VAR);
				}
				break;
			case TERM_NULL:
				enterOuterAlt(_localctx, 2);
				{
				setState(267);
				match(TERM_NULL);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 3);
				{
				setState(268);
				match(STRING);
				}
				break;
			case DIGIT:
				enterOuterAlt(_localctx, 4);
				{
				setState(270); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(269);
					match(DIGIT);
					}
					}
					setState(272); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==DIGIT );
				}
				break;
			case ATOM:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				match(ATOM);
				setState(276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(275);
					list_of_pred_terms();
					}
				}

				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 6);
				{
				{
				setState(278);
				match(T__16);
				setState(279);
				sff_or_expr();
				setState(280);
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
		enterRule(_localctx, 70, RULE_annotation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(284);
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
		enterRule(_localctx, 72, RULE_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(286);
			match(T__19);
			setState(287);
			list_term();
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(288);
				match(T__5);
				setState(289);
				list_term();
				}
				}
				setState(294);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(295);
			match(T__20);
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
		enterRule(_localctx, 74, RULE_list_term);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				{
				setState(297);
				list();
				}
				break;
			case T__16:
			case T__18:
			case NEGATION:
			case ATOM:
			case VAR:
			case DIGIT:
				{
				setState(298);
				arithm_term();
				}
				break;
			case STRING:
				{
				setState(299);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\'\u0131\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\5\2Q\n\2\3\2\3\2\3"+
		"\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\6\4_\n\4\r\4\16\4`\3\5\3\5\3\5"+
		"\3\5\3\5\3\6\3\6\3\6\7\6k\n\6\f\6\16\6n\13\6\3\7\3\7\3\7\3\7\3\7\3\b\3"+
		"\b\3\b\7\bx\n\b\f\b\16\b{\13\b\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\n\u0085"+
		"\n\n\f\n\16\n\u0088\13\n\3\13\3\13\3\13\6\13\u008d\n\13\r\13\16\13\u008e"+
		"\3\f\3\f\3\f\3\f\5\f\u0095\n\f\3\f\5\f\u0098\n\f\3\f\3\f\3\r\6\r\u009d"+
		"\n\r\r\r\16\r\u009e\3\16\5\16\u00a2\n\16\3\16\3\16\3\16\3\17\3\17\3\20"+
		"\3\20\5\20\u00ab\n\20\3\21\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\24\3\24"+
		"\3\24\5\24\u00b8\n\24\5\24\u00ba\n\24\3\25\3\25\3\26\3\26\3\27\3\27\3"+
		"\30\3\30\3\31\3\31\3\32\3\32\3\32\5\32\u00c9\n\32\3\33\3\33\3\33\5\33"+
		"\u00ce\n\33\3\34\3\34\3\34\5\34\u00d3\n\34\3\35\3\35\3\35\5\35\u00d8\n"+
		"\35\3\36\3\36\3\36\5\36\u00dd\n\36\3\37\5\37\u00e0\n\37\3\37\3\37\3\37"+
		"\5\37\u00e5\n\37\3\37\3\37\3\37\3\37\3\37\6\37\u00ec\n\37\r\37\16\37\u00ed"+
		"\5\37\u00f0\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\5!\u00fc\n!\3!\5!\u00ff"+
		"\n!\3\"\3\"\3\"\3\"\3#\3#\3#\7#\u0108\n#\f#\16#\u010b\13#\3$\3$\3$\3$"+
		"\6$\u0111\n$\r$\16$\u0112\3$\3$\5$\u0117\n$\3$\3$\3$\3$\5$\u011d\n$\3"+
		"%\3%\3&\3&\3&\3&\7&\u0125\n&\f&\16&\u0128\13&\3&\3&\3\'\3\'\3\'\5\'\u012f"+
		"\n\'\3\'\2\2(\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJL\2\5\3\2\32\33\3\2\17\20\4\2\21\22\37 \2\u0131\2N\3\2\2"+
		"\2\4T\3\2\2\2\6Y\3\2\2\2\bb\3\2\2\2\ng\3\2\2\2\fo\3\2\2\2\16t\3\2\2\2"+
		"\20|\3\2\2\2\22\u0081\3\2\2\2\24\u0089\3\2\2\2\26\u0090\3\2\2\2\30\u009c"+
		"\3\2\2\2\32\u00a1\3\2\2\2\34\u00a6\3\2\2\2\36\u00aa\3\2\2\2 \u00ac\3\2"+
		"\2\2\"\u00af\3\2\2\2$\u00b2\3\2\2\2&\u00b9\3\2\2\2(\u00bb\3\2\2\2*\u00bd"+
		"\3\2\2\2,\u00bf\3\2\2\2.\u00c1\3\2\2\2\60\u00c3\3\2\2\2\62\u00c5\3\2\2"+
		"\2\64\u00ca\3\2\2\2\66\u00cf\3\2\2\28\u00d4\3\2\2\2:\u00d9\3\2\2\2<\u00df"+
		"\3\2\2\2>\u00f1\3\2\2\2@\u00f9\3\2\2\2B\u0100\3\2\2\2D\u0104\3\2\2\2F"+
		"\u011c\3\2\2\2H\u011e\3\2\2\2J\u0120\3\2\2\2L\u012e\3\2\2\2NP\5\4\3\2"+
		"OQ\5\6\4\2PO\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\5\24\13\2S\3\3\2\2\2TU\7\3"+
		"\2\2UV\7\4\2\2VW\7!\2\2WX\7\5\2\2X\5\3\2\2\2YZ\7\6\2\2Z^\7\4\2\2[_\5\b"+
		"\5\2\\_\5\f\7\2]_\5\20\t\2^[\3\2\2\2^\\\3\2\2\2^]\3\2\2\2_`\3\2\2\2`^"+
		"\3\2\2\2`a\3\2\2\2a\7\3\2\2\2bc\7\7\2\2cd\7\4\2\2de\5\n\6\2ef\7\5\2\2"+
		"f\t\3\2\2\2gl\5$\23\2hi\7\b\2\2ik\5$\23\2jh\3\2\2\2kn\3\2\2\2lj\3\2\2"+
		"\2lm\3\2\2\2m\13\3\2\2\2nl\3\2\2\2op\7\t\2\2pq\7\4\2\2qr\5\16\b\2rs\7"+
		"\5\2\2s\r\3\2\2\2ty\5&\24\2uv\7\b\2\2vx\5&\24\2wu\3\2\2\2x{\3\2\2\2yw"+
		"\3\2\2\2yz\3\2\2\2z\17\3\2\2\2{y\3\2\2\2|}\7\n\2\2}~\7\4\2\2~\177\5\22"+
		"\n\2\177\u0080\7\5\2\2\u0080\21\3\2\2\2\u0081\u0086\5(\25\2\u0082\u0083"+
		"\7\b\2\2\u0083\u0085\5(\25\2\u0084\u0082\3\2\2\2\u0085\u0088\3\2\2\2\u0086"+
		"\u0084\3\2\2\2\u0086\u0087\3\2\2\2\u0087\23\3\2\2\2\u0088\u0086\3\2\2"+
		"\2\u0089\u008a\7\13\2\2\u008a\u008c\7\4\2\2\u008b\u008d\5\26\f\2\u008c"+
		"\u008b\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008c\3\2\2\2\u008e\u008f\3\2"+
		"\2\2\u008f\25\3\2\2\2\u0090\u0091\5\30\r\2\u0091\u0092\7\4\2\2\u0092\u0094"+
		"\5\32\16\2\u0093\u0095\5 \21\2\u0094\u0093\3\2\2\2\u0094\u0095\3\2\2\2"+
		"\u0095\u0097\3\2\2\2\u0096\u0098\5\"\22\2\u0097\u0096\3\2\2\2\u0097\u0098"+
		"\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\7\5\2\2\u009a\27\3\2\2\2\u009b"+
		"\u009d\7#\2\2\u009c\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u009c\3\2"+
		"\2\2\u009e\u009f\3\2\2\2\u009f\31\3\2\2\2\u00a0\u00a2\5\36\20\2\u00a1"+
		"\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\7\f"+
		"\2\2\u00a4\u00a5\5\34\17\2\u00a5\33\3\2\2\2\u00a6\u00a7\5@!\2\u00a7\35"+
		"\3\2\2\2\u00a8\u00ab\7\"\2\2\u00a9\u00ab\5@!\2\u00aa\u00a8\3\2\2\2\u00aa"+
		"\u00a9\3\2\2\2\u00ab\37\3\2\2\2\u00ac\u00ad\7\r\2\2\u00ad\u00ae\5&\24"+
		"\2\u00ae!\3\2\2\2\u00af\u00b0\7\16\2\2\u00b0\u00b1\5\60\31\2\u00b1#\3"+
		"\2\2\2\u00b2\u00b3\7!\2\2\u00b3%\3\2\2\2\u00b4\u00ba\5@!\2\u00b5\u00b7"+
		"\7\"\2\2\u00b6\u00b8\5H%\2\u00b7\u00b6\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00ba\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b5\3\2\2\2\u00ba\'\3\2\2\2"+
		"\u00bb\u00bc\5@!\2\u00bc)\3\2\2\2\u00bd\u00be\7!\2\2\u00be+\3\2\2\2\u00bf"+
		"\u00c0\5@!\2\u00c0-\3\2\2\2\u00c1\u00c2\5@!\2\u00c2/\3\2\2\2\u00c3\u00c4"+
		"\5\62\32\2\u00c4\61\3\2\2\2\u00c5\u00c8\5\64\33\2\u00c6\u00c7\7\30\2\2"+
		"\u00c7\u00c9\5\62\32\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9\63"+
		"\3\2\2\2\u00ca\u00cd\5\66\34\2\u00cb\u00cc\7\31\2\2\u00cc\u00ce\5\64\33"+
		"\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\65\3\2\2\2\u00cf\u00d2"+
		"\58\35\2\u00d0\u00d1\t\2\2\2\u00d1\u00d3\5\66\34\2\u00d2\u00d0\3\2\2\2"+
		"\u00d2\u00d3\3\2\2\2\u00d3\67\3\2\2\2\u00d4\u00d7\5:\36\2\u00d5\u00d6"+
		"\t\3\2\2\u00d6\u00d8\58\35\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2\2\2\u00d8"+
		"9\3\2\2\2\u00d9\u00dc\5<\37\2\u00da\u00db\t\4\2\2\u00db\u00dd\5:\36\2"+
		"\u00dc\u00da\3\2\2\2\u00dc\u00dd\3\2\2\2\u00dd;\3\2\2\2\u00de\u00e0\7"+
		"\35\2\2\u00df\u00de\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00ef\3\2\2\2\u00e1"+
		"\u00e5\7\"\2\2\u00e2\u00e5\5@!\2\u00e3\u00e5\5> \2\u00e4\u00e1\3\2\2\2"+
		"\u00e4\u00e2\3\2\2\2\u00e4\u00e3\3\2\2\2\u00e5\u00f0\3\2\2\2\u00e6\u00e7"+
		"\7\23\2\2\u00e7\u00e8\5\62\32\2\u00e8\u00e9\7\24\2\2\u00e9\u00f0\3\2\2"+
		"\2\u00ea\u00ec\7#\2\2\u00eb\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed\u00eb"+
		"\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00f0\3\2\2\2\u00ef\u00e4\3\2\2\2\u00ef"+
		"\u00e6\3\2\2\2\u00ef\u00eb\3\2\2\2\u00f0=\3\2\2\2\u00f1\u00f2\7\25\2\2"+
		"\u00f2\u00f3\5F$\2\u00f3\u00f4\7\b\2\2\u00f4\u00f5\5F$\2\u00f5\u00f6\7"+
		"\b\2\2\u00f6\u00f7\5\60\31\2\u00f7\u00f8\7\24\2\2\u00f8?\3\2\2\2\u00f9"+
		"\u00fb\7!\2\2\u00fa\u00fc\5B\"\2\u00fb\u00fa\3\2\2\2\u00fb\u00fc\3\2\2"+
		"\2\u00fc\u00fe\3\2\2\2\u00fd\u00ff\5J&\2\u00fe\u00fd\3\2\2\2\u00fe\u00ff"+
		"\3\2\2\2\u00ffA\3\2\2\2\u0100\u0101\7\23\2\2\u0101\u0102\5D#\2\u0102\u0103"+
		"\7\24\2\2\u0103C\3\2\2\2\u0104\u0109\5F$\2\u0105\u0106\7\b\2\2\u0106\u0108"+
		"\5F$\2\u0107\u0105\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2\2\u0109"+
		"\u010a\3\2\2\2\u010aE\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u011d\7\"\2\2"+
		"\u010d\u011d\7$\2\2\u010e\u011d\7\34\2\2\u010f\u0111\7#\2\2\u0110\u010f"+
		"\3\2\2\2\u0111\u0112\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0113\3\2\2\2\u0113"+
		"\u011d\3\2\2\2\u0114\u0116\7!\2\2\u0115\u0117\5B\"\2\u0116\u0115\3\2\2"+
		"\2\u0116\u0117\3\2\2\2\u0117\u011d\3\2\2\2\u0118\u0119\7\23\2\2\u0119"+
		"\u011a\5\62\32\2\u011a\u011b\7\24\2\2\u011b\u011d\3\2\2\2\u011c\u010c"+
		"\3\2\2\2\u011c\u010d\3\2\2\2\u011c\u010e\3\2\2\2\u011c\u0110\3\2\2\2\u011c"+
		"\u0114\3\2\2\2\u011c\u0118\3\2\2\2\u011dG\3\2\2\2\u011e\u011f\5J&\2\u011f"+
		"I\3\2\2\2\u0120\u0121\7\26\2\2\u0121\u0126\5L\'\2\u0122\u0123\7\b\2\2"+
		"\u0123\u0125\5L\'\2\u0124\u0122\3\2\2\2\u0125\u0128\3\2\2\2\u0126\u0124"+
		"\3\2\2\2\u0126\u0127\3\2\2\2\u0127\u0129\3\2\2\2\u0128\u0126\3\2\2\2\u0129"+
		"\u012a\7\27\2\2\u012aK\3\2\2\2\u012b\u012f\5J&\2\u012c\u012f\58\35\2\u012d"+
		"\u012f\7\34\2\2\u012e\u012b\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012d\3"+
		"\2\2\2\u012fM\3\2\2\2!P^`ly\u0086\u008e\u0094\u0097\u009e\u00a1\u00aa"+
		"\u00b7\u00b9\u00c8\u00cd\u00d2\u00d7\u00dc\u00df\u00e4\u00ed\u00ef\u00fb"+
		"\u00fe\u0109\u0112\u0116\u011c\u0126\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
