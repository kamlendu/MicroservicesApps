#!/bin/sh

RUNNING=$(docker inspect --format="{{ .State.Running }}" MSAClientApp 2> /dev/null)
if [ $? -eq 1 ] || [ "$RUNNING" == "false" ]; then
    rm -rfv ./artifact/*.war 2>/dev/null

    docker run \
     -d \
     --rm \
     --name MSAClientApp \
     -p 8080:8080 \
     -p 8181:8181 \
     -p 4848:4848 \
     -v "$(pwd)/artifact:/opt/payara/payara5/glassfish/domains/domain1/autodeploy" \
     ivonet/payara:5.193.1

    mvn clean package

    echo "Payara 5 admin console credentials:"
    echo "Website      : http://localhost:8080"
    echo "Admin console: https://localhost:4848"
    echo "Username     : admin"
    echo "Password     : secret"
else
    echo "Stopping... with title MSAClientApp"
    docker rm -f MSAClientApp
fi

