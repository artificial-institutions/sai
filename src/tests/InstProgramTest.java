package tests;

import static org.junit.Assert.*;
import jason.asSyntax.Pred;
import jason.asSyntax.parser.ParseException;
import sai.main.lang.semantics.InstProgram;
import sai.main.lang.semantics.statusFunction.EventStatusFunction;
import sai.main.lang.semantics.statusFunction.StateStatusFunction;
import static jason.asSyntax.ASSyntax.parseLiteral;

import org.junit.Test;

public class InstProgramTest {

	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program and, afger, it is searched.
	 */
	@Test
	public void testGetStatusFunctionByName_success_event_grounded() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral("myTest(x,y)"))));
			assertNotNull(program.getStatusFunctionByName("myTest(x,y)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	
	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program 
	 * and, after, a status function with a different argument it is searched. Must return null.
	 */
	@Test
	public void testGetStatusFunctionByName_fail_event_grounded() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral("myTest(x,y)"))));
			assertNull(program.getStatusFunctionByName("myTest(x,w)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

	
	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program and,
	 * after, a status function with variables in the arguments it is searched.
	 */
	@Test
	public void testGetStatusFunctionByName_success_event_with_var() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new EventStatusFunction(new Pred(parseLiteral("myTest(X,Y)"))));
			assertNotNull(program.getStatusFunctionByName("myTest(a,b)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	

	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program and, afger, it is searched.
	 */
	@Test
	public void testGetStatusFunctionByName_success_state_grounded() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("myTest(x,y)"))));
			assertNotNull(program.getStatusFunctionByName("myTest(x,y)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program 
	 * and, after, a status function with a different argument it is searched. Must return null.
	 */
	@Test
	public void testGetStatusFunctionByName_fail_state_grounded() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("myTest(x,y)"))));
			assertNull(program.getStatusFunctionByName("myTest(x,w)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
	
	
	/*
	 * Basic test for event status function: The status function, free of variables, is added to the program and,
	 * after, a status function with variables in the arguments it is searched.
	 */
	@Test
	public void testGetStatusFunctionByName_success_state_with_var() {
		InstProgram program = new InstProgram();
		try {
			program.addStatusFunction(new StateStatusFunction(new Pred(parseLiteral("myTest(X,Y)"))));
			assertNotNull(program.getStatusFunctionByName("myTest(a,b)"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}				
	}
	
	

}
