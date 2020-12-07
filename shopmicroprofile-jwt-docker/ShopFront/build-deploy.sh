#!/bin/sh
#deploy="false"
deploy="true"

image=ShopFront
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t kamlendupandey/shopfront/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push kamlendupandey/shopfront/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag kamlendupandey/shopfront/${image}:1.0-SNAPSHOT kamlendupandey/shopfront/${image}:latest
        docker push kamlendupandey/shopfront/${image}:latest
    fi
fi