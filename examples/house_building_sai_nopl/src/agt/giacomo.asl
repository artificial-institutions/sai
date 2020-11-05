// Agent Giacomo, who wants to build a house

{ include("$jacamoJar/templates/common-cartago.asl") }
//{ include("$jacamoJar/templates/common-moise.asl") }
{ include("common.asl") }
{ include("org_code.asl") }

/* Initial beliefs and rules */

// counts the number of tasks based on the observable properties of the auction artifacts
number_of_tasks(NS) :- .findall( S, task(S), L) & .length(L,NS).


/* Initial goals */

!have_a_house.


/* Plans */

+!have_a_house  
   <- !contract; // hire the companies that will build the house
      !execute.  // (simulates) the execution of the construction

-!have_a_house[error(E),error_msg(Msg),code(Cmd),code_src(Src),code_line(Line)]
   <- .print("Failed to build a house due to: ",Msg," (",E,"). Command: ",Cmd, " on ",Src,":", Line).


/* Plans for Contracting */

+!contract
   <- start[artifact_id(Clock)]; //while the clock is counting the bidders can bid 
      ?nticks(Starting_Auction_Time);
      +starting_auction_time(Starting_Auction_Time);
      !wait_for_bids.



+!wait_for_bids:nticks(X)&(X>=8000) // use an internal deadline of 5 seconds to close the auctions
   <-   joinWorkspace("wsp_auction",I);
      stop[artifact_id(Clock)];
      !show_winners.

      
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

      // create the GUI artifact
      createWorkspace("wsp_house");
      joinWorkspace("wsp_house",WspHouse); 
      makeArtifact("housegui", "simulator.House")[wid(WspHouse)];

      joinWorkspace("bh",_);
      lookupArtifact("bh_art", InstArt);
      focus(InstArt)
      getRuleEngine(RE)[artifact_id(InstArt)];
      joinWorkspace("wsp_house",Wsp_House); 
      setWSPRuleEngine(RE)[artifact_id(Wsp_House)]; //links the woskspace "wsp_house" to SAI. Thus, the SAI engine is fed with the environmental facts from that workspace           
      !in_ora4mas;
      !contract_winners("hsh_group").
      

+!contract_winners(GroupName)
    : number_of_tasks(NS) &
      .findall( ArtId, currentWinner(A)[artifact_id(ArtId)] & A \== "no_winner", L) &
      .length(L, NS)
   <- for ( currentWinner(Ag)[artifact_id(ArtId)] ) {
            ?task(Task)[artifact_id(ArtId)];
            println("Contracting ",Ag," for ", Task);
            .send(Ag, achieve, contract(Task,GroupName)) // sends the message to the agent notifying it about the result
      }.

+!contract_winners(_)
   <- println("** I didn't find enough builders!");
      .fail.




