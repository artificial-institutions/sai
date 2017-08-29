/*   */
{ include("$jacamoJar/templates/common-cartago.asl") }
//{ include("$jacamoJar/templates/common-moise.asl") }


/*The agent is supposed to know all the tables in the application*/
known_table(table_fire_brigade).
known_table(table_logistic_cell).
known_table(table_mayor).

/* The agent knows the right imagibles to signal the tangibles 
   corresponding_imagible(T,I) means that the imagible I corresponds to the tangible T   
*/
corresponding_imagible(launch_tangible_object,launch_imagible).
corresponding_imagible(alert_tangible_object,alert_imagible).
corresponding_imagible(to3,img3).
corresponding_imagible(to4,img4).
corresponding_imagible(to5,img5).



!start.



+!start : true <- 
   //?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //cartago.set_current_wsp(WspSai);
    joinWorkspace("wsp_sai",WspSai); //look to the SAI workspace
   lookupArtifact("npl2sai",Npl2ai);   
   focus(Npl2ai); 
   .print("hello world.");
   .
	
 


+table(X)[artifact_id(Art)] <- 
   .println("Found table ", X);
   +known_table(X,Art).

            
//obligation(communicator,n5,informTangibleInteraction(table_mayor,launch_tangible_object,1,2),600000           
+obligation(Me,R,informTangibleInteraction(SourceTable,TangibleObject,X,Y),Cd) : .my_name(Me) & corresponding_imagible(TangibleObject,Imagible) & .term2string(SourceTable, STable)
   <- .print("SAI informs I am obliged to inform that the tangible object ", TangibleObject, " is in the ", SourceTable, "(", X, ",", Y, ")");
      for ( known_table(TargetTable,ArtId) & TargetTable \== STable ){
	    putImagible(Imagible,X,Y,Me)[artifact_id(ArtId)];   
     }
	.
	
	             
 
  
/*+obligation(communicator,n5,informTangibleInteraction(table_mayor,launch_tangible_object,1,2),600000)
   <- .print("AAAAAAAAAAA").  
  
+obligation(communicator,n5,informTangibleInteraction(_,_,_,_),600000)
    <-.print("JJJJJJJJJJJJJJJJJJJJJJJJJJJJJ").
   */
                  
+obligation(Me,R,informTangibleInteraction(S,T,X,Y),Time): .my_name(Me) 
	<-.print("I am obliged to ", Obl, "but I do not have a plan to that - T-> ", T).

+obligation(communicator,R,Obl,Time)  
	<-.print("AAAAAAAAAAAAAAAAa").	


	



+obligation(Me,R,Obl,Time): .my_name(Me) 
	<-.print("I am obliged to ", Obl, "but I do not have a plan to that").	
	
