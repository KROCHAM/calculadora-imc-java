#!/bin/sh
mvn clean package && docker build -t com.mycompany/ImcProject .
docker rm -f ImcProject || true && docker run -d -p 9080:9080 -p 9443:9443 --name ImcProject com.mycompany/ImcProject