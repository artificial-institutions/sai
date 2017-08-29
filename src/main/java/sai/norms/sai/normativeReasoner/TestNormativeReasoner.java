package sai.norms.sai.normativeReasoner;

import sai.util.reasoner.jason.Console;






public class TestNormativeReasoner {

	public static void main(String[] args) {
		NormativeReasoner reasoner = new NormativeReasoner();
		Console console = new Console(reasoner);
		console.start();

	}

}
