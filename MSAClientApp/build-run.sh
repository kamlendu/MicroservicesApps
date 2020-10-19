#!/bin/sh
mvn clean package && docker build -t kamlendupandey/MSAClientApp .
docker rm -f MSAClientApp 2>/dev/null || true && docker run -it --name MSAClientApp -p 8080:8080 -p 4848:4848 -p 8181:8181 --name MSAClientApp kamlendupandey/MSAClientApp
