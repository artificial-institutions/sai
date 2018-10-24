package sai.main.lang.semantics.statusFunction;

import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.Term;
import sai.main.lang.semantics.SaiElement;

/**
 * Implementing the Composite design pattern
 * @author maiquel
 *
 */

public abstract class StatusFunction extends SaiElement {
	
	private Literal id;
	
	@Override
	public abstract String toString();
	
	
	public Literal getId() {
		return id;
	}

	protected void setId(Literal id) {
		this.id = id;
	}
	
	
		
	@Override
	public int hashCode(){
		Pred newPred = new Pred(id.getFunctor());
		if (id.hasTerm()) {
			for(Term t:id.getTerms()){
				if(!t.isVar())
					newPred.addTerm(t);
			}
		}
		return newPred.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		return this.getId().equals(((StatusFunction)obj).getId());
	}

	
}
