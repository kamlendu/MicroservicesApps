/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package event.microservices.checking.acct.listener;

import event.microservices.checking.acct.business.CheckingAcctMgr;
import event.microservices.common.dto.AccountType;
import event.microservices.common.dto.FundTransferDTO;
import event.microservices.common.util.FundTransferDTOUtil;
import fish.payara.cloud.connectors.kafka.api.KafkaConnection;
import fish.payara.cloud.connectors.kafka.api.KafkaConnectionFactory;
import fish.payara.cloud.connectors.kafka.api.KafkaListener;
import fish.payara.cloud.connectors.kafka.api.OnRecord;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "checkingAcctFundTransferListener")
    ,
    @ActivationConfigProperty(propertyName = "groupIdConfig", propertyValue = "fundTransfer")
    ,
    @ActivationConfigProperty(propertyName = "topics", propertyValue = "checkingacct-topic")
    ,
    @ActivationConfigProperty(propertyName = "bootstrapServersConfig", propertyValue = "localhost:9092")
    ,   
    @ActivationConfigProperty(propertyName = "autoCommitInterval", propertyValue = "100")
    ,   
    @ActivationConfigProperty(propertyName = "retryBackoff", propertyValue = "1000")
    ,   
    @ActivationConfigProperty(propertyName = "keyDeserializer", propertyValue = "org.apache.kafka.common.serialization.StringDeserializer")
    ,   
    @ActivationConfigProperty(propertyName = "valueDeserializer", propertyValue = "org.apache.kafka.common.serialization.StringDeserializer")
    ,   
    @ActivationConfigProperty(propertyName = "pollInterval", propertyValue = "1000"),})
public class CheckingFundTransferListener implements KafkaListener {

    private static final Logger LOGGER = Logger.getLogger(CheckingFundTransferListener.class.getName());

    //@Resource(lookup = "java:comp/env/KafkaConnectionFactory")
     @Resource(lookup = "java:app/kafka/factory")
    private KafkaConnectionFactory kafkaConnectionFactory;

    @Inject
    private CheckingAcctMgr checkingAcctMgr;

    @OnRecord(topics = {"checkingacct-topic"})
    public void transferFunds(ConsumerRecord consumerRecord) {
        String fundTransferDTOJson = (String) consumerRecord.value();
        FundTransferDTO fundTransferDTO = FundTransferDTOUtil.jsonToFundTransferDTO(fundTransferDTOJson);
        System.out.println("got transfer message : "+ fundTransferDTOJson.toString());
        if (fundTransferDTO.getSourceAcctType().equals(AccountType.CHECKING)) {
            LOGGER.log(Level.INFO, String.format("Withdrawing %.2f currency units from checking", fundTransferDTO.getAmt()));
             System.out.println("Withdrawing 100 Rs currency units from checking : ");
      
            
            if (checkingAcctMgr.withdrawFunds(fundTransferDTO)) {
                try (KafkaConnection kafkaConnection = kafkaConnectionFactory.createConnection()) {
                    kafkaConnection.send(new ProducerRecord("savingsacct-topic", fundTransferDTOJson));
                    System.out.println("Send message to saving accts"+fundTransferDTOJson.toString());
                } catch (Exception ex) {
                    Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //LOGGER.log(Level.WARNING, "There was a problem withdrawing funds from checking account, aborting transfer.");
                System.out.println("There was a problem withdrawing funds from checking account, aborting transfer.");
            }
        } else if (fundTransferDTO.getDestAcctType().equals(AccountType.CHECKING)) {
           // LOGGER.log(Level.INFO, String.format("Depositing %.2f currency units to checking", fundTransferDTO.getAmt()));
                  System.out.println("Depositing 100 currency units to checking");
        
           checkingAcctMgr.depositFunds(fundTransferDTO);
        }
    }
}
