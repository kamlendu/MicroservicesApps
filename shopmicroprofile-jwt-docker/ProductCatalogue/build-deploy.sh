#!/bin/sh
#deploy="false"
deploy="true"

image=ProductCatalogue
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t kamlendupandey/productcatalogue/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push kamlendupandey/productcatalogue/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag kamlendupandey/productcatalogue/${image}:1.0-SNAPSHOT kamlendupandey/productcatalogue/${image}:latest
        docker push kamlendupandey/productcatalogue/${image}:latest
    fi
fi