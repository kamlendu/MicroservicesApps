#!/bin/sh
mvn clean package && docker build -t kamlendupandey/stockmanager/StockManager .
docker rm -f StockManager 2>/dev/null || true && docker run -it --name StockManager -p 8080:8080 -p 4848:4848 -p 8181:8181 --name StockManager kamlendupandey/stockmanager/StockManager
