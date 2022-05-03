package sai.main.lang.semantics.constitutiveRule;

import jason.asSyntax.LogicalFormula;
import jason.asSyntax.Pred;
import sai.main.lang.semantics.SaiElement;
import sai.main.lang.semantics.statusFunction.StatusFunction;

public class ConstitutiveRule extends SaiElement {

	Pred x = null;
	StatusFunction y = null;
	LogicalFormula t = null;
	LogicalFormula m = null;

	public ConstitutiveRule(Pred x, StatusFunction y, LogicalFormula t, LogicalFormula m){
		super();
		this.x = x;
		this.y = y;
		this.t = t;
		this.m = m;
	}

	public Pred getX() {
		return x;
	}

	public void setX(Pred x) {
		this.x = x;
	}

	public StatusFunction getY() {
		return y;
	}

	public void setY(StatusFunction y) {
		this.y = y;
	}

	public LogicalFormula getT() {
		return t;
	}

	public void setT(LogicalFormula t) {
		this.t = t;
	}

	public LogicalFormula getM() {
		return m;
	}

	public void setM(LogicalFormula m) {
		this.m = m;
	}

	@Override
	public String toString() {
		String s = "";
		if(getX()!=null)
			s = s.concat(getX().toString());
		if(getY()==null)
			s = s.concat(" count-as NULL ");
		else
		   s = s.concat(" count-as " + getY().toString());
		if(getT()!=null)
			s = s.concat(" when " + getT().toString());
		if(getM()!=null)
			s = s.concat(" while " + getM().toString());
		return  s;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((m == null) ? 0 : m.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		result = prime * result + ((y == null) ? 0 : y.hashCode());
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
		ConstitutiveRule other = (ConstitutiveRule) obj;
		if (m == null) {
			if (other.m != null)
				return false;
		} else if (!m.equals(other.m))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		if (y == null) {
			if (other.y != null)
				return false;
		} else if (!y.equals(other.y))
			return false;
		return true;
	}
	
	
}
