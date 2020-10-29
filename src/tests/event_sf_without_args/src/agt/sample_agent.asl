// Agent sample_agent in project events

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true 
   <- .print("hello world.");
      focusWhenAvailable(clock);
      op1;
      op2(99);
      .print("done").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
