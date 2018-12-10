// Agent sample_agent in project teste_list_jason

/* Initial beliefs and rules */

/* Initial goals */

!start.

/* Plans */

+!start : true <-    
   !setup_sai;      
   load("src/org/norms.npl");
   start. //start the clock


+!setup_sai <-
   joinWorkspace("test",I);
   lookupArtifact("test_art",ArtSai); 
   focus(ArtSai);
   getSaiEngine(SE)[artifact_id(ArtSai)];
    
   joinWorkspace("wsp_npl",WspNpl);
   lookupArtifact("nplArt",NplArt);
   focus(NplArt);
   setInstitution(SE)[artifact_id(NplArt)].



// obligation to achieve a goal
// ============================      
// This plan works exclusively for goals that are state-status functions whose constitution is conditioned by the occurrence of an 
// event to be produced by the agent Ag.
//
// Implementing plans for other kinds of obligations is a ToDo
//
+obligation(Ag,R,Goal,Deadline) //the agent perceives the obligation following the NPL notation
   : .my_name(Ag) &
     state_sf(Goal) & //the goal is a state-status function
     constitutive_rule(X,Goal,ToDo[sai__agent(Ag)],M) & //The agent looks for a constitutive rule defining how the goal is achieved 
     (X==sai__freestandingY | state_sf(X))& T\==true 
   <- println("I am obliged to see to me that the state ",Goal," holds. I found a constitutive rule that shows me I have to produce the event ", ToDo);
      ToDo.
      

+obligation(Ag,R,Goal,DeadLine)  
   : .my_name(Ag)
   <- println("I am obliged to ",What,", but I don't know what to do!").




{ include("$jacamoJar/templates/common-cartago.asl") }

