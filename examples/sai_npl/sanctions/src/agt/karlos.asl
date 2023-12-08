!start.

+!start : true
    <- makeArtifact(nb1,"sai.bridges.jacamo.NormativeBoardSai",[],AId);
       focus(AId);
       debug(inspector_gui(on));
       load("src/org/demo.npl");
       //addFact(vl(20)); // triggers the norm n1 --> generated through constitution in this new version
       //addFact(c(10));  // add condition for the application of sanction s1  --> generated through constitution in this new version
       makeArtifact(ps1,"police.Sanctioner",[],SArt);
       listen(AId)[artifact_id(SArt)]; // ps1 get normative events (including sanctions) from nb1       
       .

//connect norms to institution
+!setup_sai: focusing(ArtSai,inst_test_art,_,_,inst_test,_) & focusing(NplArt,nb1,_,_,_,_) <-
   getSaiEngine(SE)[artifact_id(ArtSai)];
   setInstitution(SE)[artifact_id(NplArt)];
  .

+!setup_sai<-
    .wait(focusing(ArtSai,inst_test_art,_,_,inst_test,_) & focusing(NplArt,nb1,_,_,_,_));
    !setup_sai.


//start the clock artifact
+!manage_clock <-  
    setFrequency(1);     
    start; //start the clock
.      


+oblUnfulfilled(O) <- .print("Unfulfilled ",O).
+sanction(NormId,Event,Sanction) <- .print("Sanction ",Sanction," created for norm ", NormId, " that is ",Event).


{ include("$jacamo/templates/common-cartago.asl") }
{ include("$jacamo/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moise/asl/org-obedient.asl") }
