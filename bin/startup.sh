#!/bin/bash

. ./env.sh

if [ -f "$CH_SERVER_PID" ]
then
        echo "Server: $MAIN_SERVER_OBJECT  is running... ..., if you want to startup, shutdown firstly. Or restart.sh"
        exit 0
fi

echo "____________CLASSPATH_______________"
echo $CLASSPATH
echo "____________CLASSPATH_______________"

cd $CH_SERVER_HOME/bin

echo "Start $MAIN_SERVER_OBJECT ... ...."

nohup $JAVA_HOME/bin/java $MAIN_SERVRt_OPTS $MAIN_SERVER_OBJECT icbc_jzmex\
                2>&1 |cat >>$CH_SERVER_LOG/$MAIN_SERVER_OBJECT-`date +'%Y%m%d'`.log &
PROGRAM_PID=`ps -ef|grep java|grep "$MAIN_SERVER_OBJECT"|grep "icbc_jzmex"|grep -v "grep"|awk '{print $2}'`
if [ ! -z "$CH_SERVER_PID" ]
then
#        echo $! > $CH_SERVER_PID
        echo $PROGRAM_PID > $CH_SERVER_PID
fi

echo "$MAIN_SERVER_OBJECT PID: "`cat       $CH_SERVER_PID`