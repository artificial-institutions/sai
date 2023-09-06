/* The agent infra builds the basic infrastructure of this project.
 * Some parts should be moved to the JaCaMo infrastructure
 */


/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <-
   !setup_normative_art.
   

+!setup_normative_art <-
   joinWorkspace("/main/inst_a",I);
   lookupArtifact("inst_a_art",ArtSai); 
   focus(ArtSai);
   

   getSaiEngine(SE)[artifact_id(ArtSai)];
   joinWorkspace("/main/wsp_npl",WspNpl);
   lookupArtifact("nplArt",NplArt);
   focus(NplArt);
   setInstitution(SE)[artifact_id(NplArt)];
   load("src/org/norms.npl");
   
   rainWarning.
         

{ include("$jacamoJar/templates/common-cartago.asl") }
{ include("$jacamoJar/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moiseJar/asl/org-obedient.asl") }
