@echo off
call mvn clean package
call docker build -t com.mycompany/ImcProject .
call docker rm -f ImcProject
call docker run -d -p 9080:9080 -p 9443:9443 --name ImcProject com.mycompany/ImcProject