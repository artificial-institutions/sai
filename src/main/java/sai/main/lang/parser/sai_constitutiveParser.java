// Generated from sai_constitutive.g by ANTLR 4.12.0

package sai.main.lang.parser;


import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class sai_constitutiveParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 416L) != 0) );
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1610711040L) != 0)) {
				{
				setState(216);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1610711040L) != 0)) ) {
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
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

	@SuppressWarnings("CheckReturnValue")
	public static class Pred_termContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(sai_constitutiveParser.VAR, 0); }
		public TerminalNode TERM_NULL() { return getToken(sai_constitutiveParser.TERM_NULL, 0); }
		public TerminalNode STRING() { return getToken(sai_constitutiveParser.STRING, 0); }
		public List<TerminalNode> DIGIT() { return getTokens(sai_constitutiveParser.DIGIT); }
		public TerminalNode DIGIT(int i) {
			return getToken(sai_constitutiveParser.DIGIT, i);
		}
		public ListContext list() {
			return getRuleContext(ListContext.class,0);
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
			setState(283);
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
			case T__19:
				enterOuterAlt(_localctx, 5);
				{
				setState(274);
				list();
				}
				break;
			case ATOM:
				enterOuterAlt(_localctx, 6);
				{
				setState(275);
				match(ATOM);
				setState(277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==T__16) {
					{
					setState(276);
					list_of_pred_terms();
					}
				}

				}
				break;
			case T__16:
				enterOuterAlt(_localctx, 7);
				{
				{
				setState(279);
				match(T__16);
				setState(280);
				sff_or_expr();
				setState(281);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(285);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(287);
			match(T__19);
			setState(288);
			list_term();
			setState(293);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__5) {
				{
				{
				setState(289);
				match(T__5);
				setState(290);
				list_term();
				}
				}
				setState(295);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(296);
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

	@SuppressWarnings("CheckReturnValue")
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
			setState(301);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__19:
				{
				setState(298);
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
				setState(299);
				arithm_term();
				}
				break;
			case STRING:
				{
				setState(300);
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
		"\u0004\u0001%\u0130\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"+
		"\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"+
		"\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"+
		"\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"+
		"\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0002"+
		"#\u0007#\u0002$\u0007$\u0002%\u0007%\u0001\u0000\u0001\u0000\u0003\u0000"+
		"O\b\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002"+
		"\u0001\u0002\u0004\u0002]\b\u0002\u000b\u0002\f\u0002^\u0001\u0003\u0001"+
		"\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0005\u0004i\b\u0004\n\u0004\f\u0004l\t\u0004\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001"+
		"\u0006\u0005\u0006v\b\u0006\n\u0006\f\u0006y\t\u0006\u0001\u0007\u0001"+
		"\u0007\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0005"+
		"\b\u0083\b\b\n\b\f\b\u0086\t\b\u0001\t\u0001\t\u0001\t\u0004\t\u008b\b"+
		"\t\u000b\t\f\t\u008c\u0001\n\u0001\n\u0001\n\u0001\n\u0003\n\u0093\b\n"+
		"\u0001\n\u0003\n\u0096\b\n\u0001\n\u0001\n\u0001\u000b\u0004\u000b\u009b"+
		"\b\u000b\u000b\u000b\f\u000b\u009c\u0001\f\u0003\f\u00a0\b\f\u0001\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u00a9\b"+
		"\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001"+
		"\u0010\u0001\u0011\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0003"+
		"\u0012\u00b6\b\u0012\u0003\u0012\u00b8\b\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0016\u0001\u0016"+
		"\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001\u0018\u0003\u0018"+
		"\u00c7\b\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u00cc\b"+
		"\u0019\u0001\u001a\u0001\u001a\u0001\u001a\u0003\u001a\u00d1\b\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u00d6\b\u001b\u0001\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u00db\b\u001c\u0001\u001d\u0003\u001d\u00de"+
		"\b\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u00e3\b\u001d"+
		"\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0004\u001d"+
		"\u00ea\b\u001d\u000b\u001d\f\u001d\u00eb\u0003\u001d\u00ee\b\u001d\u0001"+
		"\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001\u001e\u0001"+
		"\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0003\u001f\u00fa\b\u001f\u0001"+
		"\u001f\u0003\u001f\u00fd\b\u001f\u0001 \u0001 \u0001 \u0001 \u0001!\u0001"+
		"!\u0001!\u0005!\u0106\b!\n!\f!\u0109\t!\u0001\"\u0001\"\u0001\"\u0001"+
		"\"\u0004\"\u010f\b\"\u000b\"\f\"\u0110\u0001\"\u0001\"\u0001\"\u0003\""+
		"\u0116\b\"\u0001\"\u0001\"\u0001\"\u0001\"\u0003\"\u011c\b\"\u0001#\u0001"+
		"#\u0001$\u0001$\u0001$\u0001$\u0005$\u0124\b$\n$\f$\u0127\t$\u0001$\u0001"+
		"$\u0001%\u0001%\u0001%\u0003%\u012e\b%\u0001%\u0000\u0000&\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJ\u0000\u0003\u0001\u0000\u0018\u0019\u0001\u0000"+
		"\r\u000e\u0002\u0000\u000f\u0010\u001d\u001e\u0131\u0000L\u0001\u0000"+
		"\u0000\u0000\u0002R\u0001\u0000\u0000\u0000\u0004W\u0001\u0000\u0000\u0000"+
		"\u0006`\u0001\u0000\u0000\u0000\be\u0001\u0000\u0000\u0000\nm\u0001\u0000"+
		"\u0000\u0000\fr\u0001\u0000\u0000\u0000\u000ez\u0001\u0000\u0000\u0000"+
		"\u0010\u007f\u0001\u0000\u0000\u0000\u0012\u0087\u0001\u0000\u0000\u0000"+
		"\u0014\u008e\u0001\u0000\u0000\u0000\u0016\u009a\u0001\u0000\u0000\u0000"+
		"\u0018\u009f\u0001\u0000\u0000\u0000\u001a\u00a4\u0001\u0000\u0000\u0000"+
		"\u001c\u00a8\u0001\u0000\u0000\u0000\u001e\u00aa\u0001\u0000\u0000\u0000"+
		" \u00ad\u0001\u0000\u0000\u0000\"\u00b0\u0001\u0000\u0000\u0000$\u00b7"+
		"\u0001\u0000\u0000\u0000&\u00b9\u0001\u0000\u0000\u0000(\u00bb\u0001\u0000"+
		"\u0000\u0000*\u00bd\u0001\u0000\u0000\u0000,\u00bf\u0001\u0000\u0000\u0000"+
		".\u00c1\u0001\u0000\u0000\u00000\u00c3\u0001\u0000\u0000\u00002\u00c8"+
		"\u0001\u0000\u0000\u00004\u00cd\u0001\u0000\u0000\u00006\u00d2\u0001\u0000"+
		"\u0000\u00008\u00d7\u0001\u0000\u0000\u0000:\u00dd\u0001\u0000\u0000\u0000"+
		"<\u00ef\u0001\u0000\u0000\u0000>\u00f7\u0001\u0000\u0000\u0000@\u00fe"+
		"\u0001\u0000\u0000\u0000B\u0102\u0001\u0000\u0000\u0000D\u011b\u0001\u0000"+
		"\u0000\u0000F\u011d\u0001\u0000\u0000\u0000H\u011f\u0001\u0000\u0000\u0000"+
		"J\u012d\u0001\u0000\u0000\u0000LN\u0003\u0002\u0001\u0000MO\u0003\u0004"+
		"\u0002\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OP\u0001"+
		"\u0000\u0000\u0000PQ\u0003\u0012\t\u0000Q\u0001\u0001\u0000\u0000\u0000"+
		"RS\u0005\u0001\u0000\u0000ST\u0005\u0002\u0000\u0000TU\u0005\u001f\u0000"+
		"\u0000UV\u0005\u0003\u0000\u0000V\u0003\u0001\u0000\u0000\u0000WX\u0005"+
		"\u0004\u0000\u0000X\\\u0005\u0002\u0000\u0000Y]\u0003\u0006\u0003\u0000"+
		"Z]\u0003\n\u0005\u0000[]\u0003\u000e\u0007\u0000\\Y\u0001\u0000\u0000"+
		"\u0000\\Z\u0001\u0000\u0000\u0000\\[\u0001\u0000\u0000\u0000]^\u0001\u0000"+
		"\u0000\u0000^\\\u0001\u0000\u0000\u0000^_\u0001\u0000\u0000\u0000_\u0005"+
		"\u0001\u0000\u0000\u0000`a\u0005\u0005\u0000\u0000ab\u0005\u0002\u0000"+
		"\u0000bc\u0003\b\u0004\u0000cd\u0005\u0003\u0000\u0000d\u0007\u0001\u0000"+
		"\u0000\u0000ej\u0003\"\u0011\u0000fg\u0005\u0006\u0000\u0000gi\u0003\""+
		"\u0011\u0000hf\u0001\u0000\u0000\u0000il\u0001\u0000\u0000\u0000jh\u0001"+
		"\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000k\t\u0001\u0000\u0000\u0000"+
		"lj\u0001\u0000\u0000\u0000mn\u0005\u0007\u0000\u0000no\u0005\u0002\u0000"+
		"\u0000op\u0003\f\u0006\u0000pq\u0005\u0003\u0000\u0000q\u000b\u0001\u0000"+
		"\u0000\u0000rw\u0003$\u0012\u0000st\u0005\u0006\u0000\u0000tv\u0003$\u0012"+
		"\u0000us\u0001\u0000\u0000\u0000vy\u0001\u0000\u0000\u0000wu\u0001\u0000"+
		"\u0000\u0000wx\u0001\u0000\u0000\u0000x\r\u0001\u0000\u0000\u0000yw\u0001"+
		"\u0000\u0000\u0000z{\u0005\b\u0000\u0000{|\u0005\u0002\u0000\u0000|}\u0003"+
		"\u0010\b\u0000}~\u0005\u0003\u0000\u0000~\u000f\u0001\u0000\u0000\u0000"+
		"\u007f\u0084\u0003&\u0013\u0000\u0080\u0081\u0005\u0006\u0000\u0000\u0081"+
		"\u0083\u0003&\u0013\u0000\u0082\u0080\u0001\u0000\u0000\u0000\u0083\u0086"+
		"\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000\u0084\u0085"+
		"\u0001\u0000\u0000\u0000\u0085\u0011\u0001\u0000\u0000\u0000\u0086\u0084"+
		"\u0001\u0000\u0000\u0000\u0087\u0088\u0005\t\u0000\u0000\u0088\u008a\u0005"+
		"\u0002\u0000\u0000\u0089\u008b\u0003\u0014\n\u0000\u008a\u0089\u0001\u0000"+
		"\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008a\u0001\u0000"+
		"\u0000\u0000\u008c\u008d\u0001\u0000\u0000\u0000\u008d\u0013\u0001\u0000"+
		"\u0000\u0000\u008e\u008f\u0003\u0016\u000b\u0000\u008f\u0090\u0005\u0002"+
		"\u0000\u0000\u0090\u0092\u0003\u0018\f\u0000\u0091\u0093\u0003\u001e\u000f"+
		"\u0000\u0092\u0091\u0001\u0000\u0000\u0000\u0092\u0093\u0001\u0000\u0000"+
		"\u0000\u0093\u0095\u0001\u0000\u0000\u0000\u0094\u0096\u0003 \u0010\u0000"+
		"\u0095\u0094\u0001\u0000\u0000\u0000\u0095\u0096\u0001\u0000\u0000\u0000"+
		"\u0096\u0097\u0001\u0000\u0000\u0000\u0097\u0098\u0005\u0003\u0000\u0000"+
		"\u0098\u0015\u0001\u0000\u0000\u0000\u0099\u009b\u0005!\u0000\u0000\u009a"+
		"\u0099\u0001\u0000\u0000\u0000\u009b\u009c\u0001\u0000\u0000\u0000\u009c"+
		"\u009a\u0001\u0000\u0000\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d"+
		"\u0017\u0001\u0000\u0000\u0000\u009e\u00a0\u0003\u001c\u000e\u0000\u009f"+
		"\u009e\u0001\u0000\u0000\u0000\u009f\u00a0\u0001\u0000\u0000\u0000\u00a0"+
		"\u00a1\u0001\u0000\u0000\u0000\u00a1\u00a2\u0005\n\u0000\u0000\u00a2\u00a3"+
		"\u0003\u001a\r\u0000\u00a3\u0019\u0001\u0000\u0000\u0000\u00a4\u00a5\u0003"+
		">\u001f\u0000\u00a5\u001b\u0001\u0000\u0000\u0000\u00a6\u00a9\u0005 \u0000"+
		"\u0000\u00a7\u00a9\u0003>\u001f\u0000\u00a8\u00a6\u0001\u0000\u0000\u0000"+
		"\u00a8\u00a7\u0001\u0000\u0000\u0000\u00a9\u001d\u0001\u0000\u0000\u0000"+
		"\u00aa\u00ab\u0005\u000b\u0000\u0000\u00ab\u00ac\u0003$\u0012\u0000\u00ac"+
		"\u001f\u0001\u0000\u0000\u0000\u00ad\u00ae\u0005\f\u0000\u0000\u00ae\u00af"+
		"\u0003.\u0017\u0000\u00af!\u0001\u0000\u0000\u0000\u00b0\u00b1\u0005\u001f"+
		"\u0000\u0000\u00b1#\u0001\u0000\u0000\u0000\u00b2\u00b8\u0003>\u001f\u0000"+
		"\u00b3\u00b5\u0005 \u0000\u0000\u00b4\u00b6\u0003F#\u0000\u00b5\u00b4"+
		"\u0001\u0000\u0000\u0000\u00b5\u00b6\u0001\u0000\u0000\u0000\u00b6\u00b8"+
		"\u0001\u0000\u0000\u0000\u00b7\u00b2\u0001\u0000\u0000\u0000\u00b7\u00b3"+
		"\u0001\u0000\u0000\u0000\u00b8%\u0001\u0000\u0000\u0000\u00b9\u00ba\u0003"+
		">\u001f\u0000\u00ba\'\u0001\u0000\u0000\u0000\u00bb\u00bc\u0005\u001f"+
		"\u0000\u0000\u00bc)\u0001\u0000\u0000\u0000\u00bd\u00be\u0003>\u001f\u0000"+
		"\u00be+\u0001\u0000\u0000\u0000\u00bf\u00c0\u0003>\u001f\u0000\u00c0-"+
		"\u0001\u0000\u0000\u0000\u00c1\u00c2\u00030\u0018\u0000\u00c2/\u0001\u0000"+
		"\u0000\u0000\u00c3\u00c6\u00032\u0019\u0000\u00c4\u00c5\u0005\u0016\u0000"+
		"\u0000\u00c5\u00c7\u00030\u0018\u0000\u00c6\u00c4\u0001\u0000\u0000\u0000"+
		"\u00c6\u00c7\u0001\u0000\u0000\u0000\u00c71\u0001\u0000\u0000\u0000\u00c8"+
		"\u00cb\u00034\u001a\u0000\u00c9\u00ca\u0005\u0017\u0000\u0000\u00ca\u00cc"+
		"\u00032\u0019\u0000\u00cb\u00c9\u0001\u0000\u0000\u0000\u00cb\u00cc\u0001"+
		"\u0000\u0000\u0000\u00cc3\u0001\u0000\u0000\u0000\u00cd\u00d0\u00036\u001b"+
		"\u0000\u00ce\u00cf\u0007\u0000\u0000\u0000\u00cf\u00d1\u00034\u001a\u0000"+
		"\u00d0\u00ce\u0001\u0000\u0000\u0000\u00d0\u00d1\u0001\u0000\u0000\u0000"+
		"\u00d15\u0001\u0000\u0000\u0000\u00d2\u00d5\u00038\u001c\u0000\u00d3\u00d4"+
		"\u0007\u0001\u0000\u0000\u00d4\u00d6\u00036\u001b\u0000\u00d5\u00d3\u0001"+
		"\u0000\u0000\u0000\u00d5\u00d6\u0001\u0000\u0000\u0000\u00d67\u0001\u0000"+
		"\u0000\u0000\u00d7\u00da\u0003:\u001d\u0000\u00d8\u00d9\u0007\u0002\u0000"+
		"\u0000\u00d9\u00db\u00038\u001c\u0000\u00da\u00d8\u0001\u0000\u0000\u0000"+
		"\u00da\u00db\u0001\u0000\u0000\u0000\u00db9\u0001\u0000\u0000\u0000\u00dc"+
		"\u00de\u0005\u001b\u0000\u0000\u00dd\u00dc\u0001\u0000\u0000\u0000\u00dd"+
		"\u00de\u0001\u0000\u0000\u0000\u00de\u00ed\u0001\u0000\u0000\u0000\u00df"+
		"\u00e3\u0005 \u0000\u0000\u00e0\u00e3\u0003>\u001f\u0000\u00e1\u00e3\u0003"+
		"<\u001e\u0000\u00e2\u00df\u0001\u0000\u0000\u0000\u00e2\u00e0\u0001\u0000"+
		"\u0000\u0000\u00e2\u00e1\u0001\u0000\u0000\u0000\u00e3\u00ee\u0001\u0000"+
		"\u0000\u0000\u00e4\u00e5\u0005\u0011\u0000\u0000\u00e5\u00e6\u00030\u0018"+
		"\u0000\u00e6\u00e7\u0005\u0012\u0000\u0000\u00e7\u00ee\u0001\u0000\u0000"+
		"\u0000\u00e8\u00ea\u0005!\u0000\u0000\u00e9\u00e8\u0001\u0000\u0000\u0000"+
		"\u00ea\u00eb\u0001\u0000\u0000\u0000\u00eb\u00e9\u0001\u0000\u0000\u0000"+
		"\u00eb\u00ec\u0001\u0000\u0000\u0000\u00ec\u00ee\u0001\u0000\u0000\u0000"+
		"\u00ed\u00e2\u0001\u0000\u0000\u0000\u00ed\u00e4\u0001\u0000\u0000\u0000"+
		"\u00ed\u00e9\u0001\u0000\u0000\u0000\u00ee;\u0001\u0000\u0000\u0000\u00ef"+
		"\u00f0\u0005\u0013\u0000\u0000\u00f0\u00f1\u0003D\"\u0000\u00f1\u00f2"+
		"\u0005\u0006\u0000\u0000\u00f2\u00f3\u0003D\"\u0000\u00f3\u00f4\u0005"+
		"\u0006\u0000\u0000\u00f4\u00f5\u0003.\u0017\u0000\u00f5\u00f6\u0005\u0012"+
		"\u0000\u0000\u00f6=\u0001\u0000\u0000\u0000\u00f7\u00f9\u0005\u001f\u0000"+
		"\u0000\u00f8\u00fa\u0003@ \u0000\u00f9\u00f8\u0001\u0000\u0000\u0000\u00f9"+
		"\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0001\u0000\u0000\u0000\u00fb"+
		"\u00fd\u0003H$\u0000\u00fc\u00fb\u0001\u0000\u0000\u0000\u00fc\u00fd\u0001"+
		"\u0000\u0000\u0000\u00fd?\u0001\u0000\u0000\u0000\u00fe\u00ff\u0005\u0011"+
		"\u0000\u0000\u00ff\u0100\u0003B!\u0000\u0100\u0101\u0005\u0012\u0000\u0000"+
		"\u0101A\u0001\u0000\u0000\u0000\u0102\u0107\u0003D\"\u0000\u0103\u0104"+
		"\u0005\u0006\u0000\u0000\u0104\u0106\u0003D\"\u0000\u0105\u0103\u0001"+
		"\u0000\u0000\u0000\u0106\u0109\u0001\u0000\u0000\u0000\u0107\u0105\u0001"+
		"\u0000\u0000\u0000\u0107\u0108\u0001\u0000\u0000\u0000\u0108C\u0001\u0000"+
		"\u0000\u0000\u0109\u0107\u0001\u0000\u0000\u0000\u010a\u011c\u0005 \u0000"+
		"\u0000\u010b\u011c\u0005\"\u0000\u0000\u010c\u011c\u0005\u001a\u0000\u0000"+
		"\u010d\u010f\u0005!\u0000\u0000\u010e\u010d\u0001\u0000\u0000\u0000\u010f"+
		"\u0110\u0001\u0000\u0000\u0000\u0110\u010e\u0001\u0000\u0000\u0000\u0110"+
		"\u0111\u0001\u0000\u0000\u0000\u0111\u011c\u0001\u0000\u0000\u0000\u0112"+
		"\u011c\u0003H$\u0000\u0113\u0115\u0005\u001f\u0000\u0000\u0114\u0116\u0003"+
		"@ \u0000\u0115\u0114\u0001\u0000\u0000\u0000\u0115\u0116\u0001\u0000\u0000"+
		"\u0000\u0116\u011c\u0001\u0000\u0000\u0000\u0117\u0118\u0005\u0011\u0000"+
		"\u0000\u0118\u0119\u00030\u0018\u0000\u0119\u011a\u0005\u0012\u0000\u0000"+
		"\u011a\u011c\u0001\u0000\u0000\u0000\u011b\u010a\u0001\u0000\u0000\u0000"+
		"\u011b\u010b\u0001\u0000\u0000\u0000\u011b\u010c\u0001\u0000\u0000\u0000"+
		"\u011b\u010e\u0001\u0000\u0000\u0000\u011b\u0112\u0001\u0000\u0000\u0000"+
		"\u011b\u0113\u0001\u0000\u0000\u0000\u011b\u0117\u0001\u0000\u0000\u0000"+
		"\u011cE\u0001\u0000\u0000\u0000\u011d\u011e\u0003H$\u0000\u011eG\u0001"+
		"\u0000\u0000\u0000\u011f\u0120\u0005\u0014\u0000\u0000\u0120\u0125\u0003"+
		"J%\u0000\u0121\u0122\u0005\u0006\u0000\u0000\u0122\u0124\u0003J%\u0000"+
		"\u0123\u0121\u0001\u0000\u0000\u0000\u0124\u0127\u0001\u0000\u0000\u0000"+
		"\u0125\u0123\u0001\u0000\u0000\u0000\u0125\u0126\u0001\u0000\u0000\u0000"+
		"\u0126\u0128\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000"+
		"\u0128\u0129\u0005\u0015\u0000\u0000\u0129I\u0001\u0000\u0000\u0000\u012a"+
		"\u012e\u0003H$\u0000\u012b\u012e\u00036\u001b\u0000\u012c\u012e\u0005"+
		"\u001a\u0000\u0000\u012d\u012a\u0001\u0000\u0000\u0000\u012d\u012b\u0001"+
		"\u0000\u0000\u0000\u012d\u012c\u0001\u0000\u0000\u0000\u012eK\u0001\u0000"+
		"\u0000\u0000\u001fN\\^jw\u0084\u008c\u0092\u0095\u009c\u009f\u00a8\u00b5"+
		"\u00b7\u00c6\u00cb\u00d0\u00d5\u00da\u00dd\u00e2\u00eb\u00ed\u00f9\u00fc"+
		"\u0107\u0110\u0115\u011b\u0125\u012d";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}