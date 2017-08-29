package sai.norms.sai.semantics;

public class Prohibition extends Deontic {

	@Override
	public String toString() {
		return "prohibited";
	}
	
	@Override
	public boolean equals(Object obj) {		
		return obj instanceof Prohibition;
	}
	
}
