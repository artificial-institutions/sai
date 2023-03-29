import static org.junit.Assert.*;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import static org.antlr.v4.runtime.CharStreams.fromString;

import org.junit.Test;

import jason.asSyntax.Pred;
import static jason.asSyntax.ASSyntax.parseLiteral;
import sai.main.institution.SaiEngine;
import sai.main.lang.parser.sai_constitutiveLexer;
import sai.main.lang.parser.sai_constitutiveListenerImpl;
import sai.main.lang.parser.sai_constitutiveParser;
import sai.main.lang.semantics.constitutiveRule.ConstitutiveRule;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;

public class sai_constitutiveParserTest {
    
    @Test
	public void test_AddArtifactToIgnore() {

        //CharStream inputStream = fromString("10: count-as done(redditsch,retrieve_post,A) when retrieve(\"funny\",\"2471115951123-dhoucPCzIMB4X-KShg_lwhL0snmC9A\")[sai__agent(A)].")
		//sai_constitutiveLexer constLexer = new sai_constitutiveLexer(inputStream);        
        sai_constitutiveLexer constLexer = new sai_constitutiveLexer(fromString("10: count-as done(redditsch,retrieve_post,A) when retrieve(\"funny\",\"2471115951123-dhoucPCzIMB4X-KShg_lwhL0snmC9A\")[sai__agent(A)]."));        
        //sai_constitutiveLexer constLexer = new sai_constitutiveLexer(fromString("10: count-as done(redditsch,retrieve_post,A) when retrieve(funny,z)[sai__agent(A)]."));        
        CommonTokenStream tokens = new CommonTokenStream(constLexer);
        sai_constitutiveParser constParser = new sai_constitutiveParser(tokens);
        ParseTree tree = constParser.const_rule();
        ParseTreeWalker walker = new ParseTreeWalker(); // create standard walker
        SaiEngine sai = new SaiEngine();
        try {
            sai.getProgram().addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("done(redditsch,retrieve_post,A)"))));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        sai_constitutiveListenerImpl constExtractor = new sai_constitutiveListenerImpl(sai.getProgram());
        walker.walk(constExtractor, tree); // initiate walk of tree with listener
        assertEquals(sai.getProgram().getConstitutiveRules().get(0).toString(), "sai__freestandingY count-as done(redditsch,retrieve_post,A) when retrieve(\"funny\",\"2471115951123-dhoucPCzIMB4X-KShg_lwhL0snmC9A\")[sai__agent(A)] while true");        
	}


}
