#!/bin/sh
mvn clean package && docker build -t kamlendupandey/shopfront/ShopFront .
docker rm -f ShopFront 2>/dev/null || true && docker run -it --name ShopFront -p 8080:8080 -p 4848:4848 -p 8181:8181 --name ShopFront kamlendupandey/shopfront/ShopFront
