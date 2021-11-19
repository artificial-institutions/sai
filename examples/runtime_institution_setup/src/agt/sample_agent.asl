// Agent sample_agent in project inst

/* Initial beliefs and rules */

/* Initial goals */

!start.
!do_inc.

/* Plans */

+!start
   <- .print("hello world.");
      !setup_sai;
   .

+!do_inc
   <- .wait(5000);
      inc;      
      !do_inc.

+!setup_sai
   <- makeArtifact(i1,sai.bridges.jacamo.ConstitutiveArt,[ "i1","src/org/demo.sai"], InstArt); //launch institution
      getRuleEngine(RE)[artifact_id(InstArt)]; //gets the reference RE for instutional rule engine (responsible for handling the environmental state) 
      joinWorkspace("/main/w1",W1); 
      setWSPRuleEngine(RE)[artifact_id(W1)].
      

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
