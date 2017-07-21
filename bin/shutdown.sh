#!/bin/bash

. ./env.sh

if [ ! -z "$CH_SERVER_PID" ]
then
	  echo "Stop $MAIN_SERVER_OBJECT ... ..."
      echo "Killing: `cat $CH_SERVER_PID`"
      kill -9 `cat $CH_SERVER_PID`
      rm $CH_SERVER_PID
else
      echo "Kill failed: \$CH_SERVER_PID not set"
fi