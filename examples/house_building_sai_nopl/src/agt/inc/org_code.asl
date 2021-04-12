// Common code for the organisational part of the system

task_roles("SitePreparation",  [site_prep_contractor]).
task_roles("Floors",           [bricklayer]).
task_roles("Walls",            [bricklayer]).
task_roles("Roof",             [roofer]).
task_roles("WindowsDoors",     [window_fitter, door_fitter]).
task_roles("Plumbing",         [plumber]).
task_roles("ElectricalSystem", [electrician]).
task_roles("Painting",         [painter]).


+!contract(Task,GroupName)
    : task_roles(Task,Roles)
   <- !in_bh_institution; //the hired agent becomes part of the institution.
      !in_ora4mas;
      .print("Contract ",Task, GroupName );
      lookupArtifact(GroupName, GroupId);
      for ( .member( Role, Roles) ) {
         focus(GroupId);
      }
      .

-!contract(Service,GroupName)[error(E),error_msg(Msg),code(Cmd),code_src(Src),code_line(Line)]
   <- .print("Failed to sign the contract for ",Service,"/",GroupName,": ",Msg," (",E,"). command: ",Cmd, " on ",Src,":", Line).


+!in_ora4mas
   <- joinWorkspace("/main/ora4mas",_);
      +in_ora4mas.

-!in_ora4mas
   <- .wait(100); 
      !in_ora4mas.


+!in_bh_institution <-
   joinWorkspace("/main/bh",_);
   lookupArtifact("bh_art", InstArt);
   focus(InstArt).
   


-!in_bh_institution <-       
   .wait(100);
   !in_bh_institution.

{ include("$jacamoJar/templates/common-moise.asl") }
{ include("$jacamoJar/templates/org-obedient.asl") }
