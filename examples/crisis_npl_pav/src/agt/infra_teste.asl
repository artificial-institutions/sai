/* 
 * This agent perform some tasks related to the infratructure that are not specified in the jcm file. 
 * Specifically, it attaches the Rule Engine, encolsed in the Sai4JaCaMo artifact, to each workspace in the application. 
 * The Rule Engine is a listener that captures events and changes in the observable state of the artifacts.   
 * 
 * 
 */

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <- 
   
   
   
   .print("hello world.").


+table(X) <- .println("Found table ", X).
