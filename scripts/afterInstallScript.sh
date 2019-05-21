#!/bin/bash
cd $SOURCE__HOME
mvn clean install
cp $SOURCE__HOME/target/doodle.war $CATALINA_HOME/webapps
$CATALINA_HOME/bin/startup.sh