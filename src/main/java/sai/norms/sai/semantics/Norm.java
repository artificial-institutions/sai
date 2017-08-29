package sai.norms.sai.semantics;

import jason.asSyntax.Atom;
import jason.asSyntax.LogicalFormula;
import sai.main.lang.semantics.SaiElement;
import sai.main.lang.semantics.statusFunction.IAchievableStatusFunction;


public class Norm extends SaiElement{

	private LogicalFormula condition;
	private Deontic deontic;
	private IAchievableStatusFunction aim;
	private Atom attribute;
	private LogicalFormula orElse;
	private LogicalFormula deadline;

	//TODO: insert deadline in the constructor, toString, hashCode, equals...;
	public Norm(LogicalFormula condition, Atom attribute,
			Deontic deontic, IAchievableStatusFunction aim, LogicalFormula orElse, LogicalFormula deadline) {
		if(condition==null){
			this.condition=null;
		}else
			this.condition = condition;
		this.attribute = attribute;
		this.deontic = deontic;
		this.aim = aim;
		if (orElse==null)
			this.orElse=null;
		else
			this.orElse = orElse;
		if (deadline==null)
			this.deadline=null;
		else
			this.deadline = deadline;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aim == null) ? 0 : aim.hashCode());
		result = prime * result
				+ ((attribute == null) ? 0 : attribute.hashCode());
		result = prime * result
				+ ((condition == null) ? 0 : condition.hashCode());
		result = prime * result + ((deontic == null) ? 0 : deontic.hashCode());
		result = prime * result + ((orElse == null) ? 0 : orElse.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Norm other = (Norm) obj;
		if (aim == null) {
			if (other.aim != null)
				return false;
		} else if (!aim.equals(other.aim))
			return false;
		if (attribute == null) {
			if (other.attribute != null)
				return false;
		} else if (!attribute.equals(other.attribute))
			return false;
		if (condition == null) {
			if (other.condition != null)
				return false;
		} else if (!condition.equals(other.condition))
			return false;
		if (deontic == null) {
			if (other.deontic != null)
				return false;
		} else if (!deontic.equals(other.deontic))
			return false;
		if (orElse == null) {
			if (other.orElse != null)
				return false;
		} else if (!orElse.equals(other.orElse))
			return false;
		if (deadline == null) {
			if (other.deadline!= null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		return true;
	}


	@Override
	public String toString() {
		String s = "";
		if(getMetadata().length()>0){
			s="/*".concat(getMetadata()).concat("*/").concat("\n");
		}

		s = s.concat("" + this.condition.toString() + ": " + this.attribute.toString()+ " is "+ this.deontic.toString() + " to " + this.aim.toString());	
		if(orElse!=null){
			s = s + " or-else " + orElse.toString();
		}
		if(deadline!=null){
			s = s + " deadline " + deadline.toString();
		}
		s = s + ".";
		return  s;
	}

	public LogicalFormula getCondition() {
		return condition;
	}

	public Atom getAttribute() {
		return attribute;
	}

	public Deontic getDeontic() {
		return deontic;
	}

	public IAchievableStatusFunction getAim() {
		return aim;
	}

	public LogicalFormula getOrElse() {
		return orElse;
	}



	public LogicalFormula getDeadline() {
		return deadline;
	}



	public void setDeadline(LogicalFormula deadline) {
		this.deadline = deadline;
	}

}
