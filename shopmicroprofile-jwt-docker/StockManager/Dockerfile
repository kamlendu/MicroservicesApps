# Using the Payara Micro 5 snapshot build.

FROM payara/micro
USER root
# create a custom config folder
RUN mkdir ${PAYARA_HOME}/config
COPY domain.xml ${PAYARA_HOME}/config/
COPY mysql-connector-java-5.1.47-bin.jar ${PAYARA_HOME}/config
RUN chown -R payara:payara ${PAYARA_HOME}/config
USER payara
WORKDIR ${PAYARA_HOME}
# Deploy artefacts
COPY target/StockManager.war $DEPLOY_DIR
CMD ["--addLibs","/opt/payara/config/mysql-connector-java-5.1.47-bin.jar", "--deploymentDir", "/opt/payara/deployments", "--rootDir", "/opt/payara/config","--domainConfig", "/opt/payara/config/domain.xml"]]
