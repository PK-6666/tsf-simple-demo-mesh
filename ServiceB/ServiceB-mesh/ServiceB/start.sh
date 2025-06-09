#!/bin/bash

mkdir -p /opt/tsf/app_config/apis
cp /root/app/ServiceB/spec.yaml /opt/tsf/app_config/
cp -r /root/app/ServiceB/apis /opt/tsf/app_config/
cd /root/app/ServiceB/

java -jar ServiceB-1.46.17-SpringCloud2021-RELEASE.jar
