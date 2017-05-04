#!/bin/bash

#javac compute/Pi.java
javac compute/CalendarMgrIntr.java compute/CalendarObjIntr.java compute/EventInterface.java
javac engine/EventObj.java engine/CalendarObject.java
jar cvf compute.jar compute/*.class engine/EventObj.class engine/CalendarObject.class

cp compute.jar public_html/classes/

javac -cp public_html/classes/compute.jar engine/CalendarManager.java

javac -cp /home/dannyquint/git/CS475/src/public_html/classes/compute.jar client/CalendarDemo.java engine/CalendarManager.java
cp engine/CalendarManager.class public_html/classes/client/
rmiregistry &
java -cp /home/dannyquint/git/CS475/src/:/home/dannyquint/git/CS475/src/public_html/classes/compute.jar -Djava.rmi.server.codebase=file:./home/dannyquint/git/CS475/src/public_html/classes/ -Djava.security.policy=server.policy engine.CalendarManager compute &
java -cp /home/dannyquint/git/CS475/src/:/home/dannyquint/git/CS475/src/public_html/classes/compute.jar -Djava.rmi.server.codebase=file:./home/dannyquint/git/CS475/src/public_html/classes/ -Djava.security.policy=client.policy client.CalendarDemo 127.0.0.1 compute
