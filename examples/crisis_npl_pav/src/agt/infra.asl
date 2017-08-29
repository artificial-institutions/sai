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
	
   //?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //cartago.set_current_wsp(WspSai);
   joinWorkspace("wsp_sai",Wsp_Sai);
   lookupArtifact("sai",ArtSai);   
   focus(ArtSai);   
   getRuleEngine(RE)[artifact_id(ArtSai)];
   
   lookupArtifact("npl2sai",Npl2ai);   
   focus(Npl2ai);
   
   //loadNplProgram("src/org/crisis.npl");
      
   //get a reference of the NPL engine.
   //getNormativeEngine(NE)[artifact_id(Npl2ai)];   
   //register the NPL engine in the constitutive engine. The NPL engine is thus informed about changes in the constitutive state 
   //addNormativeEngine(NE)[artifact_id(ArtSai)];
   
   getSaiEngine(SE)[artifact_id(ArtSai)];
   setInstitution(SE)[artifact_id(Npl2ai)]; 
      
   
   
   /*Setup the workspace wsp_mayor*/
   //?jcm__ws("wsp_mayor",WsMayor);
   //cartago.set_current_wsp(WsMayor);
   joinWorkspace("wsp_mayor",WsMayor);   
   setWSPRuleEngine(RE)[artifact_id(WsMayor)];
   
   
   /*Setup the workspace wsp_fire_brigade*/
   //?jcm__ws("wsp_fire_brigade",WsFB);
   //cartago.set_current_wsp(WsFB);
   joinWorkspace("wsp_fire_brigade",WsFB);   
   setWSPRuleEngine(RE)[artifact_id(WsFB)];
   
   /*Setup the workspace wsp_gis*/
   //?jcm__ws("wsp_gis",WsGis);
   //cartago.set_current_wsp(WsGis);
   joinWorkspace("wsp_gis",WsGis);
   setWSPRuleEngine(RE)[artifact_id(Ws1)];   
   updateInhabitants(downtown, 200)[artifact_name("crisis_parameters")];	
   updatePhase(downtown, preventive)[artifact_name("crisis_parameters")];
   
   
   
   .print("hello world.").


+table(X) <- .println("Found table ", X).
