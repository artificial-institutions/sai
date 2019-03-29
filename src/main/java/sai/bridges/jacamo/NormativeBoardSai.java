package sai.bridges.jacamo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;


import cartago.LINK;
import cartago.OPERATION;
import moise.common.MoiseException;
import npl.INorm;
import npl.NormativeProgram;
import npl.parser.ParseException;
import npl.parser.nplp;
import ora4mas.nopl.NormativeBoard;
import sai.main.institution.INormativeEngine;
import sai.main.institution.SaiEngine;
import sai.norms.npl.npl2sai.NormSai;
import sai.norms.npl.npl2sai.Npl2Sai;

public class NormativeBoardSai extends NormativeBoard {
	
	private Npl2Sai npl2sai;
	private SaiEngine institution;
	
	
	public void init() {
		super.init();
		this.npl2sai = new Npl2Sai(getNormativeEngine());
    }
	

	
	@OPERATION @LINK public void load(String nplProgram) throws MoiseException, ParseException {
        NormativeProgram p = new NormativeProgram();

        File f = new File(nplProgram);
        try {
            if (f.exists()) {
                new nplp(new FileReader(nplProgram)).program(p, this);
            } else {
                new nplp(new StringReader(nplProgram)).program(p, this);
            }
        } catch (FileNotFoundException e) {
        } catch (ParseException e) {
            logger.warning("error parsing \n"+nplProgram);
            e.printStackTrace();
            throw e;
        }
        
        
        /* The following piece of code is introduced in this artifact to convert Npl norms in SAI compliant NPL Nomrs */
        Iterator<INorm> it = p.getRoot().getNorms().iterator(); //get the norms to be loaded in the NPL Interpreter
        List<String> toRemove = new ArrayList<String>();
        List<INorm> toAdd = new ArrayList<INorm>();
        int i=0;
        while(it.hasNext()) { // for each norm...
        	INorm n = it.next();
        	try {
        		//create a SAI compliant norm
				NormSai nSai = new NormSai("nSai" + ++i, n.getConsequence(), n.getCondition(), institution.getProgram());
				//remove the original norm from the NPL interpreter
				toRemove.add(n.getId());
				//replace the original norm by a SAI compliant one
				toAdd.add(nSai);
			} catch (jason.asSyntax.parser.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        
        
        for(String r:toRemove) {
        	p.getRoot().removeNorm(r);
        }
        
        for(INorm a:toAdd) {
        	p.getRoot().addNorm(a);
        }
        
        
        nengine.loadNP(p.getRoot());
        
        
        

        if (gui != null) {
            gui.setNormativeProgram(getNPLSrc());
        }
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
