// Agent sample_agent in project events

!start.


+!start : true 
   <- .print("hello world.");
      op1[artifact_name(clock)];
      op2(99)[artifact_name(clock)];
      .print("done").
      


+sai_is(X,Y,A) <- .print("Status function assignment: ", sai_is(X,Y,A)).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
