#!/bin/sh
#deploy="false"
deploy="true"

image=SampleMicroProfileApp
version=1.0
latest=true

#OPTIONS="--no-cache --force-rm"
#OPTIONS="--no-cache"
#OPTIONS="--force-rm"
OPTIONS=""

docker build ${OPTIONS} -t kamlendupandey/${image}:1.0 .
if [ "$?" -eq 0 ] && [ ${deploy} == "true" ]; then
    docker push kamlendupandey/${image}:1.0
    if [ "$latest" == "true" ]; then
        docker tag kamlendupandey/${image}:1.0 kamlendupandey/${image}:latest
        docker push kamlendupandey/${image}:latest
    fi
fi