#!/bin/bash

already_run=`ps -ef|grep "ServiceA-1.46.17-SpringCloud2021-RELEASE"|grep -v grep|wc -l`
if [ ${already_run} -ne 0 ];then
	echo "ServiceA already Running!!!! Stop it first"
	exit -1
fi

nohup java -jar ServiceA-1.46.17-SpringCloud2021-RELEASE.jar  1>stdout.log 2>&1 &
