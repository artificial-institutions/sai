!start.

+!start
   <- .print("hello world.");

      lookupArtifact("/main/w1/a", ArtW1);
      lookupArtifact("/main/w2/b", ArtW2);

      //creates brute fact count(ArtName, 11) in the workspaces w1 and w2
      inc[artifact_id(ArtW1)];
      inc[artifact_id(ArtW2)];
  .         


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
