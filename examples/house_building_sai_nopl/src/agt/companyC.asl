// This company can bid for all types tasks,
// but can commit to at most 2 of them
// Strategy: fixed price

{ include("common.asl") }
{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// a rule to help the agent infer whether it can commit to another task
can_commit :- 
   .my_name(Me) & .term2string(Me,MeS) &
   .findall( ArtId, currentWinner(MeS)[artifact_id(ArtId)], L) &
   .length(L,S) & S < 2.

// initial beliefs about valuations for the auction
my_price("SitePreparation", 1900).
my_price("Floors",           900). 
my_price("Walls",            900). 
my_price("Roof",            1100). 
my_price("WindowsDoors",    2000). 
my_price("Plumbing",         600). 
my_price("ElectricalSystem", 300). 
my_price("Painting",        1100). 

 
@lbo[atomic] // atomic to ensure it still winning less than two when the bid is placed
+currentBid(V)[artifact_id(Art)]        // there is a new value for current bid
    : task(S)[artifact_id(Art)] &
      my_price(S,P) &                   // get my valuation for this service
      not i_am_winning(Art) &           // I am not the winner
      P < V &                           // I can offer a better bid
      can_commit &                      // I can still commit to another task
      hasBidden(Bid)                    //this is not the first bid, then it is possible to bit immediately 
   <- bid( P )[ artifact_id(Art) ].     // place my bid offering a cheaper service

//@lbo[atomic] // atomic to ensure it still winning less than two when the bid is placed
+currentBid(V)[artifact_id(Art)]        // there is a new value for current bid
    : task(S)[artifact_id(Art)] &
      my_price(S,P) &                   // get my valuation for this service
      not i_am_winning(Art) &           // I am not the winner
      P < V &                           // I can offer a better bid
      can_commit
   <- .wait(4500); //as it is the first bid, agents wait a time before start bidding to ensure that all the infrastructure, namely, the link between SAI and CArtAgO, is ready
      +hasBidden(P);    
      bid( P )[ artifact_id(Art) ].     // place my bid offering a cheaper service


// obligation to achieve a goal      
+obligation(Ag,Norm,What,Deadline)[artifact_id(ArtId)]
    : .my_name(Ag) & (What=satisfied(Scheme,Goal) | What = done(Scheme,Goal,Ag))
   <- //.print(" ---> working to achieve ",Goal," in scheme ",Scheme);
      !Goal[scheme(Scheme)];
      //.print(" <--- done");
      goalAchieved(Goal)[artifact_id(ArtId)].
      
/* plans for execution phase */

{ include("org_code.asl") }
{ include("org_goals.asl") }
