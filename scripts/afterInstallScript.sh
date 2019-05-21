#!/bin/bash
cd $SOURCE_HOME
mvn clean install
cp $SOURCE_HOME/target/doodle.war $CATALINA_HOME/webapps
$CATALINA_HOME/bin/startup.sh