/* */

{ include("$jacamoJar/templates/common-cartago.asl") }
//{ include("$jacamoJar/templates/common-moise.asl") }






!start.


+!start : true <- 
   //?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //cartago.set_current_wsp(WspSai);
    joinWorkspace("wsp_sai",WspSai); //look to the SAI workspace
   lookupArtifact("npl2sai",Npl2ai);   
   focus(Npl2ai); 
   .print("hello world.").



 
//TODO: make a generic plan to deal with this obligation 
//+obliged(Me,inform_invalid_evacuation(Zone,Actor),_) : .my_name(Me)  & Zone==downtown & Actor==firefighter
+obligation(Me,R,sai__event(inform_invalid_evacuation(Zone,Actor)[sai__agent(Me)]),Time): .my_name(Me)  & Zone==downtown & Actor==firefighter
   <- .print("SAI informs I am obliged to inform an inconsistent evacuation of ", Zone, " to ", Actor);   
      //?jcm__ws("wsp_fire_brigade",WsFB);
      //cartago.set_current_wsp(WsFB);
       joinWorkspace("wsp_fire_brigade",WsFB);       
      lookupArtifact("table_fire_brigade", ArtId);
      .print("The table is ", ArtId);
      putImagible(wrong_action_imagible,1,2, Me)[artifact_id(ArtId)];           
      .
      
+obliged(Me,inform_invalid_evacuation(Zone,Actor),_) : .my_name(Me)  & Zone==downtown & Actor==mayor
   <- .print("SAI informs I am obliged to inform an inconsistent evacuation of ", Zone, " to ", Actor);
      //?jcm__ws("wsp_mayor",WsMayor);
      //cartago.set_current_wsp(WsMayor);
      joinWorkspace("wsp_mayor",WsMayor);
      lookupArtifact("table_mayor", ArtId);
      .print("The table is ", ArtId);
      putImagible(wrong_action_imagible,1,2, Me)[artifact_id(ArtId)];           
      . 
      
+obligation(Me,R,Obl,Time): .my_name(Me) 
	<-.print("I am obliged to ", Obl, "but I do not have a plan to that").
