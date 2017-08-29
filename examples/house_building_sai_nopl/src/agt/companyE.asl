// This company bids for Floors, Walls, and Roof
// Strategy: a fixed lowest price for doing all 3 tasks,
//           decrease the current bid by a fixed value

{ include("common.asl") }
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

my_price(800). // minimum price for the 3 tasks 

// a rule to calculate the sum of the current bids place by this agent
sum_of_my_offers(S) :- 
   .my_name(Me) & .term2string(Me,MeS) &
   .findall( V,      // artifacts/auctions I am currently winning
             currentWinner(MeS)[artifact_id(ArtId)] &
			 currentBid(V)[artifact_id(ArtId)], 
             L) & 
   S = math.sum(L).

/* Plans for Auction phase */

+currentBid(V)[artifact_id(Art)]      // there is a new value for current bid
    : not i_am_winning(Art) &         // I am not the winner
      my_price(P) &
	  sum_of_my_offers(Sum) &
	  task(S)[artifact_id(Art)] &
	  P < Sum + V &                    // I can still offer a better bid
          hasBidden(Bid)                    //this is not the first bid, then it is possible to bit immediately 
   <- //.wait(3500); //agents wait a time before to bid to ensure that all the infrastructure, namely, the link between SAI and CArtAgO, is ready
      //?jcm__ws("wsp_auction",WspAuction);
   	//  cartago.set_current_wsp(WspAuction);
      bid( math.max(V-10,P) )[ artifact_id(Art) ].  // place my bid offering a cheaper service
   


+currentBid(V)[artifact_id(Art)]      // there is a new value for current bid
    : not i_am_winning(Art) &         // I am not the winner
      my_price(P) &
	  sum_of_my_offers(Sum) &
	  task(S)[artifact_id(Art)] &
	  P < Sum + V 
   <- .wait(4500); //as it is the first bid, agents wait a time before start bidding to ensure that all the infrastructure, namely, the link between SAI and CArtAgO, is ready
      +hasBidden(Bid); 
      bid( math.max(V-10,P) )[ artifact_id(Art) ].  // place my bid offering a cheaper service
   
/* plans for execution phase */

// obligation to achieve a goal      
+obligation(Ag,Norm,What,Deadline)[artifact_id(ArtId)]
    : .my_name(Ag) & (What=satisfied(Scheme,Goal) | What = done(Scheme,Goal,Ag))
   <- //.print(" ---> working to achieve ",Goal," in scheme ",Scheme);
      !Goal[scheme(Scheme)];
      //.print(" <--- done");
      goalAchieved(Goal)[artifact_id(ArtId)].
      

{ include("org_code.asl") }
{ include("org_goals.asl") }
