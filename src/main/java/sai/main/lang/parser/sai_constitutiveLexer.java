// Generated from sai_constitutive.g by ANTLR 4.7.2

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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
			"T__17", "T__18", "T__19", "T__20", "TK_OR", "TK_AND", "TK_REL_OP", "TK_IS", 
			"STRING", "NEGATION", "TK_NEG", "INTDIV", "INTMOD", "ATOM", "VAR", "DIGIT", 
			"TERM_NULL", "SPECIAL_CHAR_TERM", "COMMENT_STAT", "WS"
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

	@Override
	public String[] getChannelNames() { return channelNames; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0132\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\26\3"+
		"\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\5\31\u00dc\n\31\3\32\3\32\3\32\3\33\3\33"+
		"\3\33\3\33\3\33\6\33\u00e6\n\33\r\33\16\33\u00e7\3\33\3\33\3\33\3\33\3"+
		"\33\5\33\u00ef\n\33\7\33\u00f1\n\33\f\33\16\33\u00f4\13\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \7 \u010a\n \f \16 \u010d\13 \3!\3!\3!\3!\7!\u0113\n!\f!\16"+
		"!\u0116\13!\3\"\3\"\3#\3#\3$\3$\3%\3%\3%\3%\7%\u0122\n%\f%\16%\u0125\13"+
		"%\3%\3%\3%\3%\3%\3&\6&\u012d\n&\r&\16&\u012e\3&\3&\3\u0123\2\'\3\3\5\4"+
		"\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22"+
		"#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C"+
		"#E$G%I&K\'\3\2\7\4\2\"\"\61\61\4\2C\\c|\5\2&&BBaa\b\2##%%\'(,-//BB\5\2"+
		"\f\f\17\17\"\"\2\u0148\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5\\\3\2\2\2"+
		"\7^\3\2\2\2\t`\3\2\2\2\13q\3\2\2\2\rx\3\2\2\2\17z\3\2\2\2\21\u0081\3\2"+
		"\2\2\23\u0088\3\2\2\2\25\u009b\3\2\2\2\27\u00a4\3\2\2\2\31\u00a9\3\2\2"+
		"\2\33\u00af\3\2\2\2\35\u00b1\3\2\2\2\37\u00b3\3\2\2\2!\u00b5\3\2\2\2#"+
		"\u00b7\3\2\2\2%\u00b9\3\2\2\2\'\u00bb\3\2\2\2)\u00c4\3\2\2\2+\u00c6\3"+
		"\2\2\2-\u00c8\3\2\2\2/\u00ca\3\2\2\2\61\u00db\3\2\2\2\63\u00dd\3\2\2\2"+
		"\65\u00e0\3\2\2\2\67\u00f7\3\2\2\29\u00fb\3\2\2\2;\u00fd\3\2\2\2=\u0101"+
		"\3\2\2\2?\u0105\3\2\2\2A\u010e\3\2\2\2C\u0117\3\2\2\2E\u0119\3\2\2\2G"+
		"\u011b\3\2\2\2I\u011d\3\2\2\2K\u012c\3\2\2\2MN\7k\2\2NO\7p\2\2OP\7u\2"+
		"\2PQ\7v\2\2QR\7k\2\2RS\7v\2\2ST\7w\2\2TU\7v\2\2UV\7k\2\2VW\7q\2\2WX\7"+
		"p\2\2XY\7a\2\2YZ\7k\2\2Z[\7f\2\2[\4\3\2\2\2\\]\7<\2\2]\6\3\2\2\2^_\7\60"+
		"\2\2_\b\3\2\2\2`a\7u\2\2ab\7v\2\2bc\7c\2\2cd\7v\2\2de\7w\2\2ef\7u\2\2"+
		"fg\7a\2\2gh\7h\2\2hi\7w\2\2ij\7p\2\2jk\7e\2\2kl\7v\2\2lm\7k\2\2mn\7q\2"+
		"\2no\7p\2\2op\7u\2\2p\n\3\2\2\2qr\7c\2\2rs\7i\2\2st\7g\2\2tu\7p\2\2uv"+
		"\7v\2\2vw\7u\2\2w\f\3\2\2\2xy\7.\2\2y\16\3\2\2\2z{\7g\2\2{|\7x\2\2|}\7"+
		"g\2\2}~\7p\2\2~\177\7v\2\2\177\u0080\7u\2\2\u0080\20\3\2\2\2\u0081\u0082"+
		"\7u\2\2\u0082\u0083\7v\2\2\u0083\u0084\7c\2\2\u0084\u0085\7v\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0087\7u\2\2\u0087\22\3\2\2\2\u0088\u0089\7e\2\2\u0089"+
		"\u008a\7q\2\2\u008a\u008b\7p\2\2\u008b\u008c\7u\2\2\u008c\u008d\7v\2\2"+
		"\u008d\u008e\7k\2\2\u008e\u008f\7v\2\2\u008f\u0090\7w\2\2\u0090\u0091"+
		"\7v\2\2\u0091\u0092\7k\2\2\u0092\u0093\7x\2\2\u0093\u0094\7g\2\2\u0094"+
		"\u0095\7a\2\2\u0095\u0096\7t\2\2\u0096\u0097\7w\2\2\u0097\u0098\7n\2\2"+
		"\u0098\u0099\7g\2\2\u0099\u009a\7u\2\2\u009a\24\3\2\2\2\u009b\u009c\7"+
		"e\2\2\u009c\u009d\7q\2\2\u009d\u009e\7w\2\2\u009e\u009f\7p\2\2\u009f\u00a0"+
		"\7v\2\2\u00a0\u00a1\7/\2\2\u00a1\u00a2\7c\2\2\u00a2\u00a3\7u\2\2\u00a3"+
		"\26\3\2\2\2\u00a4\u00a5\7y\2\2\u00a5\u00a6\7j\2\2\u00a6\u00a7\7g\2\2\u00a7"+
		"\u00a8\7p\2\2\u00a8\30\3\2\2\2\u00a9\u00aa\7y\2\2\u00aa\u00ab\7j\2\2\u00ab"+
		"\u00ac\7k\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7g\2\2\u00ae\32\3\2\2\2\u00af"+
		"\u00b0\7-\2\2\u00b0\34\3\2\2\2\u00b1\u00b2\7/\2\2\u00b2\36\3\2\2\2\u00b3"+
		"\u00b4\7,\2\2\u00b4 \3\2\2\2\u00b5\u00b6\7\61\2\2\u00b6\"\3\2\2\2\u00b7"+
		"\u00b8\7*\2\2\u00b8$\3\2\2\2\u00b9\u00ba\7+\2\2\u00ba&\3\2\2\2\u00bb\u00bc"+
		"\7u\2\2\u00bc\u00bd\7c\2\2\u00bd\u00be\7k\2\2\u00be\u00bf\7a\2\2\u00bf"+
		"\u00c0\7a\2\2\u00c0\u00c1\7k\2\2\u00c1\u00c2\7u\2\2\u00c2\u00c3\7*\2\2"+
		"\u00c3(\3\2\2\2\u00c4\u00c5\7]\2\2\u00c5*\3\2\2\2\u00c6\u00c7\7_\2\2\u00c7"+
		",\3\2\2\2\u00c8\u00c9\7~\2\2\u00c9.\3\2\2\2\u00ca\u00cb\7(\2\2\u00cb\60"+
		"\3\2\2\2\u00cc\u00dc\7>\2\2\u00cd\u00ce\7>\2\2\u00ce\u00dc\7?\2\2\u00cf"+
		"\u00dc\7@\2\2\u00d0\u00d1\7@\2\2\u00d1\u00dc\7?\2\2\u00d2\u00d3\7?\2\2"+
		"\u00d3\u00dc\7?\2\2\u00d4\u00d5\7^\2\2\u00d5\u00d6\7?\2\2\u00d6\u00dc"+
		"\7?\2\2\u00d7\u00dc\7?\2\2\u00d8\u00d9\7?\2\2\u00d9\u00da\7\60\2\2\u00da"+
		"\u00dc\7\60\2\2\u00db\u00cc\3\2\2\2\u00db\u00cd\3\2\2\2\u00db\u00cf\3"+
		"\2\2\2\u00db\u00d0\3\2\2\2\u00db\u00d2\3\2\2\2\u00db\u00d4\3\2\2\2\u00db"+
		"\u00d7\3\2\2\2\u00db\u00d8\3\2\2\2\u00dc\62\3\2\2\2\u00dd\u00de\7k\2\2"+
		"\u00de\u00df\7u\2\2\u00df\64\3\2\2\2\u00e0\u00e5\7$\2\2\u00e1\u00e6\5"+
		"? \2\u00e2\u00e6\5A!\2\u00e3\u00e6\5C\"\2\u00e4\u00e6\5G$\2\u00e5\u00e1"+
		"\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e5\u00e4\3\2\2\2\u00e6"+
		"\u00e7\3\2\2\2\u00e7\u00e5\3\2\2\2\u00e7\u00e8\3\2\2\2\u00e8\u00f2\3\2"+
		"\2\2\u00e9\u00ee\t\2\2\2\u00ea\u00ef\5? \2\u00eb\u00ef\5A!\2\u00ec\u00ef"+
		"\5C\"\2\u00ed\u00ef\5G$\2\u00ee\u00ea\3\2\2\2\u00ee\u00eb\3\2\2\2\u00ee"+
		"\u00ec\3\2\2\2\u00ee\u00ed\3\2\2\2\u00ef\u00f1\3\2\2\2\u00f0\u00e9\3\2"+
		"\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\u00f5\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\7$\2\2\u00f6\66\3\2\2\2"+
		"\u00f7\u00f8\7p\2\2\u00f8\u00f9\7q\2\2\u00f9\u00fa\7v\2\2\u00fa8\3\2\2"+
		"\2\u00fb\u00fc\7\u0080\2\2\u00fc:\3\2\2\2\u00fd\u00fe\7f\2\2\u00fe\u00ff"+
		"\7k\2\2\u00ff\u0100\7x\2\2\u0100<\3\2\2\2\u0101\u0102\7o\2\2\u0102\u0103"+
		"\7q\2\2\u0103\u0104\7f\2\2\u0104>\3\2\2\2\u0105\u010b\4c|\2\u0106\u010a"+
		"\t\3\2\2\u0107\u010a\5C\"\2\u0108\u010a\t\4\2\2\u0109\u0106\3\2\2\2\u0109"+
		"\u0107\3\2\2\2\u0109\u0108\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c@\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u0114"+
		"\4C\\\2\u010f\u0113\t\3\2\2\u0110\u0113\5C\"\2\u0111\u0113\t\4\2\2\u0112"+
		"\u010f\3\2\2\2\u0112\u0110\3\2\2\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2"+
		"\2\2\u0114\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115B\3\2\2\2\u0116\u0114"+
		"\3\2\2\2\u0117\u0118\4\62;\2\u0118D\3\2\2\2\u0119\u011a\7a\2\2\u011aF"+
		"\3\2\2\2\u011b\u011c\t\5\2\2\u011cH\3\2\2\2\u011d\u011e\7\61\2\2\u011e"+
		"\u011f\7,\2\2\u011f\u0123\3\2\2\2\u0120\u0122\13\2\2\2\u0121\u0120\3\2"+
		"\2\2\u0122\u0125\3\2\2\2\u0123\u0124\3\2\2\2\u0123\u0121\3\2\2\2\u0124"+
		"\u0126\3\2\2\2\u0125\u0123\3\2\2\2\u0126\u0127\7,\2\2\u0127\u0128\7\61"+
		"\2\2\u0128\u0129\3\2\2\2\u0129\u012a\b%\2\2\u012aJ\3\2\2\2\u012b\u012d"+
		"\t\6\2\2\u012c\u012b\3\2\2\2\u012d\u012e\3\2\2\2\u012e\u012c\3\2\2\2\u012e"+
		"\u012f\3\2\2\2\u012f\u0130\3\2\2\2\u0130\u0131\b&\3\2\u0131L\3\2\2\2\16"+
		"\2\u00db\u00e5\u00e7\u00ee\u00f2\u0109\u010b\u0112\u0114\u0123\u012e\4"+
		"\2\3\2\3&\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}