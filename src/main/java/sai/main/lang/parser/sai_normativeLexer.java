// Generated from sai_normative.g by ANTLR 4.6

package sai.main.lang.parser;

import jason.asSyntax.Atom;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class sai_normativeLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "TK_OR", "TK_AND", "TK_REL_OP", 
		"TK_IS", "STRING", "NEGATION", "TK_NEG", "INTDIV", "INTMOD", "ATOM", "VAR", 
		"DIGIT", "TERM_NULL", "COMMENT_STAT", "WS"
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



	  


	public sai_normativeLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "sai_normative.g"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 36:
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\'\u0132\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3"+
		"\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\5\32\u00da\n\32\3\33\3\33\3\33\3\34\3\34"+
		"\3\34\3\34\6\34\u00e3\n\34\r\34\16\34\u00e4\5\34\u00e7\n\34\3\34\3\34"+
		"\3\34\3\34\6\34\u00ed\n\34\r\34\16\34\u00ee\5\34\u00f1\n\34\7\34\u00f3"+
		"\n\34\f\34\16\34\u00f6\13\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\7!\u010c\n!\f!\16!\u010f\13"+
		"!\3\"\3\"\3\"\3\"\7\"\u0115\n\"\f\"\16\"\u0118\13\"\3#\3#\3$\3$\3%\3%"+
		"\3%\3%\7%\u0122\n%\f%\16%\u0125\13%\3%\3%\3%\3%\3%\3&\6&\u012d\n&\r&\16"+
		"&\u012e\3&\3&\3\u0123\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'\3\2\6\4\2\"\"\61\61\4\2C"+
		"\\c|\5\2&&BBaa\5\2\f\f\17\17\"\"\u0147\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3"+
		"\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3"+
		"\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65"+
		"\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3"+
		"\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2"+
		"\2\5\\\3\2\2\2\7^\3\2\2\2\t`\3\2\2\2\13q\3\2\2\2\rx\3\2\2\2\17z\3\2\2"+
		"\2\21\u0081\3\2\2\2\23\u0088\3\2\2\2\25\u008e\3\2\2\2\27\u0094\3\2\2\2"+
		"\31\u0099\3\2\2\2\33\u00a1\3\2\2\2\35\u00ac\3\2\2\2\37\u00b6\3\2\2\2!"+
		"\u00b8\3\2\2\2#\u00ba\3\2\2\2%\u00bc\3\2\2\2\'\u00be\3\2\2\2)\u00c0\3"+
		"\2\2\2+\u00c2\3\2\2\2-\u00c4\3\2\2\2/\u00c6\3\2\2\2\61\u00c8\3\2\2\2\63"+
		"\u00d9\3\2\2\2\65\u00db\3\2\2\2\67\u00de\3\2\2\29\u00f9\3\2\2\2;\u00fd"+
		"\3\2\2\2=\u00ff\3\2\2\2?\u0103\3\2\2\2A\u0107\3\2\2\2C\u0110\3\2\2\2E"+
		"\u0119\3\2\2\2G\u011b\3\2\2\2I\u011d\3\2\2\2K\u012c\3\2\2\2MN\7k\2\2N"+
		"O\7p\2\2OP\7u\2\2PQ\7v\2\2QR\7k\2\2RS\7v\2\2ST\7w\2\2TU\7v\2\2UV\7k\2"+
		"\2VW\7q\2\2WX\7p\2\2XY\7a\2\2YZ\7k\2\2Z[\7f\2\2[\4\3\2\2\2\\]\7<\2\2]"+
		"\6\3\2\2\2^_\7\60\2\2_\b\3\2\2\2`a\7u\2\2ab\7v\2\2bc\7c\2\2cd\7v\2\2d"+
		"e\7w\2\2ef\7u\2\2fg\7a\2\2gh\7h\2\2hi\7w\2\2ij\7p\2\2jk\7e\2\2kl\7v\2"+
		"\2lm\7k\2\2mn\7q\2\2no\7p\2\2op\7u\2\2p\n\3\2\2\2qr\7c\2\2rs\7i\2\2st"+
		"\7g\2\2tu\7p\2\2uv\7v\2\2vw\7u\2\2w\f\3\2\2\2xy\7.\2\2y\16\3\2\2\2z{\7"+
		"g\2\2{|\7x\2\2|}\7g\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7u\2\2\u0080\20"+
		"\3\2\2\2\u0081\u0082\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7c\2\2\u0084"+
		"\u0085\7v\2\2\u0085\u0086\7g\2\2\u0086\u0087\7u\2\2\u0087\22\3\2\2\2\u0088"+
		"\u0089\7p\2\2\u0089\u008a\7q\2\2\u008a\u008b\7t\2\2\u008b\u008c\7o\2\2"+
		"\u008c\u008d\7u\2\2\u008d\24\3\2\2\2\u008e\u008f\7w\2\2\u008f\u0090\7"+
		"p\2\2\u0090\u0091\7v\2\2\u0091\u0092\7k\2\2\u0092\u0093\7n\2\2\u0093\26"+
		"\3\2\2\2\u0094\u0095\7g\2\2\u0095\u0096\7n\2\2\u0096\u0097\7u\2\2\u0097"+
		"\u0098\7g\2\2\u0098\30\3\2\2\2\u0099\u009a\7q\2\2\u009a\u009b\7d\2\2\u009b"+
		"\u009c\7n\2\2\u009c\u009d\7k\2\2\u009d\u009e\7i\2\2\u009e\u009f\7g\2\2"+
		"\u009f\u00a0\7f\2\2\u00a0\32\3\2\2\2\u00a1\u00a2\7r\2\2\u00a2\u00a3\7"+
		"t\2\2\u00a3\u00a4\7q\2\2\u00a4\u00a5\7j\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7"+
		"\7d\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7v\2\2\u00a9\u00aa\7g\2\2\u00aa"+
		"\u00ab\7f\2\2\u00ab\34\3\2\2\2\u00ac\u00ad\7r\2\2\u00ad\u00ae\7g\2\2\u00ae"+
		"\u00af\7t\2\2\u00af\u00b0\7o\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7v\2\2"+
		"\u00b2\u00b3\7v\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7f\2\2\u00b5\36\3\2"+
		"\2\2\u00b6\u00b7\7-\2\2\u00b7 \3\2\2\2\u00b8\u00b9\7/\2\2\u00b9\"\3\2"+
		"\2\2\u00ba\u00bb\7,\2\2\u00bb$\3\2\2\2\u00bc\u00bd\7\61\2\2\u00bd&\3\2"+
		"\2\2\u00be\u00bf\7*\2\2\u00bf(\3\2\2\2\u00c0\u00c1\7+\2\2\u00c1*\3\2\2"+
		"\2\u00c2\u00c3\7]\2\2\u00c3,\3\2\2\2\u00c4\u00c5\7_\2\2\u00c5.\3\2\2\2"+
		"\u00c6\u00c7\7~\2\2\u00c7\60\3\2\2\2\u00c8\u00c9\7(\2\2\u00c9\62\3\2\2"+
		"\2\u00ca\u00da\7>\2\2\u00cb\u00cc\7>\2\2\u00cc\u00da\7?\2\2\u00cd\u00da"+
		"\7@\2\2\u00ce\u00cf\7@\2\2\u00cf\u00da\7?\2\2\u00d0\u00d1\7?\2\2\u00d1"+
		"\u00da\7?\2\2\u00d2\u00d3\7^\2\2\u00d3\u00d4\7?\2\2\u00d4\u00da\7?\2\2"+
		"\u00d5\u00da\7?\2\2\u00d6\u00d7\7?\2\2\u00d7\u00d8\7\60\2\2\u00d8\u00da"+
		"\7\60\2\2\u00d9\u00ca\3\2\2\2\u00d9\u00cb\3\2\2\2\u00d9\u00cd\3\2\2\2"+
		"\u00d9\u00ce\3\2\2\2\u00d9\u00d0\3\2\2\2\u00d9\u00d2\3\2\2\2\u00d9\u00d5"+
		"\3\2\2\2\u00d9\u00d6\3\2\2\2\u00da\64\3\2\2\2\u00db\u00dc\7k\2\2\u00dc"+
		"\u00dd\7u\2\2\u00dd\66\3\2\2\2\u00de\u00e6\7$\2\2\u00df\u00e7\5A!\2\u00e0"+
		"\u00e7\5C\"\2\u00e1\u00e3\5E#\2\u00e2\u00e1\3\2\2\2\u00e3\u00e4\3\2\2"+
		"\2\u00e4\u00e2\3\2\2\2\u00e4\u00e5\3\2\2\2\u00e5\u00e7\3\2\2\2\u00e6\u00df"+
		"\3\2\2\2\u00e6\u00e0\3\2\2\2\u00e6\u00e2\3\2\2\2\u00e7\u00f4\3\2\2\2\u00e8"+
		"\u00f0\t\2\2\2\u00e9\u00f1\5A!\2\u00ea\u00f1\5C\"\2\u00eb\u00ed\5E#\2"+
		"\u00ec\u00eb\3\2\2\2\u00ed\u00ee\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ee\u00ef"+
		"\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e9\3\2\2\2\u00f0\u00ea\3\2\2\2\u00f0"+
		"\u00ec\3\2\2\2\u00f1\u00f3\3\2\2\2\u00f2\u00e8\3\2\2\2\u00f3\u00f6\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00f7\3\2\2\2\u00f6"+
		"\u00f4\3\2\2\2\u00f7\u00f8\7$\2\2\u00f88\3\2\2\2\u00f9\u00fa\7p\2\2\u00fa"+
		"\u00fb\7q\2\2\u00fb\u00fc\7v\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7\u0080\2"+
		"\2\u00fe<\3\2\2\2\u00ff\u0100\7f\2\2\u0100\u0101\7k\2\2\u0101\u0102\7"+
		"x\2\2\u0102>\3\2\2\2\u0103\u0104\7o\2\2\u0104\u0105\7q\2\2\u0105\u0106"+
		"\7f\2\2\u0106@\3\2\2\2\u0107\u010d\4c|\2\u0108\u010c\t\3\2\2\u0109\u010c"+
		"\5E#\2\u010a\u010c\t\4\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010eB\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0116\4C\\\2\u0111\u0115"+
		"\t\3\2\2\u0112\u0115\5E#\2\u0113\u0115\t\4\2\2\u0114\u0111\3\2\2\2\u0114"+
		"\u0112\3\2\2\2\u0114\u0113\3\2\2\2\u0115\u0118\3\2\2\2\u0116\u0114\3\2"+
		"\2\2\u0116\u0117\3\2\2\2\u0117D\3\2\2\2\u0118\u0116\3\2\2\2\u0119\u011a"+
		"\4\62;\2\u011aF\3\2\2\2\u011b\u011c\7a\2\2\u011cH\3\2\2\2\u011d\u011e"+
		"\7\61\2\2\u011e\u011f\7,\2\2\u011f\u0123\3\2\2\2\u0120\u0122\13\2\2\2"+
		"\u0121\u0120\3\2\2\2\u0122\u0125\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121"+
		"\3\2\2\2\u0124\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7,\2\2\u0127"+
		"\u0128\7\61\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b%\2\2\u012aJ\3\2\2\2"+
		"\u012b\u012d\t\5\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b&\3\2\u0131"+
		"L\3\2\2\2\17\2\u00d9\u00e4\u00e6\u00ee\u00f0\u00f4\u010b\u010d\u0114\u0116"+
		"\u0123\u012e\4\2\3\2\3&\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}