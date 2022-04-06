package sai.bridges.jacamo;

import java.util.HashMap;

import cartago.AgentIdCredential;
import cartago.CartagoEvent;
import cartago.CartagoException;
import cartago.ICartagoCallback;
import cartago.ICartagoContext;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.Workspace;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Term;
import jason.stdlib.broadcast;

public class broadcast_sai extends broadcast {


	private HashMap<Term, ICartagoContext> contexts = new HashMap<Term, ICartagoContext>();
	private HashMap<String, Workspace> workspaces = new HashMap<String, Workspace>();
	private cartago.CartagoEnvironment cenv = cartago.CartagoEnvironment.getInstance(); 
	private Workspace main = cenv.getRootWSP().getWorkspace();

	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
		ListTerm list = (ListTerm) args[2]; //get the list of institutions
		notifyInstitutions(args[0],args[1], list,ts.getUserAgArch().getAgName());
		Term[] argsSend = new Term[args.length-1];
		System.arraycopy(args, 0, argsSend, 0, args.length-1);
		return super.execute(ts, un, argsSend);
	}

	private void notifyInstitutions( Term performative, Term message, ListTerm institutions, String sender ) {
		for(Term inst : institutions) {
			if(workspaces.get(inst.toString())==null)
				workspaces.put(inst.toString(), main.getChildWSP(inst.toString()).get().getWorkspace());
			Workspace instWks = workspaces.get(inst.toString());
			if(contexts.get(inst)==null){				
				ICartagoContext context = null;
				try {
					context = instWks.joinWorkspace(new AgentIdCredential("JaCaMoLauncherAgOrg"), new ICartagoCallback() {
						public void notifyCartagoEvent(CartagoEvent a) {    }
					});
				} catch (CartagoException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				contexts.put(inst, context);
			}
			try {
				String artName = instWks.getId() + "_art";
				OpFeedbackParam<RuleEngine> obj = new OpFeedbackParam<RuleEngine>(); 
				contexts.get(inst).doAction(1, instWks.getArtifact(artName).getName(),new Op("getRuleEngine", new Object[] { obj } ), null,-1);
				int i=0;
	            while (obj.get() == null && i++ < 30) {Thread.sleep(50);}
				obj.get().processActionCompleted("broadcast("+performative+","+message+")", sender);

			} catch (CartagoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




}
