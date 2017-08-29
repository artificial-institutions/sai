package sai.norms.sai.semantics;

public class Permission extends Deontic {
	@Override
	public String toString() {
		return "permitted";
	}
	
	@Override
	public boolean equals(Object obj) {		
		return obj instanceof Permission;
	}
}
