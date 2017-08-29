package sai.util.reasoner.jason;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Term;

public abstract class LiteralDecorator extends Literal {

	protected Literal literal;
	

	@Override
	public Element getAsDOM(Document arg0) {	
		return literal.getAsDOM(arg0);
	}

	@Override
	public String getFunctor() {
		return literal.getFunctor();
	}
	
	@Override
	protected int calcHashCode() {
		return literal.hashCode();
	}

	@Override
	public Term clone() {
		return literal.clone();
	}

	@Override
	public String toString() {
		return literal.toString();
	}

	
	@Override
	public Literal cloneNS(Atom newnamespace) {
		return literal.cloneNS(newnamespace);
	}


	@Override
	public Atom getNS() {
		return literal.getNS();
	}

}
