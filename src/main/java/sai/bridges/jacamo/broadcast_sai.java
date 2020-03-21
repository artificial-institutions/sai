package sai.bridges.jacamo;

import cartago.AgentIdCredential;
import cartago.ArtifactId;
import cartago.CartagoContext;
import cartago.CartagoException;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.WorkspaceId;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.ListTerm;
import jason.asSyntax.Term;
import jason.stdlib.broadcast;

public class broadcast_sai extends broadcast {
	
	
	private static CartagoContext cartagoCtx = null;
	

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
			if(cartagoCtx==null) {
			   cartagoCtx = new CartagoContext(new AgentIdCredential("JaCaMo_Inst_Launcher"+inst.toString()), inst.toString());
			}
			try {
					
					WorkspaceId wspId = cartagoCtx.getJoinedWspId(inst.toString()); 	
					ArtifactId artId = cartagoCtx.lookupArtifact(wspId, inst.toString()+ "_art");		//aqui esta o problema de não dar dois broadcast
					// get listener object from SAI
					OpFeedbackParam<RuleEngine> obj = new OpFeedbackParam<RuleEngine>();
					cartagoCtx.doAction(artId, new Op("getRuleEngine", new Object[] { obj } ));

					obj.get().processActionCompleted("broadcast("+performative+","+message+")", sender);
					System.out.println("[sai.bridges.jacamo.broadcast_sai] " + "broadcast("+performative+","+message+")" + sender);
							
			} catch (CartagoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	


}
