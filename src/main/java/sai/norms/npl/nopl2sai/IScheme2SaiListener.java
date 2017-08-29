package sai.norms.npl.nopl2sai;

import sai.main.institution.INormativeEngine;

/**
 * All the classes that want to be a listener for the institutional facts related to schemes must implement this interface 
 * @author maiquel
 *
 */

public interface IScheme2SaiListener{
	
	public void sai_goalAchieved(String agent, String goal);
	public void sai_committed(String agent, String mission, String scheme);
	public INormativeEngine getNormEngine();
}
