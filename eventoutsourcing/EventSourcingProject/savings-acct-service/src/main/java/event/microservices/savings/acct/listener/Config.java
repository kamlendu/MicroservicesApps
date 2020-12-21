/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.savings.acct.listener;

import javax.enterprise.context.ApplicationScoped;
import javax.resource.ConnectionFactoryDefinition;

/**
 *
 * @author root
 */
@ApplicationScoped
@ConnectionFactoryDefinition (
name = "java:app/kafka/factory",
interfaceName = "fish.payara.cloud.connectors.kafka.KafkaConnectionFactory",
resourceAdapter= "kafka-rar-0.1.0"
)
public class Config {
    
}
