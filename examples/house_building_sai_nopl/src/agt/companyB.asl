// This company bids for site preparation
// Strategy: decreasing its price by 150 until its minimal value

{ include("common.asl") }
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

my_price(1500). // initial belief



+currentBid(V)[artifact_id(Art)]        // there is a new value for current bid
    : not i_am_winning(Art) &           // I am not the winner
      my_price(P) & P < V &             // I can offer a better bid
      hasBidden(Bid)                    //this is not the first bid, then it is possible to bit immediately 
   <- bid( math.max(V-150,P) ).         // place my bid offering a cheaper service


+currentBid(V)[artifact_id(Art)]        // there is a new value for current bid
    : not i_am_winning(Art) &           // I am not the winner
      my_price(P) & P < V               // I can offer a better bid
   <- .wait(4500); //as it is the first bid, agents wait a time before start bidding t ensure that all the infrastructure, namely, the link between SAI and CArtAgO, is ready
      +hasBidden(math.max(V-150,P));
      bid( math.max(V-150,P) ).         // place my bid offering a cheaper service



/* plans for execution phase */

/*{ include("org_code.asl") }
  
+!site_prepared 
   <- ?jcm__ws("wsp_house",WspHouse); 
   	  cartago.set_current_wsp(WspHouse);
      prepareSite. // simulates the action (in GUI artifact)
*/    

      
