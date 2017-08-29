package sai.bridges.jacamo;
import static jason.asSyntax.ASSyntax.createAtom;
import static jason.asSyntax.ASSyntax.parseLiteral;
import jason.asSyntax.Atom;
import jason.asSyntax.Literal;
import jason.asSyntax.Pred;
import jason.asSyntax.Term;
import jason.asSyntax.parser.ParseException;

import java.util.ArrayList;
import java.util.List;

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
			engine.addEnvironmentalAgent(createAtom(req.getAgentId().toString()));
		}		
	}


	@Override
	protected void processActionCompleted(ActionSucceededEvent ev, AgentId agentId ){
		
		if(!toIgnoreArt(ev)){

			if(!ev.getOp().getName().equals("addNormativeProgram")&!ev.getOp().getName().equals("addConstitutiveProgram")&(!ev.getOp().getName().equals("println"))){
				String fact =  Op2Pred(ev.getOp());

				String agent;
				if(agentId.getAgentName().equals("workspace-manager"))
					agent =  "workspace";
				else{						
					agent = agentId.getAgentName();
				}

				//System.out.println("[RuleEngine] processing action completed: " + fact + " by " + agent);

				for(SaiEngine institution:institutions){
					try {
						institution.addEnvironmentalEvent(parseLiteral(fact), createAtom(agent));
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		}
	}



	private String Op2Pred(Op op){
		Object[] o = op.getParamValues();
		String term;

		String pred = op.getName();

		if(o.length > 0 ){ 
			pred = pred +"(";
			for(int i=0;i<o.length;i++){
				String current=o[i].toString();
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
		String prop = property.getName().replace("$", "S").replace("@","a").replace("-","_");
		prop = prop + "(" + artifactId.toString().replace("-","_");
		if(property.getValues().length>0){			
			for(int j=0;j<property.getValues().length;j++){
				prop = prop + "," + property.getValue(j).toString().replace("$", "S").replace("@","_at_").replace("-","_");					
			}
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
			prop = prop + ")";
		}		
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
                //System.out.println("[RuleEngine] property changed " + artifactId.toString() + ", " + property.toString());		
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
                //System.out.println("[RuleEngine] property added " + artifactId.toString() + ", " + property.toString());		
		if(!toIgnoreArt(artifactId)){
			for(int i=0;i<property.length;i++){
				for(SaiEngine engine:institutions){
					try {
						engine.addEnvironmentalProperty(parseLiteral(propertyToLiteral(artifactId, property[i])));						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						System.out.println("Problems adding property > " + propertyToLiteral(artifactId, property[i]));
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
					engine.addEnvironmentalEvent(p, (Atom) triggeringAgent);
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
	private boolean toIgnoreArt(ArtifactId artifactId){
		if(artifactId.getArtifactType().equals(" sai4jacamo.Sai4JacamoArt"))
			return true;
		return false;
	}



	/** Returns true when the events and properties from the artifact can be ignored (it is the case of artifacts from the very Sai4Jacamo)
	 * 
	 *
	 * @param artifactId
	 * @return
	 */
	private boolean toIgnoreArt(ActionSucceededEvent ev){
		if(ev.getArtifactId().getArtifactType().equals(" sai4jacamo.Sai4JacamoArt"))
			return true;
		return false;
	}
	
	
	//TODO: find a better way to do this
	public ArrayList<Literal> getCurrentEnvironmentalState(){
		ArrayList<Literal> result = new ArrayList<Literal>();
		for(SaiEngine i:institutions){
			result.addAll(i.getCurrentState());
		}
		return result;
	}

}
