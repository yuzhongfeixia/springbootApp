#!/bin/bash

export JAVA_HOME=$HOME/jdk1.7.0_21

export MAIN_SERVER_OBJECT=com.afis.jx.Application
export MAIN_SERVRt_OPTS=" -d64 -server -Xms1024M -Xmx2048M "
export CH_SERVER_HOME=$HOME/CH-Pay
export CH_SERVER_CONFIG=$CH_SERVER_HOME/config
export CH_SERVER_LIB=$CH_SERVER_HOME/lib
export CH_SERVER_LOG=$CH_SERVER_HOME/logs
export CH_SERVER_PID=$CH_SERVER_HOME/bin/$MAIN_SERVER_OBJECT.pid

CLASSPATH=.:$CH_SERVER_CONFIG
cd $CH_SERVER_LIB
for  lname in `ls -rt *.jar`
do
        CLASSPATH=$CLASSPATH:$CH_SERVER_LIB"/"$lname
done
export CLASSPATH=$CLASSPATH

