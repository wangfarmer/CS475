#!/bin/bash

javac compute/Pi.java
jar cvf compute.jar compute/*.class
cp compute.jar public_html/classes/
javac -cp public_html/classes/compute.jar engine/PiImpl.java

javac -cp /home/dannyquint/git/CS475/src/public_html/classes/compute.jar client/ComputePi.java engine/PiImpl.java
cp engine/PiImpl.class public_html/classes/client/
rmiregistry &
java -cp /home/dannyquint/git/CS475/src/:/home/dannyquint/git/CS475/src/public_html/classes/compute.jar -Djava.rmi.server.codebase=file:./home/dannyquint/git/CS475/src/public_html/classes/ -Djava.security.policy=server.policy engine.PiImpl dan &
java -cp /home/dannyquint/git/CS475/src/:/home/dannyquint/git/CS475/src/public_html/classes/compute.jar -Djava.rmi.server.codebase=file:./home/dannyquint/git/CS475/src/public_html/classes/ -Djava.security.policy=client.policy client.ComputePi 127.0.0.1 dan retrieve-event 4
