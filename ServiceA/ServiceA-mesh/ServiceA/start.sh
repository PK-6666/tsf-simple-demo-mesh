#!/bin/bash

mkdir -p /opt/tsf/app_config/apis
cp /root/app/ServiceA/spec.yaml /opt/tsf/app_config/
cp -r /root/app/ServiceA/apis /opt/tsf/app_config/
cd /root/app/ServiceA/

java -jar ServiceA-1.29.20-Finchley-RELEASE.jar
