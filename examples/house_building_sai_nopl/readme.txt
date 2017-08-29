This is a "situated" version of the classical house_built example.
The dynamic facts that animate the NOPL dynamics are constituted from the environment instead of being produced by operations in the artifacts.
The constitutive specification is in /src/org/constitutive.sai

* Before running: copy the files antlr-runtime-4.7.jar and sai.jar to the JACAMO_HOME directory. Such files are available in the /build/libs directory of the sai package.


* Running the example: (i) Import the project as a JaCaMo project in Eclipse and run it as usual  or (ii) in a terminal, type jacamo house.jcm



* While the example is running: To check the constitutive state, go to http://localhost:3275/bh


* The normative state can be checked in the Organisation Inspector, as usual in JaCaMo applications


* Known problems: sometimes the agents start to act in the environment placing bids before the SAI engine is ready. As a consequence, some status functions are not constituted and the Moise group is not well formed after the action being finished.
