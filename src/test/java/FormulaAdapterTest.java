import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import jason.RevisionFailedException;
import jason.asSyntax.LogicalFormula;
import jason.asSyntax.parser.ParseException;
import static jason.asSyntax.ASSyntax.parseFormula;
import sai.main.lang.parser.FormulaAdapter;
import sai.util.reasoner.jason.JasonReasoner;

public class FormulaAdapterTest {

	@Test
	public void testAdaptContextSFA() {
		try {			
			JasonReasoner reasoner = new JasonReasoner();
			reasoner.assertValue("p");
			reasoner.assertValue("q");
			reasoner.assertValue("sai__is(x,y,z)");
			reasoner.assertValue("sai__is(a,b,c)");
			
					
			String sFormula = FormulaAdapter.adaptContextSFA("p&sai__is(x,y,v)&q&sai__is(a,b,w)");
			assertTrue(reasoner.check(sFormula));			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RevisionFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
