// Agent sample_agent in project events

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+constitutive_rule(X,Y,T,M) <- .print("const rule: ", constitutive_rule(X,Y,T,M)).

+sai__is(X,Y,M) <- .print("sfa: ", sai__is(X,Y,M)).

+!start : true 
   <-       
      .print("hello world.");
      //focusWhenAvailable(clock);
      op1;
      op2(99);
      ?constitutive_rule(Status,esf2,_,_ );
      .print(constitutive_rule(Status, B,C ,D));
      .print("done").

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
