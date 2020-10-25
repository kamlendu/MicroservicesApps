#!/bin/sh
mvn clean package
docker build -t kamlendupandey/stockmanager/StockManager .
