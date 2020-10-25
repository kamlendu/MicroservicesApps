#!/bin/sh
mvn clean package
docker build -t kamlendupandey/shopfront/ShopFront .
