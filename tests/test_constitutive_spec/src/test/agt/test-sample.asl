// Agent that tests 'sample_agent' in project test_constitutive_spec

// includes target agent to tests
{ include("sample_agent.asl") }

// includes test library
{ include("tester_agent.asl") } // from JaCaMo

@[test]
+!test_start // test goal start of the agent. A belief 'started' should be added by goal start
    <-  !start; // creates the goal and waits for its completion
        !assert_true( started(_,_,_,_,_,_) ).


// usual include for all JaCaMo agent
//{ include("$jacamo/templates/common-cartago.asl") }
//{ include("$jacamo/templates/common-moise.asl") }

// uncomment the include below to have an agent compliant with its organisation
//{ include("$moise/asl/org-obedient.asl") }
