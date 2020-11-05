// Agent sample_agent in project events

!start.


+!start : true 
   <- .print("hello world.");
      ignoreArtifact("clock1");
      op1[artifact_name(clock1)];
      op2(99)[artifact_name(clock2)];
      .print("done").
      



{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
