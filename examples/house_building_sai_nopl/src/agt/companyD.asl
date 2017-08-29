// This company bids for all tasks
// Strategy: bids a random value 

{ include("common.asl") }
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }



+task(S)[artifact_id(Art)]:
   hasBidden(Bid)                    //this is not the first bid, then it is possible to bit immediately 
   <- .wait(math.random(500)+50);
      Bid = math.floor(math.random(10000))+800;     
      +hasBidden(Bid); 
      bid( Bid )[artifact_id(Art)]. // recall that the artifact ignores if this
	                                // agent places a bid that is higher than
									// the current bid



+task(S)[artifact_id(Art)]
   <- .wait(math.random(500)+50);
      Bid = math.floor(math.random(10000))+800;
      .wait(4500); //as it is the first bid, agents wait a time before start bidding to ensure that all the infrastructure, namely, the link between SAI and CArtAgO, is ready
      +hasBidden(Bid); 
      bid( Bid )[artifact_id(Art)]. // recall that the artifact ignores if this
	                                // agent places a bid that is higher than
									// the current bid


{ include("org_code.asl") }
{ include("org_goals.asl") }
