package sai.bridges.jacamo;
import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.Term;
import jason.asSyntax.parser.ParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDateTime.now;

import sai.main.institution.SaiEngine;
import cartago.AbstractWSPRuleEngine;
import cartago.AgentId;
import cartago.AgentJoinRequestInfo;
import cartago.ArtifactId;
import cartago.ArtifactObsProperty;
import cartago.Op;
import cartago.Tuple;
import cartago.events.ActionSucceededEvent;


/**
 * This class is an interface between CArtAgO and and the Count-as Engine.
 * It is responsible to start an instance of Count-As-Engine.
 * The information about events and observable properties from CArtAgO 
 * are received by the RuleEngine that send that to the Count-as Engine.
 * The result of interpretation of the count-as rules is applied by the 
 * RuleEngine on the CArtAgO artifacts.
 * 
 */
public class RuleEngine extends AbstractWSPRuleEngine { 

	List<SaiEngine> institutions = new ArrayList<SaiEngine>();
	private HashMap<String, String> toIgnoreArt = new HashMap<String, String>(); //a list of the names of artifacts to be ignored 
	private static final HashMap<String, String> JACAMO_PROPERTIES = new HashMap<String, String>(){{ put("focusing","focusing");
																					                 put("joinedWsp","joinedWsp");	}}; //a list of obs.properties related to jacamo machinery - may require some special handling



	public RuleEngine() {
		super();
	}



	/**
	 * Add the "institutions" (represented by the SaiEngines) that are based on the environment managed by this RuleEngine 
	 * @param institution
	 */
	public void addInstitution(SaiEngine institution){
		this.institutions.add(institution);
	}





	@Override
	protected void processAgentJoinRequest(AgentJoinRequestInfo req){
		for(SaiEngine engine:institutions){
			engine.addEnvironmentalAgent(createAtom(adaptAgentId(req.getAgentId().getAgentName())));
		}
	}


