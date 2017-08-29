package sai.norms.npl.npl2sai;

import java.util.List;

import jason.asSyntax.Literal;

public interface INpl2SaiListener {
	
	public void processNormativeStateUpdated(List<Literal>activeObligations,List<Literal>fulfilledObligations);	

}
