package sai.norms.sai.semantics;

public class Obligation extends Deontic {

	@Override
	public String toString() {
		return "obliged";
	}

	@Override
	public boolean equals(Object obj) {		
		return obj instanceof Obligation;
	}

	
}
