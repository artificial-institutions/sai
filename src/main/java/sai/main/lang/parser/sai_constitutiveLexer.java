// Generated from grammar/sai_constitutive.g by ANTLR 4.7

package sai.main.lang.parser;


import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sai_constitutiveLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "TK_OR", "TK_AND", "TK_REL_OP", "TK_IS", "STRING", 
		"NEGATION", "TK_NEG", "INTDIV", "INTMOD", "ATOM", "VAR", "DIGIT", "TERM_NULL", 
		"COMMENT_STAT", "WS"
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



	  


	public sai_constitutiveLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sai_constitutive.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 34:
			WS_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			skip();
			break;
		}
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u0127\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24"+
		"\3\24\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\30\5\30\u00cf\n\30\3\31\3\31\3\31"+
		"\3\32\3\32\3\32\3\32\6\32\u00d8\n\32\r\32\16\32\u00d9\5\32\u00dc\n\32"+
		"\3\32\3\32\3\32\3\32\6\32\u00e2\n\32\r\32\16\32\u00e3\5\32\u00e6\n\32"+
		"\7\32\u00e8\n\32\f\32\16\32\u00eb\13\32\3\32\3\32\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37"+
		"\7\37\u0101\n\37\f\37\16\37\u0104\13\37\3 \3 \3 \3 \7 \u010a\n \f \16"+
		" \u010d\13 \3!\3!\3\"\3\"\3#\3#\3#\3#\7#\u0117\n#\f#\16#\u011a\13#\3#"+
		"\3#\3#\3#\3#\3$\6$\u0122\n$\r$\16$\u0123\3$\3$\3\u0118\2%\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%\3\2\6\4\2\"\"\61\61\4\2C\\c|\5\2&&BBaa\5\2\f\f\17\17\"\"\2\u013c\2\3"+
		"\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2"+
		"\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31"+
		"\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2"+
		"\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2"+
		"\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2"+
		"\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\3"+
		"I\3\2\2\2\5X\3\2\2\2\7Z\3\2\2\2\t\\\3\2\2\2\13m\3\2\2\2\rt\3\2\2\2\17"+
		"v\3\2\2\2\21}\3\2\2\2\23\u0084\3\2\2\2\25\u0097\3\2\2\2\27\u00a0\3\2\2"+
		"\2\31\u00a5\3\2\2\2\33\u00ab\3\2\2\2\35\u00ad\3\2\2\2\37\u00af\3\2\2\2"+
		"!\u00b1\3\2\2\2#\u00b3\3\2\2\2%\u00b5\3\2\2\2\'\u00b7\3\2\2\2)\u00b9\3"+
		"\2\2\2+\u00bb\3\2\2\2-\u00bd\3\2\2\2/\u00ce\3\2\2\2\61\u00d0\3\2\2\2\63"+
		"\u00d3\3\2\2\2\65\u00ee\3\2\2\2\67\u00f2\3\2\2\29\u00f4\3\2\2\2;\u00f8"+
		"\3\2\2\2=\u00fc\3\2\2\2?\u0105\3\2\2\2A\u010e\3\2\2\2C\u0110\3\2\2\2E"+
		"\u0112\3\2\2\2G\u0121\3\2\2\2IJ\7k\2\2JK\7p\2\2KL\7u\2\2LM\7v\2\2MN\7"+
		"k\2\2NO\7v\2\2OP\7w\2\2PQ\7v\2\2QR\7k\2\2RS\7q\2\2ST\7p\2\2TU\7a\2\2U"+
		"V\7k\2\2VW\7f\2\2W\4\3\2\2\2XY\7<\2\2Y\6\3\2\2\2Z[\7\60\2\2[\b\3\2\2\2"+
		"\\]\7u\2\2]^\7v\2\2^_\7c\2\2_`\7v\2\2`a\7w\2\2ab\7u\2\2bc\7a\2\2cd\7h"+
		"\2\2de\7w\2\2ef\7p\2\2fg\7e\2\2gh\7v\2\2hi\7k\2\2ij\7q\2\2jk\7p\2\2kl"+
		"\7u\2\2l\n\3\2\2\2mn\7c\2\2no\7i\2\2op\7g\2\2pq\7p\2\2qr\7v\2\2rs\7u\2"+
		"\2s\f\3\2\2\2tu\7.\2\2u\16\3\2\2\2vw\7g\2\2wx\7x\2\2xy\7g\2\2yz\7p\2\2"+
		"z{\7v\2\2{|\7u\2\2|\20\3\2\2\2}~\7u\2\2~\177\7v\2\2\177\u0080\7c\2\2\u0080"+
		"\u0081\7v\2\2\u0081\u0082\7g\2\2\u0082\u0083\7u\2\2\u0083\22\3\2\2\2\u0084"+
		"\u0085\7e\2\2\u0085\u0086\7q\2\2\u0086\u0087\7p\2\2\u0087\u0088\7u\2\2"+
		"\u0088\u0089\7v\2\2\u0089\u008a\7k\2\2\u008a\u008b\7v\2\2\u008b\u008c"+
		"\7w\2\2\u008c\u008d\7v\2\2\u008d\u008e\7k\2\2\u008e\u008f\7x\2\2\u008f"+
		"\u0090\7g\2\2\u0090\u0091\7a\2\2\u0091\u0092\7t\2\2\u0092\u0093\7w\2\2"+
		"\u0093\u0094\7n\2\2\u0094\u0095\7g\2\2\u0095\u0096\7u\2\2\u0096\24\3\2"+
		"\2\2\u0097\u0098\7e\2\2\u0098\u0099\7q\2\2\u0099\u009a\7w\2\2\u009a\u009b"+
		"\7p\2\2\u009b\u009c\7v\2\2\u009c\u009d\7/\2\2\u009d\u009e\7c\2\2\u009e"+
		"\u009f\7u\2\2\u009f\26\3\2\2\2\u00a0\u00a1\7y\2\2\u00a1\u00a2\7j\2\2\u00a2"+
		"\u00a3\7g\2\2\u00a3\u00a4\7p\2\2\u00a4\30\3\2\2\2\u00a5\u00a6\7y\2\2\u00a6"+
		"\u00a7\7j\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2"+
		"\u00aa\32\3\2\2\2\u00ab\u00ac\7-\2\2\u00ac\34\3\2\2\2\u00ad\u00ae\7/\2"+
		"\2\u00ae\36\3\2\2\2\u00af\u00b0\7,\2\2\u00b0 \3\2\2\2\u00b1\u00b2\7\61"+
		"\2\2\u00b2\"\3\2\2\2\u00b3\u00b4\7*\2\2\u00b4$\3\2\2\2\u00b5\u00b6\7+"+
		"\2\2\u00b6&\3\2\2\2\u00b7\u00b8\7]\2\2\u00b8(\3\2\2\2\u00b9\u00ba\7_\2"+
		"\2\u00ba*\3\2\2\2\u00bb\u00bc\7~\2\2\u00bc,\3\2\2\2\u00bd\u00be\7(\2\2"+
		"\u00be.\3\2\2\2\u00bf\u00cf\7>\2\2\u00c0\u00c1\7>\2\2\u00c1\u00cf\7?\2"+
		"\2\u00c2\u00cf\7@\2\2\u00c3\u00c4\7@\2\2\u00c4\u00cf\7?\2\2\u00c5\u00c6"+
		"\7?\2\2\u00c6\u00cf\7?\2\2\u00c7\u00c8\7^\2\2\u00c8\u00c9\7?\2\2\u00c9"+
		"\u00cf\7?\2\2\u00ca\u00cf\7?\2\2\u00cb\u00cc\7?\2\2\u00cc\u00cd\7\60\2"+
		"\2\u00cd\u00cf\7\60\2\2\u00ce\u00bf\3\2\2\2\u00ce\u00c0\3\2\2\2\u00ce"+
		"\u00c2\3\2\2\2\u00ce\u00c3\3\2\2\2\u00ce\u00c5\3\2\2\2\u00ce\u00c7\3\2"+
		"\2\2\u00ce\u00ca\3\2\2\2\u00ce\u00cb\3\2\2\2\u00cf\60\3\2\2\2\u00d0\u00d1"+
		"\7k\2\2\u00d1\u00d2\7u\2\2\u00d2\62\3\2\2\2\u00d3\u00db\7$\2\2\u00d4\u00dc"+
		"\5=\37\2\u00d5\u00dc\5? \2\u00d6\u00d8\5A!\2\u00d7\u00d6\3\2\2\2\u00d8"+
		"\u00d9\3\2\2\2\u00d9\u00d7\3\2\2\2\u00d9\u00da\3\2\2\2\u00da\u00dc\3\2"+
		"\2\2\u00db\u00d4\3\2\2\2\u00db\u00d5\3\2\2\2\u00db\u00d7\3\2\2\2\u00dc"+
		"\u00e9\3\2\2\2\u00dd\u00e5\t\2\2\2\u00de\u00e6\5=\37\2\u00df\u00e6\5?"+
		" \2\u00e0\u00e2\5A!\2\u00e1\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1"+
		"\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00de\3\2\2\2\u00e5"+
		"\u00df\3\2\2\2\u00e5\u00e1\3\2\2\2\u00e6\u00e8\3\2\2\2\u00e7\u00dd\3\2"+
		"\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
		"\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\7$\2\2\u00ed\64\3\2\2\2"+
		"\u00ee\u00ef\7p\2\2\u00ef\u00f0\7q\2\2\u00f0\u00f1\7v\2\2\u00f1\66\3\2"+
		"\2\2\u00f2\u00f3\7\u0080\2\2\u00f38\3\2\2\2\u00f4\u00f5\7f\2\2\u00f5\u00f6"+
		"\7k\2\2\u00f6\u00f7\7x\2\2\u00f7:\3\2\2\2\u00f8\u00f9\7o\2\2\u00f9\u00fa"+
		"\7q\2\2\u00fa\u00fb\7f\2\2\u00fb<\3\2\2\2\u00fc\u0102\4c|\2\u00fd\u0101"+
		"\t\3\2\2\u00fe\u0101\5A!\2\u00ff\u0101\t\4\2\2\u0100\u00fd\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
		"\2\2\u0102\u0103\3\2\2\2\u0103>\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u010b"+
		"\4C\\\2\u0106\u010a\t\3\2\2\u0107\u010a\5A!\2\u0108\u010a\t\4\2\2\u0109"+
		"\u0106\3\2\2\2\u0109\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2"+
		"\2\2\u010b\u0109\3\2\2\2\u010b\u010c\3\2\2\2\u010c@\3\2\2\2\u010d\u010b"+
		"\3\2\2\2\u010e\u010f\4\62;\2\u010fB\3\2\2\2\u0110\u0111\7a\2\2\u0111D"+
		"\3\2\2\2\u0112\u0113\7\61\2\2\u0113\u0114\7,\2\2\u0114\u0118\3\2\2\2\u0115"+
		"\u0117\13\2\2\2\u0116\u0115\3\2\2\2\u0117\u011a\3\2\2\2\u0118\u0119\3"+
		"\2\2\2\u0118\u0116\3\2\2\2\u0119\u011b\3\2\2\2\u011a\u0118\3\2\2\2\u011b"+
		"\u011c\7,\2\2\u011c\u011d\7\61\2\2\u011d\u011e\3\2\2\2\u011e\u011f\b#"+
		"\2\2\u011fF\3\2\2\2\u0120\u0122\t\5\2\2\u0121\u0120\3\2\2\2\u0122\u0123"+
		"\3\2\2\2\u0123\u0121\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\3\2\2\2\u0125"+
		"\u0126\b$\3\2\u0126H\3\2\2\2\17\2\u00ce\u00d9\u00db\u00e3\u00e5\u00e9"+
		"\u0100\u0102\u0109\u010b\u0118\u0123\4\2\3\2\3$\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}