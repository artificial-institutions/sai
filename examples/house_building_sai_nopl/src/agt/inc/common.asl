/* auxiliary rules for agents */



// obligation to achieve a goal
// ============================      
+obligation(Ag,R,done(Scheme,Goal,Ag),Deadline) //the agent perceives the obligation following the NPL notation
   : .my_name(Ag) 
     & constitutive_rule(X,done(Scheme,Goal,Ag),ToDo[sai__agent(Ag)],M) //The agent looks for a constitutive rule defining how the goal is achieved 
     & X==sai__freestandingY & T\==true 
   <- println("I am obliged to ",Goal,". I found a constitutive rule that shows me. I have to produce the event ", ToDo);
      joinWorkspace("/main/wsp_house",I);
      lookupArtifact("housegui",House);
      focus(House);   	   
      .wait(100); //to avoid some problems: ORA4MAS seems being processing previous goal states when SAI constitutes some new achievements. To check.
      ToDo[artifact_id(House)].
      

// an unknown type of obligation was received
+obligation(Ag,R,What,DeadLine)  
   : .my_name(Ag)
   <- println("I am obliged to ",What,", but I don't know what to do!").

	
