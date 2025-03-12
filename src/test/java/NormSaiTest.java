import static jason.asSyntax.ASSyntax.parseFormula;
import static jason.asSyntax.ASSyntax.parseLiteral;
import static org.junit.Assert.*;

import org.junit.Test;

import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import jason.asSyntax.parser.TokenMgrError;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import sai.norms.npl.npl2sai.NormSai;

public class NormSaiTest {

	/***
	 * Test whether norms are properly created
	 */
	@Test
	public void testNormSai() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred( parseLiteral("play(X,Y)"))));
			program.addStatusFunction(new StateStatusFunction(new Pred( parseLiteral("obligation(A,N, G,D)"))));
			program.addStatusFunction(new EventStatusFunction(new Pred( parseLiteral("finish_session(S)"))));
			
			NormSai n1 = new NormSai("n1", parseLiteral(" obligation(A,n1, session_finished(1), now)"), parseFormula("play(A,clock_manager)"), program);
			assertEquals(n1.toString(), "norm n1: play(A,clock_manager) -> obligation(A,n1,session_finished(1),now)");			
			
			NormSai n2 = new NormSai("n2", parseLiteral(" obligation(A,n1, finish_session(1), now)"), parseFormula("play(A,clock_manager)"), program);								
			assertEquals(n2.toString(), "norm n2: play(A,clock_manager) -> obligation(A,n1,sai__event(finish_session(1)[sai__agent(Sai__Agent)]),now)");
			
			NormSai n3 = new NormSai("n3", parseLiteral(" obligation(A,n1, finish_session(1), now)"), parseFormula("play(A,clock_manager)&finish_session(S)|a(b,c)"), program);
			assertEquals(n3.toString(), "norm n3: ((play(A,clock_manager) & sai__event(finish_session(S)[sai__agent(Sai__Agent)])) | a(b,c)) -> obligation(A,n1,sai__event(finish_session(1)[sai__agent(Sai__Agent)]),now)");
						
			NormSai n4 = new NormSai("n4", parseLiteral("obligation(A,not (well_formed(S)),committed(A,management_of_house_building,S),now)"), parseFormula("a(b,c)& not (mission_accomplished(S,management_of_house_building))"), program);
			assertEquals(n4.toString(), "norm n4: (a(b,c) & not (mission_accomplished(S,management_of_house_building))) -> obligation(A,not (well_formed(S)),committed(A,management_of_house_building,S),now)");
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
