// Agent alice in project speech_acts_sai

/* Initial beliefs and rules */

/* Initial goals */


/* Plans */



+raining[source(Ag)] <- 
   .print(Ag, " inform it is raining. I will ignore it.");
   .send(Ag,tell,doNotCare(raining)).

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
