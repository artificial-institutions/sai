package sai.norms.sai.semantics;

import jason.asSyntax.Atom;
import jason.asSyntax.LogicalFormula;
import sai.main.lang.semantics.statusFunction.IAchievableStatusFunction;

public class NormInstance {

	private Atom attribute;
	private Deontic deontic;
	private IAchievableStatusFunction aim;	
	private LogicalFormula deadline;


	public NormInstance(Atom attribute, Deontic deontic,
			IAchievableStatusFunction aim, 
			LogicalFormula deadline) {
		super();
		this.attribute = attribute;
		this.deontic = deontic;
		this.aim = aim;
		this.deadline = deadline;
	}

	public Atom getAttribute() {
		return attribute;
	}
	public void setAttribute(Atom attribute) {
		this.attribute = attribute;
	}
	public Deontic getDeontic() {
		return deontic;
	}
	public void setDeontic(Deontic deontic) {
		this.deontic = deontic;
	}
	public IAchievableStatusFunction getAim() {
		return aim;
	}

	public void setAim(IAchievableStatusFunction aim) {
		this.aim = aim;
	}

	public LogicalFormula getDeadline() {
		return deadline;
	}
	public void setDeadline(LogicalFormula deadline) {
		this.deadline = deadline;
	}

	@Override
	public String toString() {
		return deontic+"("+attribute+","+aim+","+deadline+")";
	}

	@Override
	public boolean equals(Object obj) {	
		if(obj!=null&		
				((NormInstance)obj).getAttribute().equals(this.getAttribute()) &
				((NormInstance)obj).getDeontic().equals(this.getDeontic()) &
				((NormInstance)obj).getAim().equals(this.getAim()) &
				((NormInstance)obj).getDeadline().equals(this.getDeadline()))
			return true;
		else
			return false;


	}






}
