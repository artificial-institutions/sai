package sai.bridges.jacamo;

import cartago.AgentIdCredential;
import cartago.ArtifactId;
import cartago.CartagoContext;
import cartago.CartagoException;
import cartago.CartagoService;
import cartago.Op;
import cartago.OpFeedbackParam;
import cartago.WorkspaceId;
import jason.JasonException;
import jason.asSemantics.Message;
import jason.asSemantics.TransitionSystem;
import jason.asSemantics.Unifier;
import jason.asSyntax.Term;
import jason.asSyntax.Atom;
import jason.asSyntax.ListTerm;
import jason.asSyntax.StringTerm;

import jason.stdlib.send;

public class send_sai extends send {

	private static CartagoContext cartagoCtx = null;

	@Override
	public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {		
		ListTerm list = (ListTerm) args[args.length-1]; //get the list of institutions
		notifyInstitutions(args[0],args[1],args[2], list,ts.getUserAgArch().getAgName());
		Term[] argsSend = new Term[args.length-1];
		System.arraycopy(args, 0, argsSend, 0, args.length-1); ////remove the list of institutions from the arguments to send		
		return super.execute(ts, un, argsSend);
	}


	private void notifyInstitutions(Term target, Term performative, Term message, ListTerm institutions, String sender ) {
		for(Term inst : institutions) {
			if(cartagoCtx==null) {
			   cartagoCtx = new CartagoContext(new AgentIdCredential("JaCaMo_Inst_Launcher"), inst.toString());
			}
			try {
				WorkspaceId wspId = cartagoCtx.getJoinedWspId(inst.toString());
				ArtifactId artId = cartagoCtx.lookupArtifact(wspId, inst.toString()+ "_art");					
				// get listener object from SAI
				OpFeedbackParam<RuleEngine> obj = new OpFeedbackParam<RuleEngine>();
				cartagoCtx.doAction(artId, new Op("getRuleEngine", new Object[] { obj } ));				
				obj.get().processActionCompleted("send("+target+","+performative+","+message+")", sender);
			} catch (CartagoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/*private void notifyInstitutions(Term target, Term performative, Term message) {
		CartagoContext cartagoCtx;			
		cartagoCtx = new CartagoContext(new AgentIdCredential("JaCaMo_Inst_Launcher"), "inst_a");
		try {
			for(WorkspaceId wspId:cartagoCtx.getJoinedWorkspaces()) {
				ArtifactId artId = cartagoCtx.lookupArtifact(wspId, "inst_a_art");
				//ArtifactId artId = cartagoCtx.lookupArtifact(wspId, "xxxxxxxxxx");
				System.out.println("[send_sai] xxxxxxx");
				cartagoCtx.focus(artId);

				// get listener object from SAI
				OpFeedbackParam<RuleEngine> obj = new OpFeedbackParam<RuleEngine>();
				cartagoCtx.doAction(artId, new Op("getRuleEngine", new Object[] { obj } ));

				//obj.get().processActionCompleted("send(a,b)", "bob");
				obj.get().processActionCompleted("send("+target+","+performative+","+message+")", "bob");

			}
		} catch (CartagoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		 

	}*/

	/*public Object execute(TransitionSystem ts, Unifier un, Term[] args, ConstitutiveArt[] institutions) throws Exception {
		for(int i=0;i<institutions.length;i++) {
			System.out.println("[send_sai] " + institutions[i]);
		}

        return super.execute(ts, un, args);
    }*/

	private void delegateSendToArch(Term to, TransitionSystem ts, Message m) throws Exception {
		if (!to.isAtom() && !to.isString())
			throw new JasonException("The TO parameter ('"+to+"') of the internal action 'send' is not an atom!");

		String rec = null;
		if (to.isString())
			rec = ((StringTerm)to).getString();
		else if (to.isAtom())
			rec = ((Atom)to).getFunctor(); // remove annotations 
		else
			rec = to.toString();
		if (rec.equals("self"))
			rec = ts.getUserAgArch().getAgName();
		m.setReceiver(rec);
		ts.getUserAgArch().sendMsg(m);
	}
}