	@Override
	public void processActionCompleted(ActionSucceededEvent ev, AgentId agentId ){

		if(!toIgnoreArt(ev)){

			if(!ev.getOp().getName().equals("addNormativeProgram")&!ev.getOp().getName().equals("addConstitutiveProgram")&(!ev.getOp().getName().equals("println"))){
				String fact =  Op2Pred(ev.getOp());

				String agent;
				if(agentId.getAgentName().equals("workspace-manager"))
					agent =  "workspace";
				else{						
					agent = adaptAgentId(agentId.getAgentName());
				}

				for(SaiEngine institution:institutions){
					try {
						institution.addEnvironmentalEvent(parseLiteral(fact), createAtom(agent), now());
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}

	protected void processActionCompleted(String fact, String agentId ){


		String agent;
		if(agentId.equals("workspace-manager"))
			agent =  "workspace";
		else{						
			agent = adaptAgentId(agentId);
		}


		for(SaiEngine institution:institutions){
			try {
				institution.addEnvironmentalEvent(parseLiteral(fact), createAtom(agent), now());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * A naive attempt to check whether a string is a filename
	 * 
	 */
	private boolean isFileName(String fileName) {
		return fileName.indexOf('/')>0;
	}
	
	

	/**
	 * Adapt filenames since they cannot be coverted to literal
	 * 
	 */
	private String adaptFileName(String fileName) {
		return '"'+ fileName+'"';
	}
	
	
	private String Op2Pred(Op op){
		Object[] o = op.getParamValues();
		String term;

		String pred = op.getName();

		if(o.length > 0 ){ 
			pred = pred +"(";
			for(int i=0;i<o.length;i++){
				String current=o[i].toString();
				if(isFileName(current)) current = adaptFileName(current);
				if (current.indexOf('@') >= 0){
					term = "_";}
				else {
					term = adaptTerm(current);
				}	 
				pred = pred + term;
				if(i<(o.length-1))
					pred = pred + ",";
				else
					pred = pred + ")";
			}
		}
		return pred;
	}


	/*
	private Literal Op2Literal(Op op){
		Object[] o = op.getParamValues();
		Term term;


		Literal lit = createLiteral(op.getName());



		if(o.length > 0 ){ 
			for(int i=0;i<o.length;i++){
				String current=o[i].toString();
				if (current.indexOf('@') >= 0){
					term = new Atom("_");}
				else {
					term = adaptTerm(current);}
				lit.addTerm(term);
			}
		}
		return lit;
	}

	 */

	/*Maiquel*/    

	private String propertyToPred(ArtifactId artifactId, ArtifactObsProperty property){
		return propertyToPred(artifactId.getName(), property.getName(), property.getValues());
	}


	public String propertyToPred(String artifactId, String propertyName, Object[] propertyValues){
		if(isJacamoProperty(propertyName)) return jacamoPropertyToPred(artifactId, propertyName, propertyValues);			
		String prop = propertyName.replace("$", "S").replace("@","a").replace("-","_");
		prop = prop + "(" + artifactId.toString().replace("-","_");
		if(propertyValues.length>0){			
			for(int j=0;j<propertyValues.length;j++){				
				prop = prop + "," + propertyValues[j].toString().replace("$", "S").replace("@","_at_").replace("-","_").replace("(\\r|\\n)", "").replace("(^[A-Z|_].*)","sai__term_$1");
				prop = prop.replaceAll("(^[A-Z|_].*)", "sai__term_$1"); //do not accept varables from the environment
				prop = prop.replaceAll("([\\(\\)]|,)(_|[A-Z])(.)","$1sai__term_$2$3"); //do not accept variables in nested terms				
			}
		}		
		prop = prop + ")";
		return prop;
	}

	private String jacamoPropertyToPred(String artifactId, String propertyName, Object[] propertyValues){
		String prop = "";
		if(propertyName.equals("focusing")){ //focusing: the last property value - workspace full name - requires a particular handling
			prop = "focusing(" + artifactId.toString().replace("-","_");			
			for(int j=0;j<propertyValues.length-1;j++){				
				prop = prop + "," + propertyValues[j].toString().replace("$", "S").replace("@","_at_").replace("-","_").replace("(\\r|\\n)", "").replace("(^[A-Z|_].*)","sai__term_$1");
				prop = prop.replaceAll("(^[A-Z|_].*)", "sai__term_$1"); //do not accept varables from the environment
				prop = prop.replaceAll("([\\(\\)]|,)(_|[A-Z])(.)","$1sai__term_$2$3"); //do not accept variables in nested terms				
			}
			prop = prop + ",\"" + propertyValues[propertyValues.length-1]+ "\""; 
			prop = prop + ")";
		}
		else
		if(propertyName.equals("joinedWsp")){ //joinedWsp: the last property value - workspace full name - requires a particular handling
			prop = "joinedWsp(" + artifactId.toString().replace("-","_");			
			for(int j=0;j<propertyValues.length-1;j++){				
				prop = prop + "," + propertyValues[j].toString().replace("$", "S").replace("@","_at_").replace("-","_").replace("(\\r|\\n)", "").replace("(^[A-Z|_].*)","sai__term_$1");
				prop = prop.replaceAll("(^[A-Z|_].*)", "sai__term_$1"); //do not accept varables from the environment
				prop = prop.replaceAll("([\\(\\)]|,)(_|[A-Z])(.)","$1sai__term_$2$3"); //do not accept variables in nested terms				
			}
			prop = prop + ",\"" + propertyValues[propertyValues.length-1]+ "\""; 
			prop = prop + ")";
		}
		
		return prop;
	}

	private String propertyRemoveArgs(ArtifactId artifactId, ArtifactObsProperty property){
		String prop = property.getName().replace("$", "S").replace("@","a");
		prop = prop + "(" + artifactId.toString();
		if(property.getValues().length>0){	
			for(int j=0;j<property.getValues().length;j++){
				prop = prop +  ",_";
				//if(j<property.getValues().length-1)
				//	prop = prop + ",";
				//else					
			}			
		}	
		prop = prop + ")";
		return prop;
	}

	private String propertyToLiteral(ArtifactId artifactId, ArtifactObsProperty property){
		return propertyToPred(artifactId, property);
	}

	private String adaptTerm(String term){
		return term.replace("$", "S").replace("@","_at_").replace("->", ",");

	}




	/**
	 * Process the change of an observable property <i>property</i> of an artifact identified 
	 * by <i>artifactId</i>. The property is updated in the representation of observable state
	 * of the Count-as Engine 
	 **/
	@Override
	protected void processObsPropertyChanged(ArtifactId artifactId, ArtifactObsProperty[] property){
		if(!toIgnoreArt(artifactId)){
			for(int i=0;i<property.length;i++){
				for(SaiEngine engine:institutions){
					try {
						//engine.removeEnvironmentalFact(propertyRemoveArgs(artifactId, property[i]));
						//engine.addEnvironmentalFact(propertyToLiteral(artifactId, property[i]));
						//engine.replaceEnvironmentalFact(propertyRemoveArgs(artifactId, property[i]), propertyToLiteral(artifactId, property[i]));
						engine.replaceEnvironmentalProperty(parseLiteral(propertyRemoveArgs(artifactId, property[i])), parseLiteral(propertyToLiteral(artifactId, property[i])));

						/*Pred toChange = new Pred("sai__change");
					toChange.addTerm(parseLiteral(propertyToLiteral(artifactId, property[i])));
					engine.addEnvironmentalFact(toChange);*/
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}				
				}
			}
		}
	}    


	@Override
	protected void processObsPropertyAdded(ArtifactId artifactId, ArtifactObsProperty[] property){		
		if(!toIgnoreArt(artifactId)){
			for(int i=0;i<property.length;i++){
				for(SaiEngine engine:institutions){
					try {
						engine.addEnvironmentalProperty(parseLiteral(propertyToLiteral(artifactId, property[i])));						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	@Override
	protected void processObsPropertyRemoved(ArtifactId artifactId, ArtifactObsProperty[] property){
		if(!toIgnoreArt(artifactId)){
			for(int i=0;i<property.length;i++){
				for(SaiEngine engine:institutions){
					try {
						engine.removeEnvironmentalProperty(parseLiteral(propertyRemoveArgs(artifactId, property[i])));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	public void executeOp(String artifactName, Op op){
		try {            
			execOp(this.getArtifact(artifactName), op );
			//}
		}catch(Exception e){
		}
	}

	/**
	 * Signals are seen as events but there is not an associated triggering agent. 
	 * The triggering agent must be properly handled in the SAI program when the designer knows 
	 * signature of the signal.
	 * 
	 * Important: It is assumed that a signal to be processed here has the form of a predicate
	 *            where the latest argument is the triggering agent. Signals with a different signature
	 *            must be checked in the artifacts.
	 *            Example: in the signal mySignal(arg1,arg2,arg3), it is assumed that arg3 is the agent.
	 */
	@Override
	protected void processSignal(Tuple signal) {
		try {
			Pred p = new Pred(parseLiteral(signal.toString()));
			//if(p.getTerms().size()>0){ //if the signal(taken as predicate) does not have terms, then it does not fit with the expected pattern
			if(p.getArity()>0){ //if the signal(taken as predicate) does not have terms, then it does not fit with the expected pattern
				//get the agent that triggers the signal
				Term triggeringAgent = p.getTerm(p.getTerms().size()-1);
				p.getTerms().remove(p.getTerms().size()-1);
				for(SaiEngine engine:institutions){									
					engine.addEnvironmentalEvent(p, createAtom(adaptAgentId(triggeringAgent.toString())), now());
				}
			}
		} catch (ParseException e1) {
		}		
	}






	/**
	 * Returns true when the events and properties from the artifact can be ignored (it is the case of artifacts from the very Sai4Jacamo)
	 * 
	 *
	 * @param artifactId
	 * @return
	 */
	protected boolean toIgnoreArt(ArtifactId artifactId){
		if(artifactId.getArtifactType().equals("sai4jacamo.Sai4JacamoArt")| 		
				artifactId.getName().matches("([A-Za-z0-9])*([0-9])+-body"))
			return true;
		return false;
	}



	/** Returns true when the events and properties from the artifact can be ignored (it is the case of artifacts from the very Sai4Jacamo)
	 * 
	 *
	 * @param artifactId
	 * @return
	 */
	public boolean toIgnoreArt(ActionSucceededEvent ev){
		if(ev.getArtifactId().getArtifactType().equals("sai4jacamo.Sai4JacamoArt")|
				ev.getArtifactId().getName().matches("([A-Za-z0-9])*([0-9])+-body")|
				toIgnoreArt.get(ev.getArtifactId().getName())!=null)
			return true;
		return false;
	}


	private String adaptAgentId(String agent) {
		if(agent.charAt(0)>='A' & agent.charAt(0)<='Z')
			return "agent_"+agent;
		return agent;
	}

	//TODO: find a better way to do this
	public ArrayList<Literal> getCurrentEnvironmentalState(){
		ArrayList<Literal> result = new ArrayList<Literal>();
		for(SaiEngine i:institutions){
			result.addAll(i.getCurrentState());
		}
		return result;
	}
	
	/**
	 * Add an artifact name to the list of ignored artifacts
	 * @param artifactName
	 */
	public void addArtifactToIgnore(String artifactName) {		
		toIgnoreArt.put(artifactName, artifactName);
	}
	
	/**
	 * Remove an artifact name from the list of ignored artifacts
	 * @param artifactName
	 */
	public void removeArtifactToIgnore(String artifactName) {
		toIgnoreArt.remove(artifactName);
	}
	
	
	/**
	 * Get the map of artfacts to be ignored
	 * @return
	 */
	public HashMap<String, String> getArtifactsToIgnore(){
		return this.toIgnoreArt;
	}


	private boolean isJacamoProperty(String propertyName) {
		return JACAMO_PROPERTIES.get(propertyName) != null;
	}

}
