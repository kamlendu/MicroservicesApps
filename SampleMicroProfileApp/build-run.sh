#!/bin/sh
mvn clean package && docker build -t kamlendupandey/SampleMicroProfileApp .
docker rm -f SampleMicroProfileApp 2>/dev/null || true && docker run -it --name SampleMicroProfileApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name SampleMicroProfileApp kamlendupandey/SampleMicroProfileApp
