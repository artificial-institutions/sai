!start.

+!start  //if the agent has not joined in the workspaces, the broadcast_sai does not work. TODO: check it.
   <- joinWorkspace("/main/inst_a",IA);
      lookupArtifact("inst_a_art",ArtSaiA); 
      focus(ArtSaiA);
      joinWorkspace("/main/inst_b",IB);
      lookupArtifact("inst_b_art",ArtSaiB); 
      focus(ArtSaiB).
      


//plan for obligations that can be fulfilled through broadcast
+obligation(bob,_,sai__event(Goal[sai__agent(Sai__Agent)]),_) : constitutive_rule(broadcast(Performative,Message),Goal,T,M)
   <- .print("I am obliged to produce an event that counts as ", Goal, ". I should produce ", "broascast(",Performative,",",Message,")");
      sai.bridges.jacamo.broadcast_sai(tell,raining,[inst_a,inst_b]);  
      .

//plan for obligations that can be fulfilled by sending a message
+obligation(bob,_,sai__event(Goal[sai__agent(Sai__Agent)]),_) : constitutive_rule(send(X,Y,Z),Goal,T,M)
   <- .print("I am obliged to produce an event that counts as ", Goal, ". I should produce ", "send(",X,",",Y,",",Z,")");
      sai.bridges.jacamo.send_sai(X,Y,Z,[inst_a,inst_b]);
      .
   
+obligation(bob,_,Goal,_) <- .print("I am obliged to produte a state that counts as ", Goal).
 
  
+doNotCare(raining)[source(Ag)]
   <- .print(Ag, " ignores my warning about raining");
      .
      
 
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
