// Agent giacomo, who wants to build a house
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }



/* Initial beliefs and rules */

// counts the number of tasks based on the observable properties of the auction artifacts
number_of_tasks(NS) :- .findall( S, task(S), L) & .length(L,NS).
      

/* Initial goals */

!have_a_house.


/* Plans */

+!have_a_house 
   <- !setup_sai;
      joinWorkspace("wsp_auction",I);
      //?jcm__art("clock", Clock);
      lookupArtifact("clock", Clock);   
      start[artifact_id(Clock)]; //while the clock is counting the bidders can bid       
      !contract; // hire the companies that will build the house
      !execute.  // (simulates) the execution of the construction
      
+!setup_sai
   <- !setup_sai_wsp_ora4mas; //each plan "setup_sai_X" sets links the workspace X to the SAI engine    
      !setup_sai_wsp_auction; 
      !setup_sai_wsp_house; 	  
      .      
      
//-!setup_sai
//   <- .print("Error setup_sai").

+!setup_sai_wsp_auction
   <- //?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //	  cartago.set_current_wsp(WspSai);
      joinWorkspace("wsp_sai",Wsp_Sai);
      lookupArtifact("sai",ArtSai);   
      focus(ArtSai);   
      getRuleEngine(RE)[artifact_id(ArtSai)];
      
      //?jcm__ws("wsp_auction",WspAuction);
      //cartago.set_current_wsp(WspAuction);   
      joinWorkspace("wsp_auction",Wsp_Auction);
      setWSPRuleEngine(RE)[artifact_id(Wsp_Auction)]; //links the woskspace "wsp_auction" to SAI. Thus, the SAI engine is fed with the environmental facts from that workspace
                       


      .      
      
-!setup_sai_wsp_auction
   <- .wait(500);
      !setup_sai_wsp_auction.      
      
+!setup_sai_wsp_house
   <- //?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //	  cartago.set_current_wsp(WspSai);
      joinWorkspace("wsp_sai",Wsp_Sai);
      lookupArtifact("sai",ArtSai);   
      focus(ArtSai);   
      getRuleEngine(RE)[artifact_id(ArtSai)];
      
      //?jcm__ws("wsp_house",WspHouse);
      //cartago.set_current_wsp(WspHouse);   
      joinWorkspace("wsp_house",Wsp_House); 
      setWSPRuleEngine(RE)[artifact_id(Wsp_House)]; //links the woskspace "wsp_house" to SAI. Thus, the SAI engine is fed with the environmental facts from that workspace           
      .      
      
-!setup_sai_wsp_house
   <- .wait(500);
      !setup_sai_wsp_house.      
      
+!setup_sai_wsp_ora4mas
   <-//?jcm__ws("wsp_sai",WspSai); //look to the SAI workspace
   //	  cartago.set_current_wsp(WspSai);
      joinWorkspace("wsp_sai",I);
      lookupArtifact("sai",ArtSai);   
      focus(ArtSai);          
	  
	 // ?jcm__ws("wsp_ora4mas",WspOra4mas); 
   	  //cartago.set_current_wsp(WspOra4mas);
          joinWorkspace("wsp_ora4mas",J);
   	  lookupArtifact("bhsch",SchArtId);
      //getNormativeEngine(NEs)[artifact_id(SchArtId)];
      //addNormativeEngine(NEs)[artifact_id(ArtSai)]; //adds the normative engine from the scheme artifact to the sai engine. Thus, the normative engine is fed with the constitutive state      

      debug(inspector_gui(on))[artifact_id(SchArtId)]; 
      getSaiEngine(SE)[artifact_id(ArtSai)];
      setInstitution(SE)[artifact_id(SchArtId)];
               
      lookupArtifact("hsh_group",GrpArtId);  
      debug(inspector_gui(on))[artifact_id(GrpArtId)]; 
      //getNormativeEngine(NEg)[artifact_id(GrpArtId)];
      //addNormativeEngine(NEg)[artifact_id(ArtSai)]; //adds the normative engine from the group artifact to the sai engine. Thus, the normative engine is fed with the constitutive state

       setInstitution(SE)[artifact_id(GrpArtId)];
      .
      
      
-!setup_sai_wsp_house
   <- .wait(500);
      !setup_sai_wsp_ora4mas.       
      
-!have_a_house[error(E),error_msg(Msg),code(Cmd),code_src(Src),code_line(Line)]
   <- .print("Failed to build a house due to: ",Msg," (",E,"). Command: ",Cmd, " on ",Src,":", Line).

   
/* Plans for Contracting */

+!contract: constitutive_rule(X,Y,T,M)
  <- ?nticks(Starting_Auction_Time);
     +starting_auction_time(Starting_Auction_Time);
     //.print("Starting auction at ", Starting_Auction_Time);
     !wait_for_bids.

+!contract
   <- .wait(500);
      !contract.
   
-!contract
   <- .print("Error on contract").
   
+!wait_for_bids:nticks(X)&(X>=8000) // use an internal deadline of 5 seconds to close the auctions
   <-   joinWorkspace("wsp_auction",I);
      stop[artifact_id(Clock)];
      !show_winners;
      .
      
+!wait_for_bids
   <- ?nticks(X);
      ?starting_auction_time(Starting_Auction_Time)
      println("Waiting the bids ", 8000-X," seconds...");
      .wait(1000); 
      !wait_for_bids;
      .
      
      
+!show_winners     
   <- for ( currentWinner(Ag)[artifact_id(ArtId)] ) {
         ?currentBid(Price)[artifact_id(ArtId)]; // check the current bid
         ?task(Task)[artifact_id(ArtId)];          // and the task it is for
         println("Winner of task ", Task," is ", Ag, " for ", Price)
      }. 

      
/* Plans for managing the execution of the house construction */

+!execute
   <- println;
      println("*** Execution Phase ***");
      println;	  
	      
      //?jcm__ws("wsp_ora4mas",WspOra4mas); 
   //	  cartago.set_current_wsp(WspOra4mas);
      joinWorkspace("wsp_ora4mas",Wsp_Ora4mas);
    
   	 .
  

-!execute
   <- .print("Error on execute").

+!house_built // I have an obligation towards the top-level goal of the scheme: finished!
   <- println("*** Finished ***").
