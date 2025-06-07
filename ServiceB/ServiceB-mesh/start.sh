#!/bin/bash

already_run=`ps -ef|grep "ServiceB-1.46.17-SpringCloud2021-RELEASE"|grep -v grep|wc -l`
if [ ${already_run} -ne 0 ];then
	echo "ServiceB already Running!!!! Stop it first"
	exit -1
fi

nohup java -jar ServiceB-1.46.17-SpringCloud2021-RELEASE.jar  1>stdout.log 2>&1 &
