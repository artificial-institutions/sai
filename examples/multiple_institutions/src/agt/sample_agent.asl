!start.

+!start
   <- .print("hello world.");

      lookupArtifact("/main/w1/a1", ArtW1);
      lookupArtifact("/main/w2/a2", ArtW2);
      lookupArtifact("/main/w3/a3", ArtW3);

      //creates brute fact count(ArtName, 11) in the workspaces w1 and w2
      inc[artifact_id(ArtW1)];
      inc[artifact_id(ArtW2)];
      inc[artifact_id(ArtW3)];
  .


{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
