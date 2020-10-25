#!/bin/sh
mvn clean package && docker build -t kamlendupandey/productcatalogue/ProductCatalogue .
docker rm -f ProductCatalogue 2>/dev/null || true && docker run -it --name ProductCatalogue -p 8080:8080 -p 4848:4848 -p 8181:8181 --name ProductCatalogue kamlendupandey/productcatalogue/ProductCatalogue
