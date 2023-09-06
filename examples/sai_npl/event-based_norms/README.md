# Example of SAI vs. NPL integration
This sample application illustrates the integration between SAI institutions an NPL norms.

## Scenario
The application has a single norm stating that the <em>clock manager</em> is obliged to finish the current session. This obligation is defined in the normative specificaton available [here](src/org/norms.npl).

Both <em>clock manager</em> and  <em>session finished</em> are institutional concepts constituted from environmental facts. Such constitution is specified [here](src/org/constitutive.sai). When an agent <em>A</em> is institutionally recognized as <em>clock_manager</em>, the institution is in a state that includes the proprety <em>play(A,clock_manager)</em>.  A session is finished when the agent that counts as <em>clock_manager</em> produces the event <em>stop</em> in the environment. This event is produced by an operation on an artifact. Notice that the operation <em>stop</em> counts as finishing the session only if is performed by the agent that counts as Such constitution is specified [here](src/org/constitutive.sai). 

The only [agent](src/agt/sample_agent.asl) in this application has the initial goal to start a session. When this happens, this same agent is obliged, by the norm, to finish the session. The agent is obedient and aims to fulfill it. To this end, the agent (i) consults the [institutional specification](src/org/constitutive.sai) to check how to act to fulfill the norm and (ii) acts accordingly.

The normative can be inspected at [http://127.0.1.1:3271](http://127.0.1.1:3271/)


## Running the example
Launch the JaCaMo application:

Linux:
In a shell, type
```
./gradlew run
```


Windows:
In a shell, type
```
gradlew run 
```
