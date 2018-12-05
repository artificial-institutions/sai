package sai.bridges.jacamo;

import static jason.asSyntax.ASSyntax.parseFormula;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartago.CartagoException;
import cartago.INTERNAL_OPERATION;
import cartago.LINK;
import cartago.OPERATION;
import cartago.manual.syntax.Literal;
import jason.asSemantics.Unifier;
import jason.asSyntax.ASSyntax;
import jason.util.Config;
import npl.NPLInterpreter;
import npl.NormativeFailureException;
import ora4mas.nopl.NormativeBoard;
import ora4mas.nopl.WebInterface;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.norms.npl.nopl2sai.INormativeBoard2SaiListener;
import sai.norms.npl.nopl2sai.NOpl2Sai;
import sai.norms.npl.npl2sai.Npl2Sai;

public class NormativeBoardSai extends NormativeBoard {
	
	private Npl2Sai npl2sai;
	private SaiEngine institution;
	
	public void init() {
		super.init();
		this.npl2sai = new Npl2Sai(getNormativeEngine());
    }
	
    public INormativeEngine getNormEngine() {	
		return this.npl2sai;
	}	
	
    @LINK
	public void setInstitution(SaiEngine institution){
		this.institution = institution;
		institution.addNormativeEngine(this.npl2sai);		
	}

}
