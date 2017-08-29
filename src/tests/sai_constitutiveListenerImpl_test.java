package tests;

import sai.main.exception.SaiException;
import sai.main.lang.parser.sai_constitutiveLexer;
import sai.main.lang.parser.sai_constitutiveListenerImpl;
import sai.main.lang.parser.sai_constitutiveParser;
import sai.main.lang.semantics.InstProgram;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

public class sai_constitutiveListenerImpl_test {

	@Test(expected = SaiException.class)
	public void testSai_constitutiveListenerImpl() {
		String program = "institution_id: teste. " +
						"constitutive_rules: " +
						"1: x count-as y when t while m." ;
		System.out.println(program);
		ANTLRInputStream is = new ANTLRInputStream(program);
		sai_constitutiveLexer lexer = new sai_constitutiveLexer(is);
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		sai_constitutiveParser parser = new sai_constitutiveParser(tokens);
		ParseTree tree = parser.constitutive_spec();
		ParseTreeWalker walker = new ParseTreeWalker();
		InstProgram instProgram = new InstProgram();
		sai_constitutiveListenerImpl listener = new sai_constitutiveListenerImpl(instProgram);
		walker.walk(listener, tree);
		
		
	}

}
