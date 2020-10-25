#!/bin/sh
#deploy="false"
deploy="true"

image=StockManager
version=1.0-SNAPSHOT
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t kamlendupandey/stockmanager/${image}:1.0-SNAPSHOT .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push kamlendupandey/stockmanager/${image}:1.0-SNAPSHOT
    if [ "$latest" == "true" ]; then
        docker tag kamlendupandey/stockmanager/${image}:1.0-SNAPSHOT kamlendupandey/stockmanager/${image}:latest
        docker push kamlendupandey/stockmanager/${image}:latest
    fi
fi